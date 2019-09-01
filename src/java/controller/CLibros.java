/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOLibreriaImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Libros;
import model.Areas;
import model.Reservas;


/**
 *
 * @author Ciriusblb
 */
public class CLibros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            HttpSession sesion = request.getSession();
            List<Libros> datos = new ArrayList<>();
            List<Areas> areas = new ArrayList<>();
            List<Reservas> reservas = new ArrayList<>();
            DAOLibreriaImpl dao = null;
            RequestDispatcher rd = null;
            String id = null;
            try {
                dao = new DAOLibreriaImpl();
                areas = dao.listarAreas();
                for (Areas item : areas) {
                    if(item.getNombre_area().equals(request.getParameter("Area"))){
                        id = item.getId();
                        break;
                    }
                }
                datos = dao.listarLibros(id);
                reservas = dao.listarReservas(sesion.getAttribute("codigo").toString());
                for (Libros item : datos) {
                    for (Reservas item2 : reservas) {
                        if(item.getId().equals(item2.getLibros_id())){
                            item.setReservado("Reservado");
                            break;
                        }
                    }  
                }
                request.setAttribute("respuesta", datos);
                if(request.getParameter("salir")!=null){
                    sesion.invalidate();
                    response.sendRedirect("CLogin");
                    return;
                } 
                rd = request.getRequestDispatcher("/libro.jsp");
            } catch (Exception e) {
            }
            rd.forward(request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Reservas objreservas = new Reservas();
                String msj = null;
                objreservas.setLibros_id(request.getParameter("idLibro"));
		objreservas.setUsuario_codigo(request.getParameter("codigoUsuario"));
		LocalDateTime ldt = LocalDateTime.now();
                objreservas.setFecha(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(ldt));
                DAOLibreriaImpl dao = new DAOLibreriaImpl();
                try {
                    msj = dao.reservar(objreservas);
                } catch (Exception ex) {
                    Logger.getLogger(CLibros.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.setContentType("text/plain"); 
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(msj);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

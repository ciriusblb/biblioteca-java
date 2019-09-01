/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOLibreriaImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Reservas;
import model.Usuario;

/**
 *
 * @author Ciriusblb
 */
public class CUsuario extends HttpServlet {

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
            HttpSession miSesion = request.getSession(true);
            RequestDispatcher rd = null;
            List<Reservas> datos = new ArrayList<>();
            List<Usuario> usuario = new ArrayList<>();
            DAOLibreriaImpl dao = null;
            miSesion.setAttribute("m", "");            
            try {
                dao = new DAOLibreriaImpl();
                datos = dao.listarReservados(miSesion.getAttribute("codigo").toString());
                usuario = dao.getUser(miSesion.getAttribute("codigo").toString());
                request.setAttribute("respuesta", datos);
                request.setAttribute("miUsuario", usuario);
                if(request.getParameter("salir")!=null){
                    HttpSession sesion = request.getSession();
                    sesion.invalidate();
                    response.sendRedirect("CLogin");
                    return;
                } 
                rd = request.getRequestDispatcher("/perfil.jsp");
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
                String msj = null;
                DAOLibreriaImpl dao = new DAOLibreriaImpl();
                try {
                    msj = dao.cancelarReserva(request.getParameter("id_reserva"));
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

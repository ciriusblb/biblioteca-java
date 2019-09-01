/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Areas;
import model.Libros;
import model.Login;
import model.Reservas;
import model.Usuario;

/**
 *
 * @author Ciriusblb
 */
public class DAOLibreriaImpl extends Conexion implements IDAOLibreria{

    @Override
    public Login loguear(Login objlogin) throws Exception {
        Login objLogin = new Login();
        try {
            this.conectar();
            PreparedStatement pst;
            String sql = "select * from usuario_log where usuario_general_codigo =? and password = ?;";
            pst = this.conexion.prepareStatement(sql);
            pst.setString(1, objlogin.getCodigo());
            pst.setString(2, objlogin.getContrasena());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                objLogin.setCodigo(rs.getString("usuario_general_codigo"));
                objLogin.setContrasena(rs.getString("password"));
                objLogin.setNombre(rs.getString("nombre"));
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return objLogin;
    }

    @Override
    public List<Areas> listarAreas() throws Exception {
        List<Areas> lista = new ArrayList();    
        try {
            this.conectar();
            String sql = "select * from areas";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Areas objAreas = new Areas();
                objAreas.setId(rs.getString("id"));
                objAreas.setNombre_area(rs.getString("nombre_area"));
                lista.add(objAreas);
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Libros> listarLibros(String areas_id) throws Exception {
         List<Libros> lista = new ArrayList();    
        try {
            this.conectar();
            String sql = "select * from libros where areas_id = '" +areas_id +"'";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Libros objLibros = new Libros();
                objLibros.setId(rs.getString("id"));
                objLibros.setNombre(rs.getString("nombre"));
                objLibros.setAutor(rs.getString("autor"));
                objLibros.setVolumen(rs.getString("volumen"));
                objLibros.setPdf(rs.getString("pdf"));
                objLibros.setAreas_id(rs.getString("areas_id"));
                lista.add(objLibros);
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public String reservar(Reservas objreservas) throws Exception {
        Integer theID;
        String newID; 
        try {
            this.conectar();
            PreparedStatement pst;
            String sql = "SELECT MAX(id_reserva) AS id_reserva FROM reservas;";
            pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                if(rs.getString("id_reserva")==null){
                    objreservas.setId_reserva("1");
                }else{
                    theID = Integer.parseInt(rs.getString("id_reserva"))+1;
                    newID = theID.toString();
                    objreservas.setId_reserva(newID);
                }
            }
            String query = "SELECT * FROM usuario_log WHERE usuario_log.usuario_general_codigo = " + objreservas.getUsuario_codigo() + " ";
            Statement stmt = this.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                objreservas.setUsuario_codigo(res.getString("codigo"));
            }
            String query2 = "INSERT INTO `reservas` (`id_reserva`, `libros_id`, `usuario_codigo`, `fecha`)"
                    + " VALUES ('"+objreservas.getId_reserva()+"', '"+objreservas.getLibros_id()+"', '"+objreservas.getUsuario_codigo()+"', '"+objreservas.getFecha()+"')";
            Statement stmt2 = this.conexion.createStatement();
            stmt2.executeUpdate(query2);
        } catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return "Reservado";
    }

    @Override
    public List<Reservas> listarReservas(String codigo_usuario) throws Exception {
        List<Reservas> lista = new ArrayList(); 
        String codigo = null;
        try {
            this.conectar();
            String query = "SELECT * FROM usuario_log WHERE usuario_log.usuario_general_codigo = " + codigo_usuario + " ";
            Statement stmt = this.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                codigo = res.getString("codigo");
            }
            
            String sql = "select * from reservas where usuario_codigo = '" + codigo +"'";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Reservas objReservas = new Reservas();
                objReservas.setId_reserva(rs.getString("id_reserva"));
                objReservas.setLibros_id(rs.getString("libros_id"));
                objReservas.setUsuario_codigo(rs.getString("usuario_codigo"));
                objReservas.setFecha(rs.getString("fecha"));
                lista.add(objReservas);
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Reservas> listarReservados(String codigo_usuario) throws Exception {
        List<Reservas> lista = new ArrayList();    
        try {
            this.conectar();
            String sql = "call getReservas('"+ codigo_usuario +"')";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Reservas objReservas = new Reservas();
                objReservas.setId_reserva(rs.getString("id_reserva"));
                objReservas.setLibros_id(rs.getString("id"));
                objReservas.setNombre(rs.getString("nombre"));
                objReservas.setAutor(rs.getString("autor"));
                objReservas.setFecha(rs.getString("fecha"));
                lista.add(objReservas);
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public List<Usuario> getUser(String codigo_usuario) throws Exception {
        List<Usuario> lista = new ArrayList();
        try {
            this.conectar();
            PreparedStatement pst;
            String sql = "select * from usuario_log where usuario_general_codigo =?;";
            pst = this.conexion.prepareStatement(sql);
            pst.setString(1, codigo_usuario);
            ResultSet rs = pst.executeQuery();
           
            if (rs.next()){
                Usuario objUsuario = new Usuario();
                objUsuario.setCodigo(rs.getString("codigo"));
                objUsuario.setNombre(rs.getString("nombre"));
                objUsuario.setFoto(rs.getString("foto"));
                objUsuario.setUsuario_general_codigo(rs.getString("usuario_general_codigo"));
                lista.add(objUsuario);
            }
            rs.close();
            pst.close();
        } catch (ClassNotFoundException | SQLException e){
            return null;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public String cancelarReserva(String res) throws Exception {
        String msj = "";
        try{
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM reservas WHERE reservas.id_reserva = ?");
            st.setString(1, res);
            st.executeUpdate();
            msj = "Se ha eliminado correctamente";
        }catch(SQLException e){
            throw e;
        }finally{
            this.cerrar();
        }
        return msj;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public interface IDAOLibreria {
    public Login loguear(Login objlogin) throws Exception;
    public List<Areas> listarAreas() throws Exception;
    public List<Libros> listarLibros(String areas_id) throws Exception;
    public List<Reservas> listarReservas(String codigo_usuario) throws Exception;
    public String reservar(Reservas objreservas) throws Exception;
    public List<Reservas> listarReservados(String codigo_usuario) throws Exception;
    public List<Usuario> getUser(String codigo_usuario) throws Exception;
    public String cancelarReserva(String res) throws Exception;



}

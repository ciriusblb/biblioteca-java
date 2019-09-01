/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ciriusblb
 */
public class Reservas {
    private String id_reserva;
    private String libros_id;
    private String usuario_codigo;
    private String fecha;
    private String nombre;
    private String autor;

    public Reservas(String id_reserva, String libros_id, String usuario_codigo, String fecha, String nombre, String autor) {
        this.id_reserva = id_reserva;
        this.libros_id = libros_id;
        this.usuario_codigo = usuario_codigo;
        this.fecha = fecha;
        this.nombre = nombre;
        this.autor = autor;

    }

    public Reservas() {
        this.id_reserva = "";
        this.libros_id = "";
        this.usuario_codigo = "";
        this.fecha = "";
        this.nombre = "";
        this.autor = "";
    }

    /**
     * @return the id_reserva
     */
    public String getId_reserva() {
        return id_reserva;
    }

    /**
     * @param id_reserva the id_reserva to set
     */
    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    /**
     * @return the libros_id
     */
    public String getLibros_id() {
        return libros_id;
    }

    /**
     * @param libros_id the libros_id to set
     */
    public void setLibros_id(String libros_id) {
        this.libros_id = libros_id;
    }

    /**
     * @return the usuario_codigo
     */
    public String getUsuario_codigo() {
        return usuario_codigo;
    }

    /**
     * @param usuario_codigo the usuario_codigo to set
     */
    public void setUsuario_codigo(String usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}

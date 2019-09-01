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
public class Usuario {
    private String codigo;
    private String nombre;
    private String foto;
    private String usuario_general_codigo;
    private String password;

    public Usuario(String codigo, String nombre, String foto, String usuario_general_codigo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.foto = foto;
        this.usuario_general_codigo = usuario_general_codigo;
        this.password = password;
    }

    public Usuario() {
        this.codigo = "";
        this.nombre = "";
        this.foto = "";
        this.usuario_general_codigo = "";
        this.password = "";
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the usuario_general_codigo
     */
    public String getUsuario_general_codigo() {
        return usuario_general_codigo;
    }

    /**
     * @param usuario_general_codigo the usuario_general_codigo to set
     */
    public void setUsuario_general_codigo(String usuario_general_codigo) {
        this.usuario_general_codigo = usuario_general_codigo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}

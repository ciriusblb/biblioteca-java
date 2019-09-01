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
public class Libros {
    private String id;
    private String nombre;
    private String autor;
    private String volumen;
    private String pdf;
    private String areas_id;
    private String reservado;


    public Libros(String id, String nombre, String autor, String volumen, String pdf, String areas_id, String reservado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.volumen = volumen;
        this.pdf = pdf;
        this.areas_id = areas_id;
        this.reservado = reservado;
    }

    public Libros() {
        this.id = "";
        this.nombre =  "";
        this.autor =  "";
        this.volumen =  "";
        this.pdf =  "";
        this.areas_id =  "";
        this.reservado =  "";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * @return the volumen
     */
    public String getVolumen() {
        return volumen;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    /**
     * @return the pdf
     */
    public String getPdf() {
        return pdf;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    /**
     * @return the areas_id
     */
    public String getAreas_id() {
        return areas_id;
    }

    /**
     * @param areas_id the areas_id to set
     */
    public void setAreas_id(String areas_id) {
        this.areas_id = areas_id;
    }

    /**
     * @return the reservado
     */
    public String getReservado() {
        return reservado;
    }

    /**
     * @param reservado the reservado to set
     */
    public void setReservado(String reservado) {
        this.reservado = reservado;
    }
    
}

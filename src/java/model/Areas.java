/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author Ciriusblb
 */
public class Areas {
    private String id;
    private String nombre_area;
    private String clase;

    public Areas(String id, String nombre_area, String clase) {
        this.id = id;
        this.nombre_area = nombre_area;
        this.clase = clase;

    }

    public Areas() {
        this.id = "";
        this.nombre_area = "";
        this.clase = "";

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
     * @return the nombre_area
     */
    public String getNombre_area() {
        return nombre_area;
    }

    /**
     * @param nombre_area the nombre_area to set
     */
    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }
    
}

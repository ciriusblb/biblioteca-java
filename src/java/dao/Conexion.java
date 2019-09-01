/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ciriusblb
 */
public class Conexion {
    protected Connection conexion;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/libreria";
    public void conectar() throws Exception{
        try{
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(url,usuario,pass);

        } catch (Exception e) {
            throw e;
        }    
    }
    public void cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}

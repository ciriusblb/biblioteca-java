/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import model.Login;
import model.Reservas;

/**
 *
 * @author Ciriusblb
 */
public class main {
    DAOLibreriaImpl dao = null;
    Login login = new Login();
        Reservas reservas = new Reservas();
        public main() throws SQLException, Exception {
        dao = new DAOLibreriaImpl();
    }
}

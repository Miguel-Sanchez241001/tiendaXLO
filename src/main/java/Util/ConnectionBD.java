/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author rody_
 */
public class ConnectionBD {

    private static Connection conn;

    public static Connection getConexionBD() {
      if ( conn != null )
            return conn;

        try {
            String usuario = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/xlo?useSSL=false&serverTimezone=UTC";

            // Establecer el Driver de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);

            System.out.println("Conectamos");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Algo salio mal :( ");
        }
        return conn;
    }

    public static void main(String[] args) {
        getConexionBD();
        
    }

}

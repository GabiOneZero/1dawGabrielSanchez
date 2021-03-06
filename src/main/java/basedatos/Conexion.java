/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 * @version 1.0
 * @since 16 jun. 2020
 */
public class Conexion {

    private static final String SERVIDOR = "jdbc:mysql://127.0.0.1/";
    private static final String NOMBRE_BASE_DATOS = "bingoBD";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection instancia = null;

    // Constructor privado no accesible desde otras clases
    private Conexion() {

    }

    // Método de clase para acceder a la instancia del objeto Connection
    public static Connection getInstance() {
        // Si el objeto Connection no está creado, se crea

        if (instancia == null) {

           
            try {

                // Se crea el objeto Connection	
                instancia = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

                System.out.println("Conexión realizada con éxito.");

            } catch (SQLException e) {

                // Error en la conexión
                System.out.println("Conexión fallida: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        return instancia;
    }

}

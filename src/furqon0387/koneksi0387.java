/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furqon0387;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author furqo
 */
public class koneksi0387 {
    private Connection koneksi0387;
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi "+ex);
        }
        String url = "jdbc:mysql://localhost:3306/db_pdam";
        try {
            koneksi0387 = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            System.out.println("Gagal Koneksi Database "+ex);
        }
        return koneksi0387;
    } 
}

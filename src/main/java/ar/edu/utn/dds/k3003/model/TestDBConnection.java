package ar.edu.utn.dds.k3003.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
        public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://dpg-cpm9qatds78s73aetgt0-a.oregon-postgres.render.com/dds_xj53";
            String username = "dds";
            String password = "vOfROz9PJ0erkqR0QMar9AxWlc6VUjQI";
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

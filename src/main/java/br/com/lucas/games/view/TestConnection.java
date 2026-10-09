package br.com.lucas.games.view;

import br.com.lucas.games.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("Connected!");
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

package br.com.lucas.games.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // dot not this like the professor, add a try catch, will facility your life
    public static Connection getConnection() throws SQLException {
        String host = "localhost";
        String port = "1521";
        String SIDOrService = "FREE";

        // jdbc:oracle:thin:@localhost:1521:free
        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + SIDOrService;
        String user = "C##DB_GAME_USER";
        String password = "426970";

        Connection conn = DriverManager.getConnection(url, user, password);
        if (conn != null) {
            System.out.println("Connection stabilized with success!");
        }
        return conn;
    }
}

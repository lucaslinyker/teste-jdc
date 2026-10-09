package br.com.lucas.games.dao;

import br.com.lucas.games.factory.ConnectionFactory;
import br.com.lucas.games.model.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {
    private Connection conn;

    public GameDAO(Connection conn) throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }

    /*public void register(Game game) {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO tb_game (cd_game, nm_game, nr_nota, nr_ano, dt_compra, stfinalizado) " +
                        "VALUES (sq_tb_game.nextval, ?, ?, ?, ?, ?)");
        stmt.setString(1, game.getName());
        stmt.setInt(2, game.getNota());
        stmt.setInt(3, game.getAno());
        stmt.setDate(4, game.getCompra());
        stmt.setBoolean(5, game.getFinalizado());
        stmt.executeUpdate();
        stmt.close();
    }*/

    /*public Game searchById(int id) {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_game WHERE cd_game = ?");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            System.out.println("Jogo não encontrado.");
            return null;
        }

        return null;
    }*/

    public void closeConn() throws SQLException {
        conn.close();
    }
}

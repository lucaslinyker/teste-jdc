package br.com.lucas.games.dao;

import br.com.lucas.games.exception.EntidadeNaoEncontradaException;
import br.com.lucas.games.factory.ConnectionFactory;
import br.com.lucas.games.model.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
    private Connection conn;

    public GameDAO() throws SQLException {
        conn = ConnectionFactory.getConnection();
    }

    public void register(Game game) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO tb_game (cd_game, nm_game, nr_nota, nr_ano, dt_compra, st_finalizado) " +
                        "VALUES (sq_tb_game.nextval, ?, ?, ?, ?, ?)");

        stmt.setString(1, game.getName());
        stmt.setDouble(2, game.getNota());
        stmt.setInt(3, game.getYear());
        stmt.setObject(4, game.getDataCompra());
        stmt.setBoolean(5, game.isFinalizado());

        stmt.executeUpdate();
        stmt.close();
    }

    public Game findById(int id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_game WHERE cd_game = ?");
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            throw new EntidadeNaoEncontradaException("Jogo não encontrado");
        }

        return getGame(resultSet);
    }

    private static Game getGame(ResultSet resultSet) throws SQLException {
        int code = resultSet.getInt("cd_game");
        String name = resultSet.getString("nm_game");
        double nota = resultSet.getDouble("nr_nota");
        int ano = resultSet.getInt("nr_ano");
        LocalDate dataCompra = resultSet.getObject("dt_compra", LocalDate.class);
        boolean finalizado = resultSet.getBoolean("st_finalizado");

        return new Game(code, name, nota, ano, dataCompra, finalizado);
    }

    public List<Game> list() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_game");
        ResultSet resultSet = stmt.executeQuery();
        List<Game> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(getGame(resultSet));
        }
        return list;
    }

    public void update(Game game) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE tb_game SET nm_game = ?, nr_nota = ?, nr_ano = ?, dt_compra = ?, st_finalizado = ? WHERE cd_game = ?");
        stmt.setString(1, game.getName());
        stmt.setDouble(2, game.getNota());
        stmt.setInt(3, game.getYear());
        stmt.setObject(4, game.getDataCompra());
        stmt.setBoolean(5, game.isFinalizado());
        stmt.setInt(6, game.getCode());
        int lines = stmt.executeUpdate();
        if (lines == 0)
            throw new EntidadeNaoEncontradaException("Não tem game para atualizar!");
    }

    public void deleteById(int id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb_game WHERE cd_game = ?");
        stmt.setInt(1, id);
        int lines = stmt.executeUpdate();
        if (lines == 0)
            throw new EntidadeNaoEncontradaException("Id não encontrado para remoção!");
    }

    public void closeConn() throws SQLException {
        conn.close();
    }
}

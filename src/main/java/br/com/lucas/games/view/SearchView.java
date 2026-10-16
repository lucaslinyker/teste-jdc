package br.com.lucas.games.view;

import br.com.lucas.games.dao.GameDAO;
import br.com.lucas.games.exception.EntidadeNaoEncontradaException;
import br.com.lucas.games.model.Game;

import java.sql.SQLException;

public class SearchView {
    public static void main(String[] args) {
        try {
            GameDAO dao = new GameDAO();
            Game game = dao.findById(1);
            System.out.println(game);
            dao.closeConn();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Código não existe " + e.getMessage());
        }
    }
}

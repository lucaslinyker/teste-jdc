package br.com.lucas.games.view;

import br.com.lucas.games.dao.GameDAO;
import br.com.lucas.games.model.Game;

import java.sql.SQLException;
import java.util.List;

public class ListView {
    public static void main(String[] args) {
        try {
            GameDAO dao = new GameDAO();
            List<Game> list = dao.list();
            for (Game game : list) {
                System.out.println(game);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

package br.com.lucas.games.view;

import br.com.lucas.games.dao.GameDAO;
import br.com.lucas.games.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class DeleteView {
    public static void main(String[] args) {
        try {
            GameDAO dao = new GameDAO();
            dao.deleteById(1);
            System.out.println("Game removido!");
            dao.closeConn();
        } catch (SQLException | EntidadeNaoEncontradaException e) {
            System.err.println(e.getMessage());
        }
    }
}

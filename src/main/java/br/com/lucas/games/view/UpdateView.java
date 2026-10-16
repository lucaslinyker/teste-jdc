package br.com.lucas.games.view;

import br.com.lucas.games.dao.GameDAO;
import br.com.lucas.games.exception.EntidadeNaoEncontradaException;
import br.com.lucas.games.model.Game;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class UpdateView {
    public static void main(String[] args) {
        try {
            GameDAO dao = new GameDAO();
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o código do jogo");
            int code = sc.nextInt();

            System.out.println("Digite o nome do jogo");
            String name = sc.next() + sc.nextLine();

            System.out.println("Digite a nota");
            double nota = sc.nextDouble();

            System.out.println("Digite o ano");
            int year = sc.nextInt();

            System.out.println("Esta finalizado? s/n");
            boolean finished = sc.next().equals("s");

            System.out.println("Digite a data de cadastro yyyy-mm-dd");
            LocalDate dateCompra = LocalDate.parse(sc.next());

            Game game = new Game(code, name, nota, year, dateCompra, finished);
            dao.update(game);
            System.out.println("Jogo atualizado com sucesso!");
            dao.closeConn();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

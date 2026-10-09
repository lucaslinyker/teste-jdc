package br.com.lucas.games.model;

import java.time.LocalDate;

public class Game {
    private int code;
    private String name;
    private double nota;
    private int year;
    private LocalDate dataCompra;

    public Game() {
    }

    public Game(String name, double nota, int year, LocalDate dataCompra) {
        this.name = name;
        this.nota = nota;
        this.year = year;
        this.dataCompra = dataCompra;
    }

    public Game(int code, String name, double nota, int year, LocalDate dataCompra) {
        this.code = code;
        this.name = name;
        this.nota = nota;
        this.year = year;
        this.dataCompra = dataCompra;
    }

    public Game setCode(int code) {
        this.code = code;
        return this;
    }

    public Game setName(String name) {
        this.name = name;
        return this;
    }

    public Game setNota(double nota) {
        this.nota = nota;
        return this;
    }

    public Game setYear(int year) {
        this.year = year;
        return this;
    }

    public Game setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }
}

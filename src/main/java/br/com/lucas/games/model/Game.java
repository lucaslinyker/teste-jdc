package br.com.lucas.games.model;

import java.time.LocalDate;

public class Game {
    private int code;
    private String name;
    private double nota;
    private int year;
    private LocalDate dataCompra;
    private boolean finalizado;

    public Game() {
    }

    public Game(String name, double nota, int year, LocalDate dataCompra, boolean finalizado) {
        this.name = name;
        this.nota = nota;
        this.year = year;
        this.dataCompra = dataCompra;
        this.finalizado = finalizado;
    }

    public Game(int code, String name, double nota, int year, LocalDate dataCompra, boolean finalizado) {
        this.code = code;
        this.name = name;
        this.nota = nota;
        this.year = year;
        this.dataCompra = dataCompra;
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Game{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", nota=" + nota +
                ", year=" + year +
                ", dataCompra=" + dataCompra +
                ", finalizado=" + finalizado +
                '}';
    }

    public int getCode() {
        return code;
    }

    public Game setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Game setName(String name) {
        this.name = name;
        return this;
    }

    public double getNota() {
        return nota;
    }

    public Game setNota(double nota) {
        this.nota = nota;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Game setYear(int year) {
        this.year = year;
        return this;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public Game setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
        return this;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public Game setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
        return this;
    }
}

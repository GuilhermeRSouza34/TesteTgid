package com.testeJava.Guilherme.model;

import java.time.LocalDateTime;

public class Transacao {

    private LocalDateTime data;
    private TipoTransacao tipo;
    private double valor;

    // Construtor, getters e setters

    public Transacao() {
    }

    public Transacao(LocalDateTime data, TipoTransacao tipo, double valor) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
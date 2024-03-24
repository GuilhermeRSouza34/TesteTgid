package com.testeJava.Guilherme.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSaldo() {
        return null;
    }

    public String getNome() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public <E> List<E> getTransacoes() {
        return null;
    }

    public void setSaldo(String novoSaldo) {
    }

    public void setSaldo(double v) {
    }
}
package com.testeJava.Guilherme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    @OneToMany(mappedBy = "empresa")
    private List<Taxa> taxas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Taxa> getTaxas() {
        return taxas;
    }

    public void setTaxas(List<Taxa> taxas) {
        this.taxas = taxas;
    }

    public double getSaldo() {
        return 0;
    }

    public void setSaldo(double saldoAtualizado) {
    }

    public Object getNome() {
        return null;
    }
}
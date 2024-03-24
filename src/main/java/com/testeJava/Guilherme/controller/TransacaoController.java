package com.testeJava.Guilherme.controller;

import com.testeJava.Guilherme.model.Cliente;
import com.testeJava.Guilherme.model.Empresa;
import com.testeJava.Guilherme.model.TipoTransacao;
import com.testeJava.Guilherme.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/transacao")
    public void realizarTransacao(@RequestBody TransacaoRequest request) {
        transacaoService.realizarTransacao(request.getEmpresa(), request.getCliente(), request.getValor(), request.getTipo());
    }

    // Classe interna para representar o pedido de transação
    static class TransacaoRequest {
        private Empresa empresa;
        private Cliente cliente;
        private double valor;
        private TipoTransacao tipo;

        public Empresa getEmpresa() {
            return empresa;
        }

        public void setEmpresa(Empresa empresa) {
            this.empresa = empresa;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public TipoTransacao getTipo() {
            return tipo;
        }

        public void setTipo(TipoTransacao tipo) {
            this.tipo = tipo;
        }

        // getters e setters
    }
}
package com.testeJava.Guilherme.service;

import com.testeJava.Guilherme.model.Cliente;
import com.testeJava.Guilherme.model.Empresa;
import com.testeJava.Guilherme.model.TipoTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final NotificacaoService notificacaoService;

    @Autowired
    public TransacaoService(EmpresaService empresaService, ClienteService clienteService, NotificacaoService notificacaoService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
        this.notificacaoService = notificacaoService;
    }

    public void realizarTransacao(Empresa empresa, Cliente cliente, double valor, TipoTransacao tipo) {
        // Verificar se a empresa tem saldo suficiente para a transação
        if (!empresaTemSaldoSuficiente(empresa, valor)) {
            throw new TransacaoException("A empresa não tem saldo suficiente para realizar esta transação.");
        }

        // Atualizar o saldo da empresa após a transação
        atualizarSaldoEmpresa(empresa, valor, tipo);

        // Enviar callback para a empresa (simulado com um log)
        enviarCallbackEmpresa(empresa, cliente, valor, tipo);

        // Notificar o cliente sobre a transação
        notificarCliente(cliente, "Transação realizada com sucesso. Seu saldo atual é: " + cliente.getSaldo());

        // Atualizar o histórico de transações do cliente
        clienteService.adicionarTransacaoCliente(cliente, LocalDateTime.now(), tipo, valor);
    }

    private boolean empresaTemSaldoSuficiente(Empresa empresa, double valor) {
        return empresa.getSaldo() >= valor;
    }

    private void atualizarSaldoEmpresa(Empresa empresa, double valor, TipoTransacao tipo) {
        double saldoAtualizado;
        if (tipo == TipoTransacao.SAQUE) {
            saldoAtualizado = empresa.getSaldo() - valor;
        } else {
            saldoAtualizado = empresa.getSaldo() + valor;
        }
        empresa.setSaldo(saldoAtualizado);
        empresaService.atualizarEmpresa(empresa);
    }

    private void enviarCallbackEmpresa(Empresa empresa, Cliente cliente, double valor, TipoTransacao tipo) {
        // Simulação de callback com um log
        System.out.printf("Callback enviado para empresa %s: Transação de %s no valor de %s realizada para o cliente %s%n", empresa.getNome(), tipo.name(), valor, cliente.getNome());
    }

    private void notificarCliente(Cliente cliente, String mensagem) {
        notificacaoService.enviarNotificacao(cliente.getEmail(), mensagem);
    }
}
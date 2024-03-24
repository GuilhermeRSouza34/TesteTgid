package com.testeJava.Guilherme.service;

import com.testeJava.Guilherme.model.Cliente;
import com.testeJava.Guilherme.model.TipoTransacao;
import com.testeJava.Guilherme.model.Transacao;
import com.testeJava.Guilherme.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Adiciona uma transação ao cliente e atualiza seu saldo.
     *
     * @param cliente O cliente para o qual a transação será adicionada.
     * @param data A data da transação.
     * @param tipo O tipo da transação (saque ou depósito).
     * @param valor O valor da transação.
     */
    public void adicionarTransacaoCliente(Cliente cliente, LocalDateTime data, TipoTransacao tipo, double valor) {
        Transacao transacao = new Transacao();
        transacao.setData(data);
        transacao.setTipo(tipo);
        transacao.setValor(valor);

        if (tipo == TipoTransacao.SAQUE) {
            double novoSaldo = Double.parseDouble(cliente.getSaldo()) - valor;
            if (novoSaldo < 0) {
                throw new RuntimeException("Saldo insuficiente para realizar o saque");
            }
            cliente.setSaldo(String.valueOf(novoSaldo));
        } else {
            double novoSaldo = Double.parseDouble(cliente.getSaldo() + valor);
            cliente.setSaldo(String.valueOf(novoSaldo));
        }

        cliente.getTransacoes().add(transacao);
        clienteRepository.save(cliente);
    }
}
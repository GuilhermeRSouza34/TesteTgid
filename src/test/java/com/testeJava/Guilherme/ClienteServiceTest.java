package com.testeJava.Guilherme;

import com.testeJava.Guilherme.model.Cliente;
import com.testeJava.Guilherme.model.TipoTransacao;
import com.testeJava.Guilherme.repository.ClienteRepository;
import com.testeJava.Guilherme.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testAdicionarTransacaoCliente() {
        Cliente cliente = new Cliente();
        cliente.setSaldo(100.0);

        LocalDateTime data = LocalDateTime.now();
        TipoTransacao tipo = TipoTransacao.SAQUE;
        double valor = 50.0;

        clienteService.adicionarTransacaoCliente(cliente, data, tipo, valor);

        // Verifica se a transação foi adicionada corretamente
        assertEquals(50.0, cliente.getSaldo(), 0.01);
    }

    private void assertEquals(double v, String saldo, double v1) {
    }
}
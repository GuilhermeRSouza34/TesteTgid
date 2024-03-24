package com.testeJava.Guilherme.service;

import com.testeJava.Guilherme.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    public void notificarCliente(Cliente cliente, String mensagem) {
        // Lógica para notificar o cliente (pode ser por e-mail, SMS, etc.)
        System.out.println("Notificação enviada para " + cliente.getCpf() + ": " + mensagem);
    }

    public void enviarNotificacao(Object email, String mensagem) {
    }
}
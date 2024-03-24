package com.testeJava.Guilherme.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class CallbackService {

    private final RestTemplate restTemplate;

    public CallbackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarCallback(String url, String mensagem) {
        restTemplate.postForObject(url, mensagem, Void.class);
    }
}
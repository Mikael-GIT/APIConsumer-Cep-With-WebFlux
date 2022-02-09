package com.consulta.apicorreios.controllers;

import com.consulta.dtos.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ConsultCepService {

    @Autowired
    private WebClient webClient;

    public Mono<Address> getCepById(String cep) {
        Mono<Address> addressMono = this.webClient.method(HttpMethod.GET)
            .uri("/{cep}/json/", cep)
            .retrieve()
            .bodyToMono(Address.class);

        Address address = addressMono.block();
        return Mono.just(address);
    }

}

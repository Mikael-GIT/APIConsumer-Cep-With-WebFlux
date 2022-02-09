package com.consulta.apicorreios.controllers;

import com.consulta.dtos.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/cep")
public class ConsultCepController {
    
    @Autowired
    private ConsultCepService service;
    
    @GetMapping("/{cep}")
    public ResponseEntity<Mono<Address>> getAddressByCep(@PathVariable String cep) throws InterruptedException{
        return ResponseEntity.ok(service.getCepById(cep));
    }
}
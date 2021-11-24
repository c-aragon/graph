package com.example.graph.controller;

import com.example.graph.entity.Numero;
import com.example.graph.repository.NumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NumberController {

    private NumeroRepository numeroRepository;

    @Autowired
    public NumberController(final NumeroRepository numeroRepository) {
        this.numeroRepository = numeroRepository;
    }

    @GetMapping
    public List<Numero> getNumeros() {
        return numeroRepository.findAll();
    }

}

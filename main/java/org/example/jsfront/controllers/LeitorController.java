package org.example.jsfront.controllers;

import org.example.jsfront.models.Leitor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.jsfront.useCases.LeitorService;

import java.util.List;

@RestController
@RequestMapping("/leitor")
public class LeitorController {
    private final LeitorService service;
    public LeitorController( LeitorService service){
        this.service=service;
    }
    @PostMapping("/criar")
    public ResponseEntity criarLeitor(@RequestBody Leitor novoLeitor){
        service.criarLeitor(novoLeitor);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Leitor>> listar(){

        return ResponseEntity.ok().body(service.listar());
    }
}

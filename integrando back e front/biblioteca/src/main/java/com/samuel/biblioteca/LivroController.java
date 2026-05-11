package com.samuel.biblioteca;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/livraria")
public class LivroController {
    private LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String falar() {
        return service.fala();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(200).body(service.listar());

    }

    @GetMapping("/buscar")
    public List<Livro> findByNome(@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @PostMapping("/salvar")
    public void save(Livro livro) {
        service.save(livro);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro livro = service.findById(id);
        return ResponseEntity.ok(livro);

    }
}

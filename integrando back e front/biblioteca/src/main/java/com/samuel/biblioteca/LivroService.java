package com.samuel.biblioteca;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private LivroRepository repo;

    public LivroService(LivroRepository repo) {
        this.repo = repo;
    }

    public String fala() {
        return "oi,eu sou o samuel!";
    }

    public List<Livro> listar() {
        return repo.findAll();
    }

    public List<Livro> findByNome(String nome)  {
        if (this.repo.existsByNome(nome)) {
            return repo.findByNome(nome);
        }
        throw new RuntimeException("livro nao encontrado");

    }

    public void save(Livro livro) {
        this.repo.save(livro);

    }

    public Livro findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("livro nao encontrado"));
    }
}

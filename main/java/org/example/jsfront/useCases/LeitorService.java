package org.example.jsfront.useCases;

import org.example.jsfront.models.Leitor;
import org.springframework.stereotype.Service;
import org.example.jsfront.repositories.LeitorRepository;

import java.util.List;


@Service
public class LeitorService {
    private final LeitorRepository repo;

public LeitorService(LeitorRepository repo) {
    this.repo=repo;
}
public void criarLeitor(Leitor novoLeitor){
    repo.save(novoLeitor);
}
public List<Leitor> listar(){
    return repo.findAll();
}
}
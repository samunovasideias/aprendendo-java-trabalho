package com.samuel.biblioteca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface LivroRepository extends JpaRepository<Livro,Integer>{


public List<Livro> findByNome(String nome);

//public List<Livro>

    boolean existsByNome(String nome);


    }

    
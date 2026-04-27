package org.example.jsfront.repositories;

import org.example.jsfront.models.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor,Integer> {
}

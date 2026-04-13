package com.exemplo.contatos.repository;

import com.exemplo.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByNomeContainingIgnoreCase(String nome);
    Optional<Contato> findByEmail(String email);
}

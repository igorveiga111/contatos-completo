package com.exemplo.contatos.service;

import com.exemplo.contatos.model.Contato;
import com.exemplo.contatos.repository.ContatoRepository;
import com.exemplo.contatos.exception.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repo;

    public ContatoService(ContatoRepository repo){ this.repo = repo;}

    public List<Contato> listarTodos(){ return repo.findAll(); }

    public Contato buscarPorId(Long id){
        return repo.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Contato não encontrado: "+id));
    }

    public Contato criar(Contato c){ return repo.save(c); }

    public Contato atualizar(Long id, Contato c){
        Contato existente = buscarPorId(id);
        existente.setNome(c.getNome());
        existente.setEmail(c.getEmail());
        existente.setTelefone(c.getTelefone());
        return repo.save(existente);
    }

    public void deletar(Long id){
        Contato c = buscarPorId(id);
        repo.delete(c);
    }

    public List<Contato> pesquisarPorNome(String nome){
        return repo.findByNomeContainingIgnoreCase(nome);
    }
}

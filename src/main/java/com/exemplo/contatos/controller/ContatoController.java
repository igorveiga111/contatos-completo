package com.exemplo.contatos.controller;

import com.exemplo.contatos.model.Contato;
import com.exemplo.contatos.service.ContatoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service){ this.service = service; }

    @GetMapping
    public List<Contato> listar(){ return service.listarTodos(); }

    @GetMapping("/{id}")
    public Contato buscar(@PathVariable Long id){ return service.buscarPorId(id); }

    @GetMapping("/pesquisa")
    public List<Contato> pesquisar(@RequestParam String nome){
        return service.pesquisarPorNome(nome);
    }

    @PostMapping
    public Contato criar(@RequestBody Contato c){ return service.criar(c); }

    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @RequestBody Contato c){
        return service.atualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}

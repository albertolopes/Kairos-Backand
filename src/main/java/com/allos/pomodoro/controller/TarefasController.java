package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping(value ="/{id}")
    public ResponseEntity<TarefasDTO> buscarTarefa(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarTarefa(id).get());
    }

    @PostMapping
    public ResponseEntity<TarefasDTO> salvaTarefa(@Valid @RequestBody TarefasDTO dto) throws Exception {
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<TarefasDTO> atualizarTarefa(@RequestBody TarefasDTO dto){
        return ResponseEntity.ok(service.atualizarTarefa(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaTarefa(@PathVariable Long id){
        service.deletaTarefa(id);
        return ResponseEntity.noContent().build();
    }


}

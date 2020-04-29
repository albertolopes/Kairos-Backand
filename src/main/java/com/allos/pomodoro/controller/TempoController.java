package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.TempoDTO;
import com.allos.pomodoro.service.TempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/tempo")
public class TempoController {

    @Autowired
    private TempoService service;

    @PostMapping
    public ResponseEntity<TempoDTO> salvar(@RequestBody TempoDTO dto){
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<TempoDTO>> buscar(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TempoDTO> editar(@RequestBody TempoDTO dto){
        return ResponseEntity.ok(service.atualizar(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

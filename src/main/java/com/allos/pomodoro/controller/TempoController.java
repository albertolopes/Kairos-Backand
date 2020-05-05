package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.TempoDTO;
import com.allos.pomodoro.service.TempoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/tempo")
@Api("API REST Tempo")
public class TempoController {

    @Autowired
    private TempoService service;

    @ApiOperation("Salva Tempo")
    @PostMapping
    public ResponseEntity<TempoDTO> salvar(@RequestBody TempoDTO dto){
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @ApiOperation("Busca Tempo")
    @GetMapping
    public ResponseEntity<List<TempoDTO>> buscar(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @ApiOperation("Atualiza Tempo")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TempoDTO> editar(@RequestBody TempoDTO dto){
        return ResponseEntity.ok(service.atualizar(dto));
    }

    @ApiOperation("Deleta Tempo")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

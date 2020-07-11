package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.service.TarefasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
@Api("API REST Tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @ApiOperation("Busca tarefas do usuario logado")
    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscar() {
        List<TarefasDTO> list = service.buscar();
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation("Busca uma tarefa pelo id")
    @GetMapping(value ="/{id}")
    public ResponseEntity<TarefasDTO> buscarTarefa(@Valid @PathVariable Long id){
        return ResponseEntity.ok(service.buscarTarefa(id).get());
    }

    @ApiOperation("Salva uma tarefa")
    @PostMapping
    public ResponseEntity<TarefasDTO> salvaTarefa(@Valid @RequestBody TarefasDTO dto) throws Exception {
        dto = service.salvar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @ApiOperation("Atualiza uma tarefa")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TarefasDTO> atualizarTarefa(@Valid @RequestBody TarefasDTO dto){
        return ResponseEntity.ok(service.atualizarTarefa(dto));
    }

    @ApiOperation("Deleta uma tarefa")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaTarefa(@Valid @PathVariable Long id){
        service.deletaTarefa(id);
        return ResponseEntity.noContent().build();
    }
}

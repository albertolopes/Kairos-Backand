package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.mapper.TarefasMapper;
import com.allos.pomodoro.service.TarefasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
@Api("API REST Tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @Autowired
    private TarefasMapper mapper;

    @ApiOperation("Salva uma tarefa")
    @PostMapping
    public ResponseEntity<TarefasDTO> salvaTarefa(@Valid @RequestBody TarefasDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(mapper.toEntity(dto))));
    }

    @ApiOperation("Atualiza uma tarefa")
    @PutMapping
    public ResponseEntity<TarefasDTO> atualizarTarefa(@Valid @RequestBody TarefasDTO dto){
        return ResponseEntity.ok(mapper.toDto(service.atualizarTarefa(mapper.toEntity(dto))));
    }


    @ApiOperation("Busca tarefas do usuario logado")
    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscar() {
        return ResponseEntity.ok().body(mapper.toDto(service.buscar()));
    }

    @ApiOperation("Busca uma tarefa pelo id")
    @GetMapping(value ="/{id}")
    public ResponseEntity<TarefasDTO> buscarTarefa(@Valid @PathVariable Long id){
        return ResponseEntity.ok(mapper.toDto(service.buscarTarefa(id)));
    }

    @ApiOperation("Deleta uma tarefa")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaTarefa(@Valid @PathVariable Long id){
        service.deletaTarefa(id);
        return ResponseEntity.noContent().build();
    }
}

package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.mapper.UsuarioMapper;
import com.allos.pomodoro.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
@Api("API REST Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @ApiOperation("Busca o usuario logado")
    @GetMapping
    public ResponseEntity<UsuarioDTO> buscarUsuario(){
        return ResponseEntity.ok(mapper.toDto(service.buscar()));
    }

    @ApiOperation("Busca um único usuario pelo Id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(mapper.toDto(service.buscarUsuarioId(id)));
    }

    @ApiOperation("Salva um usuario")
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvaUsuario(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(mapper.toDto(service.salvar(mapper.toEntity(dto))));
    }

    @ApiOperation("Edita um usuario")
    @PutMapping
    public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(mapper.toDto(service.atualizarUsuario(mapper.toEntity(dto))));
    }

    @ApiOperation("Deleta um usuario")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        service.deletaUsuario(id);
        return  ResponseEntity.noContent().build();
    }

}

package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
@Api("API REST Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @ApiOperation("Busca o usuario logado")
    @GetMapping
    public ResponseEntity<UsuarioDTO> buscarUsuario(){
        return ResponseEntity.ok(service.buscar());
    }

    @ApiOperation("Busca um único usuario pelo Id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarUsuarioId(id).get());
    }

    @ApiOperation("Salva um usuario")
    @PostMapping
    public UsuarioDTO salvaUsuario(@Valid @RequestBody UsuarioDTO dto){
        return service.salvar(dto);
    }

    @ApiOperation("Edita um usuario")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.atualizarUsuario(dto));
    }

    @ApiOperation("Deleta um usuario")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        service.deletaUsuario(id);
        return  ResponseEntity.noContent().build();
    }

}

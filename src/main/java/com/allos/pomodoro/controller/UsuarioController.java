package com.allos.pomodoro.controller;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> buscarUsuario(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarUsuarioId(id).get());
    }

    @PostMapping
    public UsuarioDTO salvaUsuario(@Valid @RequestBody UsuarioDTO dto){
        return service.salvar(dto);
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.atualizarUsuario(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        service.deletaUsuario(id);
        return  ResponseEntity.noContent().build();
    }

}

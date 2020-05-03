package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.mapper.UsuarioMapper;
import com.allos.pomodoro.repository.UsuarioRepository;

import com.allos.pomodoro.exception.ObjectNotFoundException;
import com.allos.pomodoro.exception.ObjectAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public Optional<UsuarioDTO> buscarUsuarioId(Long id){
        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        return Optional.of(mapper.toDto(repository.findById(id).get()));
    }

    public UsuarioDTO salvar(UsuarioDTO dto){
        if(repository.findByUsuario(dto.getNome()).isPresent() && dto != null){
            throw new ObjectAlreadyExistsException("Usuario já cadastrado.");
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO dto) {
        if(!repository.findById(dto.getId()).isPresent()){
            throw new ObjectNotFoundException("Id do usuario não existe.");
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void deletaUsuario(Long id){
        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        repository.deleteById(id);
    }
}

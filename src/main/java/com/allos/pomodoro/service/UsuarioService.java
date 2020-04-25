package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.mapper.UsuarioMapper;
import com.allos.pomodoro.repository.UsuarioRepository;
import com.allos.pomodoro.service.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public Optional<UsuarioDTO> buscarUsuarioId(Long id) throws Exception {
        if(!repository.findById(id).isPresent()){
            throw new Exception("Usuario não existe.");
        }
        return Optional.of(mapper.toDto(repository.findById(id).get()));
    }

    public UsuarioDTO salvar(UsuarioDTO dto){
        Usuario x = mapper.toEntity(dto);
        Usuario y= repository.save(x);
       return mapper.toDto(y);
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void deletaUsuario(Long id){
        repository.deleteById(id);
    }
}

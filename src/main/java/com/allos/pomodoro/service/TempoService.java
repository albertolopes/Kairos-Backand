package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.TempoDTO;
import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.mapper.TempoMapper;
import com.allos.pomodoro.repository.TempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempoService {

    @Autowired
    private TempoRepository repository;

    @Autowired
    private TempoMapper mapper;

    public TempoDTO salvar(TempoDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<TempoDTO> buscarTodos() {
        return mapper.toDto(repository.findAll());
    }

    public TempoDTO atualizar(TempoDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

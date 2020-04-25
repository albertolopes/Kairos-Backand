package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.mapper.TarefasMapper;
import com.allos.pomodoro.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    @Autowired
    private TarefasMapper mapper;

    public TarefasDTO salvar(TarefasDTO dto){
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public Optional<TarefasDTO> buscarTarefa(Long id) {
        return Optional.of(mapper.toDto(repository.findById(id).get()));
    }

    public TarefasDTO atualizarTarefa(TarefasDTO dto){
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void deletaTarefa(Long id) {
        repository.deleteById(id);
    }
}

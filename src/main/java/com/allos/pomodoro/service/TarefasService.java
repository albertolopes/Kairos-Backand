package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.enums.Perfil;
import com.allos.pomodoro.exception.AuthorizationException;
import com.allos.pomodoro.exception.ObjectNotFoundException;
import com.allos.pomodoro.mapper.TarefasMapper;
import com.allos.pomodoro.repository.TarefasRepository;
import com.allos.pomodoro.repository.UsuarioRepository;
import com.allos.pomodoro.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TarefasMapper mapper;

    public TarefasDTO salvar(final TarefasDTO dto) {

        UsuarioDTO usuarioDto = usuarioService.buscar();

        TarefasDTO tarefa = new TarefasDTO(
                null, dto.getStatus(), dto.getDescricao(), dto.getTipoTarefa(),
                dto.getTempoInicial(), dto.getTempoFinal(), usuarioDto);

        return mapper.toDto(repository.save(mapper.toEntity(tarefa)));
    }

    public List<TarefasDTO> buscar() {

        UserSecurity userSecurity = UserSecurityService.authenticate();

        if(userSecurity == null){
            throw new AuthorizationException("Acesso negado");
        }

        return mapper.toDto(repository.findTarefasByUsuario(userSecurity.getId()));
    }

    public Optional<TarefasDTO> buscarTarefa(Long id) {

        UserSecurity userSecurity = UserSecurityService.authenticate();

        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso negado");
        }

        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Tarefa não existe.");
        }

        return Optional.of(mapper.toDto(repository.findById(id).get()));
    }

    public TarefasDTO atualizarTarefa(TarefasDTO dto){
        UserSecurity userSecurity = UserSecurityService.authenticate();

        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && dto.getId().equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso negado");
        }

        if(!repository.findById(dto.getId()).isPresent()){
            throw new ObjectNotFoundException("Tarefa não existe.");
        }

        UsuarioDTO usuarioDto = usuarioService.buscar();

        TarefasDTO tarefa = new TarefasDTO(
                null, dto.getStatus(), dto.getDescricao(), dto.getTipoTarefa(),
                dto.getTempoInicial(), dto.getTempoFinal(), usuarioDto);

        return mapper.toDto(repository.save(mapper.toEntity(tarefa)));
    }

    public void deletaTarefa(Long id) {
        UserSecurity userSecurity = UserSecurityService.authenticate();

        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso negado");
        }

        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        repository.deleteById(id);
    }
}
package com.allos.pomodoro.service;

import com.allos.pomodoro.entity.Tarefas;
import com.allos.pomodoro.entity.enums.Perfil;
import com.allos.pomodoro.exception.AuthorizationException;
import com.allos.pomodoro.exception.ObjectNotFoundException;
import com.allos.pomodoro.repository.TarefasRepository;
import com.allos.pomodoro.repository.UsuarioRepository;
import com.allos.pomodoro.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    public Tarefas salvar(final Tarefas tarefas) {
        tarefas.setUsuario(usuarioService.buscar());
        return repository.save(tarefas);
    }

    public List<Tarefas> buscar() {
        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null){
            throw new AuthorizationException("Acesso negado");
        }
        return repository.findTarefasByUsuario(userSecurity.getId());
    }

    public Tarefas buscarTarefa(Long id) {
        verificaUsuarioLogado(id);
        validarTarefa(id);
        return repository.findById(id).get();
    }

    public Tarefas atualizarTarefa(Tarefas tarefas){
        verificaUsuarioLogado(tarefas.getId());
        validarTarefa(tarefas.getId());
        tarefas.setUsuario(usuarioService.buscar());

        return repository.save(tarefas);
    }

    public void deletaTarefa(Long id) {
        verificaUsuarioLogado(id);
        validarTarefa(id);
        repository.deleteById(id);
    }

    public void validarTarefa(Long id){
        repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Tarefa não existe."));
    }

    public void verificaUsuarioLogado(Long id){
        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso Negado");
        }
    }
}
package com.allos.pomodoro.service;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.Perfil;
import com.allos.pomodoro.exception.AuthorizationException;
import com.allos.pomodoro.mapper.UsuarioMapper;
import com.allos.pomodoro.repository.UsuarioRepository;

import com.allos.pomodoro.exception.ObjectNotFoundException;
import com.allos.pomodoro.exception.ObjectAlreadyExistsException;

import com.allos.pomodoro.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    public Optional<UsuarioDTO> buscarUsuarioId(Long id){

        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso Negado");
        }

        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        return Optional.of(mapper.toDto(repository.findById(id).get()));
    }

    public UsuarioDTO salvar(UsuarioDTO dto){
        if(repository.findByUsuario(dto.getNome()).isPresent() && dto != null){
            throw new ObjectAlreadyExistsException("Usuario já cadastrado.");
        }
        UsuarioDTO usuario = new UsuarioDTO(null, dto.getNome(), dto.getEmail(),
                bCrypt.encode(dto.getSenha()), dto.getPerfis());
        return mapper.toDto(repository.save(mapper.toEntity(usuario)));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO dto) {
        if(!repository.findById(dto.getId()).isPresent()){
            throw new ObjectNotFoundException("Id do usuario não existe.");
        }
        UsuarioDTO usuario = new UsuarioDTO(dto.getId(), dto.getNome(), dto.getEmail(),
                bCrypt.encode(dto.getSenha()), dto.getPerfis());
        return mapper.toDto(repository.save(mapper.toEntity(usuario)));
    }

    public void deletaUsuario(Long id){
        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        repository.deleteById(id);
    }
}

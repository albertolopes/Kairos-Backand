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

    public UsuarioDTO buscar(){

        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN)){
            throw new AuthorizationException("Acesso Negado");
        }

        UsuarioDTO user = mapper.toDto(repository.findById(userSecurity.getId()).get());

        if(user == null){
            throw new ObjectNotFoundException("Usuario não existe.");
        }

        return user;
    }

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

        if(repository.findByUsuario(dto.getNome(), dto.getEmail()).isPresent()  && dto != null){
            throw new ObjectAlreadyExistsException("Usuario ou email já cadastrado.");
        }
        UsuarioDTO usuario = new UsuarioDTO(null, dto.getNome(), dto.getEmail(),
                bCrypt.encode(dto.getSenha()), dto.getPerfis());
        return mapper.toDto(repository.save(mapper.toEntity(usuario)));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO dto) {

        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !dto.getId().equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso Negado");
        }

        Optional<Usuario> userOpt = repository.findById(dto.getId());
        Usuario user = userOpt.get();

        if(user == null){
            throw new ObjectNotFoundException("Id do usuario não existe.");
        } else {
            String encryptPassword = encryptedPassword(user, dto);
            UsuarioDTO usuario = new UsuarioDTO(dto.getId(), dto.getNome(), dto.getEmail(),
                    encryptPassword, dto.getPerfis());

            return mapper.toDto(repository.save(mapper.toEntity(usuario)));
        }
    }

    public void deletaUsuario(Long id){

        UserSecurity userSecurity = UserSecurityService.authenticate();

        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso Negado");
        }

        if(!repository.findById(id).isPresent()){
            throw new ObjectNotFoundException("Usuario não existe.");
        }
        repository.deleteById(id);
    }

    public String encryptedPassword(Usuario user, UsuarioDTO dto){

        if(user.getSenha() != dto.getSenha() & dto.getSenha().length() <= 10){
            return bCrypt.encode(dto.getSenha());
        } else {
            return user.getSenha();
        }
    }
}

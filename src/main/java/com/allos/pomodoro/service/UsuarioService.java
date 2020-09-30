package com.allos.pomodoro.service;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.Perfil;
import com.allos.pomodoro.exception.AuthorizationException;
import com.allos.pomodoro.exception.DataIntegrityException;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario salvar(Usuario usuario){
        if(repository.findByUsuario(usuario.getNome(), usuario.getEmail()).isPresent()){
            throw new ObjectAlreadyExistsException("Usuario ou email já cadastrado.");
        }
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.addPerfil(Perfil.USUARIO);
        return repository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        verificaUsuarioLogado(usuario.getId());
        verificarSeSenhafoiAlterada(usuario);
        validarAtualizarUsuario(usuario);

        usuario.addPerfil(Perfil.USUARIO);
        return repository.save(usuario);
    }

    public Usuario buscar(){
        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null){
            throw new AuthorizationException("Acesso Negado");
        }
        return repository.findById(userSecurity.getId()).orElseThrow(
                ()->new ObjectNotFoundException("Usuario não existe."));
    }

    public Usuario buscarUsuarioId(Long id){
        verificaUsuarioLogado(id);
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuario não existe."));
    }

    public void deletaUsuario(Long id){
        verificaUsuarioLogado(id);
        repository.deleteById(id);
    }

    public void validarAtualizarUsuario(Usuario usuario){

        Usuario nome = repository.findByNome(usuario.getNome());
        if(nome != null && !nome.getId().equals(usuario.getId())){
            throw new ObjectAlreadyExistsException("Usuario já existe");
        }

        Usuario email = repository.findByEmail(usuario.getEmail());
        if(email != null && !email.getId().equals(usuario.getId())){
            throw new ObjectAlreadyExistsException("Email já existe");
        }
    }

    public Usuario verificarSeSenhafoiAlterada(Usuario usuario){
        Optional<Usuario> retorno = repository.findById(usuario.getId()).filter(
                u -> !u.getSenha().isEmpty()
        );

        if(retorno.isPresent()){
            if(retorno.get().getSenha().equals(usuario.getSenha())){
                usuario.setSenha(retorno.get().getSenha());
                return usuario;
            } else {
                usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
                return usuario;
            }
        } else {
            throw new DataIntegrityException("Erro validar senha. Id não encontrado!");
        }
    }

    public void verificaUsuarioLogado(Long id){
        UserSecurity userSecurity = UserSecurityService.authenticate();
        if(userSecurity == null || !userSecurity.hasRole(Perfil.ADMIN) && !id.equals(userSecurity.getId())){
            throw new AuthorizationException("Acesso Negado");
        }
    }
}

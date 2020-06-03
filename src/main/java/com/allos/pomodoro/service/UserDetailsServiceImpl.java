package com.allos.pomodoro.service;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.repository.UsuarioRepository;
import com.allos.pomodoro.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = repository.findByNome(nome);

        if(usuario == null) {
            throw new UsernameNotFoundException(nome);
        }

        return new UserSecurity(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getPerfil());
    }
}

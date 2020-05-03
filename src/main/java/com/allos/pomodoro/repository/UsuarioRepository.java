package com.allos.pomodoro.repository;

import com.allos.pomodoro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u.id, u.nome, u.email from Usuario u where u.nome = :nome")
    Optional<Usuario> findByUsuario(String nome);

}

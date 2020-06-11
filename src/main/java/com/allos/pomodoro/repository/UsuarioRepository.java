package com.allos.pomodoro.repository;

import com.allos.pomodoro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u.id, u.nome, u.email from Usuario u where u.nome = :nome or u.email = :email")
    Optional<Usuario> findByUsuario(String nome, String email);

    @Transactional
    Usuario findByNome(String nome);

    @Transactional
    Usuario findByEmail(String email);

}

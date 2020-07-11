
package com.allos.pomodoro.repository;

import com.allos.pomodoro.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

    @Query( "select u from Tarefas u where u.usuario.id = :usuario")
    List<Tarefas> findTarefasByUsuario(@Param("usuario") Long usuario);
}
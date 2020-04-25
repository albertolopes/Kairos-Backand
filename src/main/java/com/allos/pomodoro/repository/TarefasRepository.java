package com.allos.pomodoro.repository;

import com.allos.pomodoro.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}

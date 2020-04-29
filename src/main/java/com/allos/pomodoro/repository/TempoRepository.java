package com.allos.pomodoro.repository;
import com.allos.pomodoro.entity.Tempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempoRepository extends JpaRepository<Tempo, Long> {

}

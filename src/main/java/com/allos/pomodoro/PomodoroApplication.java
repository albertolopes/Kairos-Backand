package com.allos.pomodoro;

import com.allos.pomodoro.entity.Tarefas;
import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.StatusTarefa;
import com.allos.pomodoro.repository.TarefasRepository;
import com.allos.pomodoro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PomodoroApplication{

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
	}

}

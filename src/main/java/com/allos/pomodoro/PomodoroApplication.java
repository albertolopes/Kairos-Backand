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

import java.util.Arrays;

@SpringBootApplication
public class PomodoroApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TarefasRepository tarefasRepository;

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
	}

}

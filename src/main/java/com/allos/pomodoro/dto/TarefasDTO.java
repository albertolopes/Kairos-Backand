package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.*;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class TarefasDTO {

    private Long id;
    private StatusTarefa status;
    private String descricao;
    private String tipoTarefa;
    private Usuario usuario;
    private Set<TempoDTO> tempoDTO = new HashSet<>();
}

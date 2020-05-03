package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class TarefasDTO implements Serializable {
    private static final long serialVersionUID = 1;


    private Long id;
    private StatusTarefa status;
    private String descricao;
    private String tipoTarefa;
    private Usuario usuario;
    private Set<TempoDTO> tempo = new HashSet<>();
}

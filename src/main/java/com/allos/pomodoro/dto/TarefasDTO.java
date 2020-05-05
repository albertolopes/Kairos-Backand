package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.Usuario;
import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TarefasDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Long id;

    private StatusTarefa status;

    @Size(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String descricao;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Size(min=5, max=40, message = "O tamanho deve ser entre 5 e 40 caracteres")
    private String tipoTarefa;

    private UsuarioDTO usuario;

    private Set<TempoDTO> tempo = new HashSet<>();
}

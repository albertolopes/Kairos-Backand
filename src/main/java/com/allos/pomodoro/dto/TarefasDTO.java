package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TarefasDTO {

    private Long id;
    private StatusTarefa status;
    private String descricao;
    private String tipoTarefa;
}

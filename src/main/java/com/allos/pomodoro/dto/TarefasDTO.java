package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.enums.StatusTarefa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    @Column(name = "TEMPO_INICIAL")
    private Instant dataTarefa;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant tempoInicial;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant tempoFinal;

    private UsuarioDTO usuario;

//    public String getTempoDecorrido(){
//        ZoneId zone = ZoneId.of("America/Sao_Paulo");
//        ZonedDateTime horaAtual = ZonedDateTime.now(zone);
//        ZonedDateTime hora = tempoFinal == null ?
//                ZonedDateTime.parse(horaAtual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))) :
//                ZonedDateTime.ofInstant(tempoFinal, zone);
//        long absSeconds = Math.abs(Duration.between(tempoInicial, hora).getSeconds());
//        String formatTempo = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
//        return formatTempo;
//    }
    
}

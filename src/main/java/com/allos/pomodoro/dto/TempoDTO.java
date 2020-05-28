package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.Tarefas;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@EqualsAndHashCode
public class TempoDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant tempoInicial;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant tempoFinal;

    @JsonIgnore
    private Tarefas tarefas;

    public String getTempoDecorrido(){
        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime horaAtual = ZonedDateTime.now(zone);
        ZonedDateTime hora = tempoFinal == null ?
                ZonedDateTime.parse(horaAtual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))) :
                ZonedDateTime.ofInstant(tempoFinal, zone);
        long absSeconds = Math.abs(Duration.between(tempoInicial, hora).getSeconds());
        String formatTempo = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
        return formatTempo;
    }
}

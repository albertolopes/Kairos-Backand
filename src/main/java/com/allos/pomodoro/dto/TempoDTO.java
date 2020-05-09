package com.allos.pomodoro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;

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


    public String getTempoDecorrido(){
        long absSeconds = Math.abs(Duration.between(tempoInicial, tempoFinal).getSeconds());
        String formatTempo = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
        return formatTempo;
    }
}

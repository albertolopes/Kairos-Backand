package com.allos.pomodoro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class TempoDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date tempoInicial;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date tempoFinal;
}

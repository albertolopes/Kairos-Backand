package com.allos.pomodoro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "TB_TEMPO")
public class Tempo implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEMPO")
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @Column(name = "TEMPO_INICIAL")
    private Date tempoInicial;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @Column(name = "TEMPO_FINAL")
    private Date tempoFinal;
}

package com.allos.pomodoro.entity;

import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "TB_TAREFAS")
public class Tarefas implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAREFAS_ID")
    private Long id;

    @Column(name = "TIPO_TAREFA")
    private String tipoTarefa;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;


}

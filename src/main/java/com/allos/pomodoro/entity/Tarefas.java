package com.allos.pomodoro.entity;

import com.allos.pomodoro.entity.enums.StatusTarefa;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "TB_TAREFAS")
public class Tarefas implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFAS")
    private Long id;

    @Column(name = "TIPO_TAREFA")
    private String tipoTarefa;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToMany
    @JoinTable( name = "TB_TAREFAS_TEMPO",
            joinColumns = @JoinColumn(name = "ID_TAREFAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_TEMPO")
    )
    private Set<Tempo> tempo = new HashSet<>();
}

package com.allos.pomodoro.entity;

import com.allos.pomodoro.entity.enums.StatusTarefa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_TAREFAS")
public class Tarefas implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
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

    @JsonIgnore
    @OneToMany(mappedBy = "tarefas")
    private List<Tempo> tempo = new ArrayList<>();

//    @ManyToMany
//    @JoinTable( name = "TB_TAREFAS_TEMPO",
//            joinColumns = @JoinColumn(name = "ID_TAREFAS"),
//            inverseJoinColumns = @JoinColumn(name = "ID_TEMPO")
//    )
//    private Set<Tempo> tempo = new HashSet<>();
}

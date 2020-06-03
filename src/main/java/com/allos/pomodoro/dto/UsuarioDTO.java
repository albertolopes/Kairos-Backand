package com.allos.pomodoro.dto;

import com.allos.pomodoro.entity.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Size(min=3, max=15, message = "O tamanho deve ser entre 3 e 15 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Size(min=5, max=40, message = "O tamanho deve ser entre 5 e 40 caracteres")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Size(min=5, max=50, message = "O tamanho deve ser entre 5 e 10 caracteres")
    private String senha;

    private Set<Integer> perfis = new HashSet<>();

}

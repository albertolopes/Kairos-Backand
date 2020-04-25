package com.allos.pomodoro.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
}

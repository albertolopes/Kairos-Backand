package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}

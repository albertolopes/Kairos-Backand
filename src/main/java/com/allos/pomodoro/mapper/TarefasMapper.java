package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.entity.Tarefas;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TarefasMapper extends BaseMapper<Tarefas, TarefasDTO> {

}

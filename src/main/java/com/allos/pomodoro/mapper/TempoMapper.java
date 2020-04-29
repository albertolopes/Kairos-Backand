package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.TempoDTO;
import com.allos.pomodoro.entity.Tempo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TempoMapper extends BaseMapper<Tempo, TempoDTO> {

}

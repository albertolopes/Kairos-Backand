package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.TempoDTO;
import com.allos.pomodoro.entity.Tempo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-01T19:21:34-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TempoMapperImpl implements TempoMapper {

    @Override
    public TempoDTO toDto(Tempo entity) {
        if ( entity == null ) {
            return null;
        }

        TempoDTO tempoDTO = new TempoDTO();

        tempoDTO.setId( entity.getId() );
        tempoDTO.setTempoInicial( entity.getTempoInicial() );
        tempoDTO.setTempoFinal( entity.getTempoFinal() );

        return tempoDTO;
    }

    @Override
    public Tempo toEntity(TempoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tempo tempo = new Tempo();

        tempo.setId( dto.getId() );
        tempo.setTempoInicial( dto.getTempoInicial() );
        tempo.setTempoFinal( dto.getTempoFinal() );

        return tempo;
    }

    @Override
    public List<TempoDTO> toDto(List<Tempo> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TempoDTO> list = new ArrayList<TempoDTO>( entities.size() );
        for ( Tempo tempo : entities ) {
            list.add( toDto( tempo ) );
        }

        return list;
    }

    @Override
    public List<Tempo> toEntity(List<TempoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Tempo> list = new ArrayList<Tempo>( dtos.size() );
        for ( TempoDTO tempoDTO : dtos ) {
            list.add( toEntity( tempoDTO ) );
        }

        return list;
    }
}

package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.entity.Tarefas;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-25T10:20:53-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TarefasMapperImpl implements TarefasMapper {

    @Override
    public TarefasDTO toDto(Tarefas entity) {
        if ( entity == null ) {
            return null;
        }

        TarefasDTO tarefasDTO = new TarefasDTO();

        tarefasDTO.setId( entity.getId() );
        tarefasDTO.setStatus( entity.getStatus() );
        tarefasDTO.setDescricao( entity.getDescricao() );
        tarefasDTO.setTipoTarefa( entity.getTipoTarefa() );

        return tarefasDTO;
    }

    @Override
    public Tarefas toEntity(TarefasDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarefas tarefas = new Tarefas();

        tarefas.setId( dto.getId() );
        tarefas.setTipoTarefa( dto.getTipoTarefa() );
        tarefas.setDescricao( dto.getDescricao() );
        tarefas.setStatus( dto.getStatus() );

        return tarefas;
    }

    @Override
    public List<TarefasDTO> toDto(List<Tarefas> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TarefasDTO> list = new ArrayList<TarefasDTO>( entities.size() );
        for ( Tarefas tarefas : entities ) {
            list.add( toDto( tarefas ) );
        }

        return list;
    }

    @Override
    public List<Tarefas> toEntity(List<TarefasDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Tarefas> list = new ArrayList<Tarefas>( dtos.size() );
        for ( TarefasDTO tarefasDTO : dtos ) {
            list.add( toEntity( tarefasDTO ) );
        }

        return list;
    }
}

package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.TarefasDTO;
import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.Tarefas;
import com.allos.pomodoro.entity.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-10T20:51:45-0300",
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
        tarefasDTO.setDataTarefa( entity.getDataTarefa() );
        tarefasDTO.setTempoInicial( entity.getTempoInicial() );
        tarefasDTO.setTempoFinal( entity.getTempoFinal() );
        tarefasDTO.setUsuario( usuarioToUsuarioDTO( entity.getUsuario() ) );

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
        tarefas.setUsuario( usuarioDTOToUsuario( dto.getUsuario() ) );
        tarefas.setDataTarefa( dto.getDataTarefa() );
        tarefas.setTempoInicial( dto.getTempoInicial() );
        tarefas.setTempoFinal( dto.getTempoFinal() );

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

    protected UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setNome( usuario.getNome() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setSenha( usuario.getSenha() );
        Set<Integer> set = usuario.getPerfis();
        if ( set != null ) {
            usuarioDTO.setPerfis( new HashSet<Integer>( set ) );
        }

        return usuarioDTO;
    }

    protected Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setNome( usuarioDTO.getNome() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setSenha( usuarioDTO.getSenha() );
        Set<Integer> set = usuarioDTO.getPerfis();
        if ( set != null ) {
            usuario.setPerfis( new HashSet<Integer>( set ) );
        }

        return usuario;
    }
}

package com.allos.pomodoro.mapper;

import com.allos.pomodoro.dto.UsuarioDTO;
import com.allos.pomodoro.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-23T20:32:54-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDto(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setNome( entity.getNome() );
        usuarioDTO.setEmail( entity.getEmail() );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setNome( dto.getNome() );
        usuario.setEmail( dto.getEmail() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entities.size() );
        for ( Usuario usuario : entities ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtos.size() );
        for ( UsuarioDTO usuarioDTO : dtos ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }
}

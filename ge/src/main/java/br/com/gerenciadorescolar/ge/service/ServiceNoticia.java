package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.NoticiaDto;

public interface ServiceNoticia {
    
    List<NoticiaDto> list();
    
    Boolean add(NoticiaDto noticia);

    Boolean edit(String id,NoticiaDto noticia);

    Boolean delete(String id);
    
    int buscarID(String id);

    String buscarIDPorNome(String nome);

}

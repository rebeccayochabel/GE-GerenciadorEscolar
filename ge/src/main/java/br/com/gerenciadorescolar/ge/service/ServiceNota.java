package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.NotaDto;

public interface ServiceNota {

    List<NotaDto> list();
    
    Boolean add(NotaDto nota);

    Boolean edit(String id,NotaDto nota);

    Boolean delete(String id);

    int buscarID(String id);

    String buscarIDPorNome(String nome);
    
}

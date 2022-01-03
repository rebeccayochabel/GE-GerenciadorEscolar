package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.AtividadeDto;

public interface ServiceAtv {
    
    List<AtividadeDto> list();
    
    Boolean add(AtividadeDto atividade);

    Boolean edit(String id,AtividadeDto atividade);

    Boolean delete(String id);

    int buscarID(String id);

    String buscarIDPorNome(String nome);

}

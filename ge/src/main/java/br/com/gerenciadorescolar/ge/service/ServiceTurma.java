package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.TurmaDto;

public interface ServiceTurma {
    
    List<TurmaDto> list();
    
    Boolean add(TurmaDto turma);

    Boolean edit(String id,TurmaDto turma);

    Boolean delete(String id);

    int buscarID(String id);

    String buscarIDPorNome(String nome);

}

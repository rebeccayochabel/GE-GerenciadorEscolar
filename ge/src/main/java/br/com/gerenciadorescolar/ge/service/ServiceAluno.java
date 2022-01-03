package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.AlunoDto;

public interface ServiceAluno {
    
    List<AlunoDto> list();
    
    Boolean add(AlunoDto aluno);

    Boolean edit(String id,AlunoDto aluno);

    Boolean delete(String id);
    
    int buscarID(String id);

    String buscarIDPorNome(String nome);
}

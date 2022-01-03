package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.JogoDto;

public interface ServiceJogo {

    List<JogoDto> list();
    
    Boolean add(JogoDto jogo);

    Boolean edit(String id,JogoDto jogo);

    Boolean delete(String id);
    
    int buscarID(String id);

    String buscarIDPorNome(String nome);
}

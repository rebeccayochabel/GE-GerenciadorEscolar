package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.ProfDto;

public interface ServiceProf {
    
    List<ProfDto> list();
    
    Boolean add(ProfDto prof);

    Boolean edit(String id,ProfDto prof);

    Boolean delete(String id);

    int buscarID(String id);

    String buscarIDPorNome(String nome);

}

package br.com.gerenciadorescolar.ge.service;

import java.util.List;

import br.com.gerenciadorescolar.ge.DTO.ServDto;

public interface ServiceServ {
    
    List<ServDto> list();
    
    Boolean add(ServDto serv);

    Boolean edit(String id,ServDto serv);

    Boolean delete(String id);

    int buscarID(String id);

    String buscarIDPorNome(String nome);
    
}

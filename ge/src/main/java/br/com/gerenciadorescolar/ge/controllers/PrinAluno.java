package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrinAluno {

    @GetMapping("/prinAluno")
    public String principal(Model Model){
        return "prinAluno";
    } 
    
}

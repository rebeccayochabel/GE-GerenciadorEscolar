package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gerenciadorescolar.ge.service.ServiceAluno;
import br.com.gerenciadorescolar.ge.service.ServiceProf;
import br.com.gerenciadorescolar.ge.service.ServiceServ;

@Controller
public class ContatoController {

    @Autowired
    private ServiceServ serviceS;

    @Autowired 
    private ServiceAluno serviceA;

    @Autowired
    private ServiceProf serviceP;
    
    @GetMapping("/contatosProfessores")
    public String cnttP(Model model){
        model.addAttribute("profList", serviceP.list());
        return "contatosP";
    }

    @GetMapping("/contatosServidores")
    public String cnttS(Model model){
        model.addAttribute("servList", serviceS.list());
        return "contatosS";
    }

    @GetMapping("/contatosAlunos")
    public String cnttA(Model model){
        model.addAttribute("alunosList", serviceA.list());
        return "contatosA";
    }

}

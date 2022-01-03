package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.NotaDto;
import br.com.gerenciadorescolar.ge.service.ServiceNota;

@Controller
public class NotaController {

    @Autowired
    private ServiceNota service;

    @GetMapping(value = "/cadastrarNota")
    public String formaCad(Model model){
        model.addAttribute("nota", new NotaDto());
        return "cadNota.html";
    }
    
    @PostMapping("/notaAdd")
    public String greetingSubmit(@ModelAttribute NotaDto nota, Model model){
        service.add(nota);
        model.addAttribute("nota", nota);

        return "redirect:listarNotas";
    }

    @GetMapping(value = "/listarNotas")
    public String list(Model model){
        model.addAttribute("notaList", service.list());
        return "listarNotas.html";
    }
    
    @GetMapping(value = "/deletarNota")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarNotas";
    }

    @GetMapping(value = "/excluirNota")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        NotaDto nota = service.list().get(dp);
        model.addAttribute("nota", nota);
        return "deletarNota";
    }
    
}

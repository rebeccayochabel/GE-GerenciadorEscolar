package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.TurmaDto;
import br.com.gerenciadorescolar.ge.service.ServiceTurma;

@Controller
public class TurmaController {
    
    @Autowired
    private ServiceTurma service;

    @GetMapping(value = "/cadastrarTurma")
    public String formaCad(Model model){
        model.addAttribute("turma", new TurmaDto());
        return "cadTurma.html";
    }

    @PostMapping("/turmaAdd")
    public String greetingSubmit(@ModelAttribute TurmaDto turma, Model model){
        service.add(turma);
        model.addAttribute("turma", turma);
        return "redirect:listarTurmas";
    }

    @GetMapping(value = "/listarTurmas")
    public String list(Model model){
        model.addAttribute("turmaList", service.list());
        return "listarTurmas.html";
    }
    
    @GetMapping(value = "/deletarTurma")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarTurmas";
    }

    @GetMapping(value = "/excluirTurma")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        TurmaDto turma = service.list().get(dp);
        model.addAttribute("turma", turma);
        return "deletarTurma";
    }

    @GetMapping("/alterarTurma")
	public String alterarTurma(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	TurmaDto turma = service.list().get(dP);
    	model.addAttribute("turma", turma);
        	return "alterarTurma";
	}
    
    @PostMapping("/altTurma")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute TurmaDto turma ) {
    	service.edit(id, turma);
		  return  "redirect:/listarTurmas";
    }

}

package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.ProfDto;
import br.com.gerenciadorescolar.ge.service.ServiceProf;

@Controller
public class ProfController {
    
    @Autowired
    private ServiceProf service;

    @GetMapping(value = "/cadastrarProfessor")
    public String formaCad(Model model){
        model.addAttribute("prof", new ProfDto());
        return "cadProf.html";
    }

    @PostMapping("/profAdd")
    public String greetingSubmit(@ModelAttribute ProfDto prof, Model model){
        service.add(prof);
        model.addAttribute("prof", prof);

        return "redirect:listarProfs";
    }

    @GetMapping(value = "/listarProfs")
    public String list(Model model){
        model.addAttribute("profList", service.list());
        return "listarProfs.html";
    }
    
    @GetMapping(value = "/deletarProf")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarProfs";
    }

    @GetMapping(value = "/excluirProf")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        ProfDto prof = service.list().get(dp);
        model.addAttribute("prof", prof);
        return "deletarProf";
    }

    @GetMapping("/alterarProf")
	public String alterarProf(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	ProfDto prof = service.list().get(dP);
    	model.addAttribute("prof", prof);
        	return "alterarProf";
	}
    
    @PostMapping("/altProf")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute ProfDto prof ) {
    	service.edit(id, prof);
		  return  "redirect:/listarProfs";
    }
    
}

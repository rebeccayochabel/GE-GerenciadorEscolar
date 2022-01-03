package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.AtividadeDto;
import br.com.gerenciadorescolar.ge.service.ServiceAtv;

@Controller
public class AtividadeController {

    @Autowired
    private ServiceAtv service;

    @GetMapping(value = "/cadastrarAtividade")
    public String formaCad(Model model){
        model.addAttribute("atividade", new AtividadeDto());
        return "cadAtv.html";
    }

    @PostMapping("/atividadeAdd")
    public String greetingSubmit(@ModelAttribute AtividadeDto atividade, Model model){
        service.add(atividade);
        model.addAttribute("atividade", atividade);

        return "redirect:listarAtividades";
    }
    
    @GetMapping(value = "/listarAtividades")
    public String list(Model model){
        model.addAttribute("atividadeList", service.list());
        return "listarAtividades.html";
    }
    
    @GetMapping(value = "/deletarAtividade")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarAtividades";
    }

    @GetMapping(value = "/excluirAtividade")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        AtividadeDto atividade = service.list().get(dp);
        model.addAttribute("atividade", atividade);
        return "deletarAtividade";
    }

    @GetMapping("/alterarAtividade")
	public String alterarPaciente(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	AtividadeDto atividade = service.list().get(dP);
    	model.addAttribute("atividade", atividade);
        	return "alterarAtividade";
	}
    
    @PostMapping("/altAtividade")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute AtividadeDto atividade ) {
    	service.edit(id, atividade);
		  return  "redirect:/listarAtividades";
    }

    //Listagem pro aluno
    @GetMapping(value = "/listarAtividadesAluno")
    public String listA(Model model){
        model.addAttribute("atividadeList", service.list());
        return "listarAtividadesA";
    }
}

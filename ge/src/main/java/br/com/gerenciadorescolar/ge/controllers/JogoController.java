package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.JogoDto;
import br.com.gerenciadorescolar.ge.service.ServiceJogo;

@Controller
public class JogoController {

    @Autowired
    private ServiceJogo service;

    @GetMapping(value = "/cadastrarJogo")
    public String formaCad(Model model){
        model.addAttribute("jogo", new JogoDto());
        return "cadJogo.html";
    }

    @PostMapping("/jogoAdd")
    public String greetingSubmit(@ModelAttribute JogoDto jogo, Model model){
        service.add(jogo);
        model.addAttribute("jogo", jogo);

        return "redirect:listarJogos";
    }
    
    @GetMapping(value = "/listarJogos")
    public String list(Model model){
        model.addAttribute("jogoList", service.list());
        return "listarJogos.html";
    }
    
    @GetMapping(value = "/deletarJogo")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarJogos";
    }

    @GetMapping(value = "/excluirJogo")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        JogoDto jogo = service.list().get(dp);
        model.addAttribute("jogo", jogo);
        return "deletarJogo";
    }

    @GetMapping("/alterarJogo")
	public String alterarjogo(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	JogoDto jogo = service.list().get(dP);
    	model.addAttribute("jogo", jogo);
        	return "alterarJogo";
	}
    
    @PostMapping("/altJogo")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute JogoDto jogo ) {
    	service.edit(id, jogo);
		  return  "redirect:/listarJogos";
    }

    //listagem pro aluno
    @GetMapping(value = "/listarJogosAluno")
    public String listA(Model model){
        model.addAttribute("jogoList", service.list());
        return "listarJogosA";
    }
}

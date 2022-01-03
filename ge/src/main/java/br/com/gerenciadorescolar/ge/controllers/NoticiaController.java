package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.NoticiaDto;
import br.com.gerenciadorescolar.ge.service.ServiceNoticia;

@Controller
public class NoticiaController {

    @Autowired
    private ServiceNoticia service;

    @GetMapping(value = "/cadastrarNoticia")
    public String formaCad(Model model){
        model.addAttribute("noticia", new NoticiaDto());
        return "cadNoticia.html";
    }

    @PostMapping("/noticiaAdd")
    public String greetingSubmit(@ModelAttribute NoticiaDto noticia, Model model){
        service.add(noticia);
        model.addAttribute("noticia", noticia);

        return "redirect:listarNoticias";
    }

    @GetMapping(value = "/listarNoticias")
    public String list(Model model){
        model.addAttribute("noticiaList", service.list());
        return "listarNoticias.html";
    }
    
    @GetMapping(value = "/deletarNoticia")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarNoticias";
    }

    @GetMapping(value = "/excluirNoticia")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        NoticiaDto noticia = service.list().get(dp);
        model.addAttribute("noticia", noticia);
        return "deletarNoticia";
    }

    @GetMapping("/alterarNoticia")
	public String alterarNoticia(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	NoticiaDto noticia = service.list().get(dP);
    	model.addAttribute("noticia", noticia);
        	return "alterarNoticia";
	}
    
    @PostMapping("/altNoticia")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute NoticiaDto noticia ) {
    	service.edit(id, noticia);
		  return  "redirect:/listarNoticias";
    }

    //listagem pro aluno
    @GetMapping(value = "/listarNoticiasAluno")
    public String listA(Model model){
        model.addAttribute("noticiaList", service.list());
        return "listarNoticiasA";
    }
    
}

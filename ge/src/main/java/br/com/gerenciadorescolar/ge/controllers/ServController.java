package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.ServDto;
import br.com.gerenciadorescolar.ge.service.ServiceServ;

@Controller
public class ServController {
    
    @Autowired
    private ServiceServ service;

    @GetMapping(value = "/cadastrarServidor")
    public String formaCad(Model model){
        model.addAttribute("serv", new ServDto());
        return "cadServ.html";
    }

    @PostMapping("/servAdd")
    public String greetingSubmit(@ModelAttribute ServDto serv, Model model){
        service.add(serv);
        model.addAttribute("atividade", serv);

        return "redirect:listarServs";
    }

    @GetMapping(value = "/listarServs")
    public String list(Model model){
        model.addAttribute("servList", service.list());
        return "listarServs.html";
    }
    
    @GetMapping(value = "/deletarServ")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarServs";
    }

    @GetMapping(value = "/excluirServ")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        ServDto serv = service.list().get(dp);
        model.addAttribute("serv", serv);
        return "deletarServ";
    }

    @GetMapping("/alterarServ")
	public String alterarServ(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	ServDto serv = service.list().get(dP);
    	model.addAttribute("serv", serv);
        	return "alterarServ";
	}
    
    @PostMapping("/altServ")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute ServDto serv ) {
    	service.edit(id, serv);
		  return  "redirect:/listarServs";
    }

}

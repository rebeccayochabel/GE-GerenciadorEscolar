package br.com.gerenciadorescolar.ge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gerenciadorescolar.ge.DTO.AlunoDto;
import br.com.gerenciadorescolar.ge.service.ServiceAluno;
import br.com.gerenciadorescolar.ge.service.ServiceTurma;

@Controller
public class AlunoController {

	@Autowired 
    private ServiceAluno service;

    @Autowired
    private ServiceTurma serviceTurma;
	
    @GetMapping(value = "/cadastrarAluno")
    public String formCad(Model model){
    	model.addAttribute("aluno", new AlunoDto());
        model.addAttribute("turmaList", serviceTurma.list());
        return "cadAluno.html";
    }
    
    @PostMapping("/alunoAdd")
	public String greetingSubmit(@ModelAttribute AlunoDto aluno, Model model) {
		  service.add(aluno);
		  model.addAttribute("aluno", aluno);
		  //Faltando o tratamento de erro do firebase
		  return "redirect:listarAlunos";
	 }
  
	@GetMapping(value = "/listarAlunos")
    public String list(Model model){
        model.addAttribute("alunosList", service.list());
        return "listarAlunos.html";
    }
    
    @GetMapping(value = "/deletarAluno")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarAlunos";
    }

    @GetMapping(value = "/excluirAluno")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        AlunoDto aluno = service.list().get(dp);
        model.addAttribute("aluno", aluno);
        return "deletarAluno";
    }

    @GetMapping("/alterarAluno")
	public String alterarPaciente(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	AlunoDto aluno = service.list().get(dP);
    	model.addAttribute("aluno", aluno);
        model.addAttribute("turmaList", serviceTurma.list());
        	return "alterarAluno";
	}
    
    @PostMapping("/altAluno")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute AlunoDto aluno ) {
    	service.edit(id, aluno);
		  return  "redirect:/listarAlunos";
    }

}
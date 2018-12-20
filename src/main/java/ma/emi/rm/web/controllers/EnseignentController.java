package ma.emi.rm.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ma.emi.rm.business.enseignant.EnseignantService;
import ma.emi.rm.model.entities.Enseignant;

@Controller
public class EnseignentController {
	
	@Autowired
	private EnseignantService enseignantService;
	
	@GetMapping("/")
	public String seConnecter()
	{
		return "custom_login";
	}
	
	@GetMapping("/signUp")
	public String signUpForm(Model model)
	{
		Enseignant enseignant = new Enseignant();
		model.addAttribute("enseignant",enseignant);
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String add(Enseignant enseignant)
	{
		enseignant.setRole("ENSEIGNANT");
		enseignantService.saveEnseignant(enseignant);
		return "custom_login";
	}
	
	
}

package ma.emi.rm.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.emi.rm.business.demande.DemandeService;
import ma.emi.rm.business.enseignant.EnseignantService;
import ma.emi.rm.model.entities.Enseignant;

@Controller
public class DemandeController {
	@Autowired
	private DemandeService demandeService;
	
	@Autowired
	private EnseignantService enseignantService;
	
	@RequestMapping("/mesDemandes")
	public String consulterDemande(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String enseignantEmail = user.getUsername();
		System.out.println(enseignantEmail);
		Enseignant enseignant = enseignantService.findEnseignantByEmail(enseignantEmail);
		model.addAttribute("demandes",demandeService.demandeForEnseignant(enseignant));
		return "listDemandes";
	}
}

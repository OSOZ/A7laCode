package ma.emi.rm.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.emi.rm.business.inventaire.InventaireService;
import ma.emi.rm.model.entities.Inventaire;

@Controller
public class InventaireController {
	@Autowired
	private InventaireService inventaireService;
	
	@GetMapping("/inventaire")
	public String getInventaire(Model model,Authentication authentication)
	{
		List<Inventaire> inventaireList = inventaireService.getAllInventaire();
		model.addAttribute("invntaireList",inventaireList);
		model.addAttribute("role",authentication.getAuthorities().iterator().next());
		return "inventaire";
	}
	
	@GetMapping("/inventaire/materiels")
	public String getMateriels(@RequestParam("id") Integer inventaireId,Model model,Authentication authentication)
	{
		model.addAttribute("materiels",inventaireService.getAllByIdInventaire(inventaireId));
		model.addAttribute("inventaireId",inventaireId);
		model.addAttribute("role",authentication.getAuthorities().iterator().next());
		return "materiels";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/inventaire/supprimer")
	public String delete(@RequestParam("id") Integer inventaireId)
	{
		inventaireService.deleteInventaire(inventaireId);
		return "redirect:/inventaire";
	}
}

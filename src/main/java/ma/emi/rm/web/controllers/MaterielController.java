package ma.emi.rm.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.emi.rm.business.demande.DemandeService;
import ma.emi.rm.business.inventaire.InventaireService;
import ma.emi.rm.business.materiel.MaterielService;
import ma.emi.rm.model.entities.Inventaire;
import ma.emi.rm.model.entities.Materiel;
import ma.emi.rm.model.modelView.MaterielModelView;
import ma.emi.rm.utils.GeneratePdfForDemande;

@Controller
public class MaterielController {
	@Autowired
	private InventaireService inventaireService;
	@Autowired
	private MaterielService materielService;
	@Autowired DemandeService demandeService;
	@GetMapping("/inventaire/materiels/addMateriel")
	public String addMateriel(Model model, @RequestParam("id") Integer inventaireId)
	{
		MaterielModelView materiel = new MaterielModelView();
		materiel.setInventaireId(inventaireId);
		model.addAttribute("materiel",materiel);
		return "addMaterielFrom";
	}
	
	@PostMapping("/inventaire/materiels/addMateriel")
	public String addMateriel(MaterielModelView materielView)
	{
		Inventaire inventaire = inventaireService.searchInventaire(materielView.getInventaireId());
		Materiel materiel = new Materiel();
		materiel.setInventaire(inventaire);
		materiel.setName(materielView.getName());
		materiel.setRef(materielView.getRef());
		materiel.setDateDentree(materielView.getDateDentree());
		materiel.setLieu(materielView.getLieu());
		materielService.addMateriel(materiel);
		return "redirect:/inventaire/materiels/?id="+inventaire.getInventaireId();
	}
	
	@GetMapping("/materiels/demander")
	public String demanderMateriel(@RequestParam("id") Integer materielId) throws UnsupportedEncodingException
	{
		Materiel materiel = materielService.searchMateriel(materielId);
		if(materiel.isDisponible())
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User enseignant = (User) authentication.getPrincipal();
			ByteArrayInputStream pdf = GeneratePdfForDemande.pdfForDemande(materiel);
			demandeService.demanderMateriel(pdf,enseignant.getUsername());
			materiel.setDisponible(false);
			materielService.addMateriel(materiel);
		}
		System.out.println("send");
		return "redirect:/inventaire";
	}
	
	@GetMapping("/inventaire/materiels/editer")
	public String editerMateriel(@RequestParam("id") Integer id)
	{
		return "editMaterielForm";
	}
}

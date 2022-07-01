
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Groupe 3
 *
 */
@Controller
public class ControllerCreerEmprunt {

	private ServiceEmprunt serviceEmprunt;

	// Mapping au JSP "emprunt-creer" & "emprunt-ok"
	@GetMapping("/emprunt")
	public String afficher(Model model) {
		model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
		return "emprunt-creer";
	}

	@PostMapping("/emprunt")
	public String recevoir(Model model, @RequestParam("livreId") Integer livreId,
			@RequestParam("emprunteur") String emprunteur) {
		if (emprunteur.length() < 2) {
			model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
			model.addAttribute("erreur", "Erreurs dans le formulaire");
			return "emprunt-creer";
		} else {
			serviceEmprunt.enregistrer(livreId, emprunteur);
			model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
			model.addAttribute("ajout", "Emprunt enregistré avec succès");
			return "emprunt-creer-ok";
		}
	}

	// Injection de la classe de Service
	@Autowired
	public void setServiceEmprunt(ServiceEmprunt serviceEmprunt) {
		this.serviceEmprunt = serviceEmprunt;
	}
}
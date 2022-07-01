
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
public class ControllerModifierEmprunt {

	private ServiceEmprunt serviceEmprunt;

	// Mapping au JSP "emprunt-modifier"
	@GetMapping("/emprunt/modifier")
	public String afficherModif(Model model) {
		model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
		return "emprunt-modifier";
	}

	@PostMapping("/emprunt/modifier")
	public String modifier(Model model, @RequestParam("empruntId") int empruntId,
			@RequestParam("dateRestitution") String dateRestitution) {
		if (
		// empecher la modif d'un emprunt qui n'existe pas
		empruntId > serviceEmprunt.lireEmprunt().size() || empruntId < 1
		// empecher modif si le livre est déjà rendu
				|| !(serviceEmprunt.lireEmprunt().get(empruntId).getDateRestitution() == null)) {
			model.addAttribute("erreur", "Le numéro d'emprunt n'existe pas ou le livre est déjà emprunté");
			model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
			return "emprunt-modifier";
		} else {
			// modification de l'emprunt
			serviceEmprunt.modifierEmprunt(empruntId, dateRestitution);
			model.addAttribute("emprunts", serviceEmprunt.lireEmprunt());
			model.addAttribute("modif", "Emprunt rendu avec succès");
			return "emprunt-modifier-ok";
		}
	}

	// Injection de la classe de Service
	@Autowired
	public void setServiceEmprunt(ServiceEmprunt serviceEmprunt) {
		this.serviceEmprunt = serviceEmprunt;
	}
}
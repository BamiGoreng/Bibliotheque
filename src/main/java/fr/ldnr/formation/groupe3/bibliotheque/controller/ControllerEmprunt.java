
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

/**
 * @author Groupe 3
 *
 */
@Controller
public class ControllerEmprunt {

	private ServiceEmprunt serviceEmprunt;

	@PostMapping("/emprunt")
	public String recevoir(
			Model model, 
			@RequestParam("livre") Livre livre,
			@RequestParam("emprunteur") String emprunteur) {
		// TODO : conditions de validation du formulaire
		//if (titre.length() < 5 || anneeEdition ) {
			// Message d'erreur en cas de mauvaise saisie
			// TODO : mettre REQUIRED dans les inputs JSP pour + de sécurité
			//model.addAttribute("message", "Erreurs dans le formulaire");
			//return "livre-creer";
		//}else {
			// Enregistrement en BDD
			serviceEmprunt.enregistrer(livre, emprunteur);
			return "emprunt-ok";
		//}
	}

	// Mapping au JSP "emprunt-liste" avec attribut "emprunt"
	@RequestMapping("/emprunt/liste")
	public String lister(Model model) {
		model.addAttribute("emprunt", serviceEmprunt.lireEmprunt());
		return "emprunt-liste";
	}

	 //Injection de la classe de Service
	@Autowired
	public void setServiceEmprunt(ServiceEmprunt serviceEmprunt) {
		this.serviceEmprunt = serviceEmprunt;
	}	
}

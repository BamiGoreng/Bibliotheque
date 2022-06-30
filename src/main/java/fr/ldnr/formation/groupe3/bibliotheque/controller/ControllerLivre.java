package fr.ldnr.formation.groupe3.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe Controller de livres
 * 
 * Intéraction entre des données saisies par un user (JSP) et notre application JAVA + notre BDD et mise à jour des JSP
 * 
 * Sequence d'une entree de donnee par un user : JSP => JAVA => BDD
 * 
 * Sequence de requete de donnee par un user : BDD => JAVA => JSP
 * 
 * Imbrication des heritages : hibernate => service => controller
 * @author Groupe 3
 *
 */
@Controller
public class ControllerLivre {

	private ServiceLivre serviceLivre;
/**
 * 
 * @return
 */
	@GetMapping("/livre") // URL a taper après http://localhost:8080
	public String afficher() {
		return "livre-creer"; // retourne un JSP
	}
	
	@PostMapping("/livre")
	// Recuperation des données saisies dans le formulaire de creation de livre
	public String recevoir(Model model, @RequestParam("titre") String titre,
			@RequestParam("anneeEdition") String anneeEditionString, @RequestParam("editeur") String editeur,
			@RequestParam("prenomAuteur") String prenomAuteur, @RequestParam("nomAuteur") String nomAuteur) {
		// conditions de validation du formulaire
		if (titre.length() < 1 || editeur.length() < 1 || prenomAuteur.length() < 1 || nomAuteur.length() < 1) {
			// Message d'erreur en cas de mauvaise saisie
			model.addAttribute("erreur", "Erreurs dans le formulaire");
			return "livre-creer";
		} else {
			// Enregistrement en BDD
			serviceLivre.enregistrer(titre, anneeEditionString, editeur, prenomAuteur, nomAuteur);
			model.addAttribute("validation", "Livre enregistré avec succès");
			return "livre-ok";
		}
	}

	// Mapping au JSP "livre-liste" avec attribut "livres"
	@RequestMapping("/livre/liste")
	public String lister(Model model) {
		model.addAttribute("livres", serviceLivre.lireLivres());
		return "livre-liste";
	}

	// Injection de la classe de Service
	@Autowired
	public void setServiceLivre(ServiceLivre serviceLivre) {
		this.serviceLivre = serviceLivre;
	}
}

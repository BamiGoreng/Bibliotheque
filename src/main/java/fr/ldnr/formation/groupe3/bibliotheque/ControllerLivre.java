package fr.ldnr.formation.groupe3.bibliotheque;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe Controller de livres
 * 
 * @author Groupe 3
 *
 */
@Controller
public class ControllerLivre {

	private ServiceLivre serviceLivre;

	@PostMapping("/livre")
	// Recuperation des données saisies dans le formulaire de creation de livre
	public String recevoir(Model model, @RequestParam("titre") String titre,
			@RequestParam("anneeEdition") LocalDate anneeEdition, @RequestParam("editeur") String editeur,
			@RequestParam("prenomAuteur") String prenomAuteur, @RequestParam("nomAuteur") String nomAuteur) {
		// TODO : conditions de validation du formulaire
		// if (titre.length() < 5 || anneeEdition ) {
		// Message d'erreur en cas de mauvaise saisie
		// TODO : mettre REQUIRED dans les inputs JSP pour + de sécurité
		// model.addAttribute("message", "Erreurs dans le formulaire");
		// return "livre-creer";
		// }else {
		// Enregistrement en BDD
		serviceLivre.enregistrer(titre, anneeEdition, editeur, prenomAuteur, nomAuteur);
		return "livre-ok";
		// }
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

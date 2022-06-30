
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Groupe 3
 *
 */
@Controller
public class ControllerMenu {
	@GetMapping("/bibliotheque")
	public String afficher() {
		return "bibliotheque";
	}
}

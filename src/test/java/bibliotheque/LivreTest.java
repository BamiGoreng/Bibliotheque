package bibliotheque;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

public class LivreTest {

	// Test pour tester les méthodes de la class Livre
	@Test
	public void testGetId() {
		// 1er test pour obtenir l'identifiant d'un livre
		// Au moment de la création d'un objet Livre son identifiant est 0
		// Et il n'autoincremente pas que quand il est persisté en base de donnés
		Livre l1 = new Livre("L'Homme chauve-souris", "02-06-1997", "Gaïa", "Jo", "Nesbo");
		Livre l2 = new Livre("L'Homme chauve-souris", "02-06-1997", "Gaïa", "Jo", "Nesbo");
		int obtenu = l1.getIdLivre();
		assertEquals(0, obtenu);
		int obtenu2 = l2.getIdLivre();
		assertEquals(0, obtenu2);
	}

	@Test
	public void testToString() {
		// 2d test pour l'affiche des attributs d'un objet Livre
		// pour un Livre crée nous comparons l'affichage attendu avec cel que test
		// génère.
		Livre l = new Livre("L'Homme chauve-souris", "02-06-1997", "Gaïa", "Jo", "Nesbo");
		String obtenu = l.toString();
		assertEquals("Livre [idLivre=0, titre=L'Homme chauve-souris, anneeEdition=1997,"
				+ " editeur=Gaïa, prenom=Jo, nom=Nesbo]", obtenu);
	}

	@Test
	public void testGetEditeur() {
		// 3e test pour faire le test que le champ Editeur si nous le laissons vide
		// il reste vide
		Livre l = new Livre("L'Homme chauve-souris", "02-06-1997", null, "Jo", "Nesbo");
		String obtenu = l.getEditeur();
		assertEquals(null, obtenu);

	}

	@Test
	public void testSetNomAuteur() {
		// 4e test pour verifier que nous pouvons changer le nom du champ nom dans
		// la class Livre
		Livre l = new Livre("L'Homme chauve-souris", "02-06-1997", null, "Jo", "Nesbo");
		l.setNomAuteur("Arnald");
		String obtenu = l.getNomAuteur();
		assertEquals("Arnald", obtenu);
	}

}

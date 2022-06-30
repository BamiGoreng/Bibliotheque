
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

/**
 * @author Groupe3
 * Relation entre Objets Java et BDD (SQLite)
 */
@Service
public class ServiceLivre {

	private SessionFactory sessionFactory;

	/**
	 * 
	 * Persister un objet Livre en BDD
	 * 
	 * @param titre
	 * @param anneeEditionString
	 * @param editeur
	 * @param prenomAuteur
	 * @param nomAuteur
	 * 
	 */
	public void enregistrer(String titre, String anneeEditionString, String editeur, String prenomAuteur,
			String nomAuteur) {
		Session session = sessionFactory.openSession(); // debut de session
		Transaction tx = session.beginTransaction(); // debut de transaction
		session.save(new Livre(titre, anneeEditionString, editeur, prenomAuteur, nomAuteur)); // methode session.save() => persiste l'objet Java en BDD
		tx.commit(); // fin de transaction
		session.close(); // fin de session
	}
	
/**
 * 
 * Récupérer la donnée présente dans la base et la stocker dans un objet Java
 * @return liste
 */
	public List<Livre> lireLivres() {
		Session session = sessionFactory.openSession();
		// createQuery fait un "SELECT *" par défaut, d'ou son absence avant "From Livre"
		List<Livre> liste = session.createQuery("from Livre", Livre.class).list(); // pour accéder à la BDD, il faut passer par une query et le nom de la classe !!! ( et pas le nom de la table)
		session.close();
		return liste;
	}
	
	// Pas encore utilisé TODO : A SUPPR
	public List<Livre> lireLivresId() {
		Session session = sessionFactory.openSession();
		List<Livre> liste = session.createQuery("SELECT id FROM Livre", Livre.class).list();
		session.close();
		return liste;
	}

	// Injection de la classe SessionFactory dans le ServiceLivre
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

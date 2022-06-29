
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

/**
 * @author Groupe3
 *
 */
@Service
public class ServiceLivre {

	private SessionFactory sessionFactory;

	public void enregistrer(String titre, LocalDate anneeEdition, String editeur, String prenomAuteur,
			String nomAuteur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(new Livre(titre, anneeEdition, editeur, prenomAuteur, nomAuteur));
		tx.commit();
		session.close();
	}

	public List<Livre> lireLivres() {
		Session session = sessionFactory.openSession();
		List<Livre> liste = session.createQuery("from Livre", Livre.class).list();
		session.close();
		return liste;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

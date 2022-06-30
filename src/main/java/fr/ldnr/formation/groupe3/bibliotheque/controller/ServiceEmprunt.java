/**
 * 
 */
package fr.ldnr.formation.groupe3.bibliotheque.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ldnr.formation.groupe3.bibliotheque.model.Emprunt;
import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

/**
 * @author Groupe 3
 *
 */
@Service
public class ServiceEmprunt {

	private SessionFactory sessionFactory;


	public void enregistrer(int livreId, String emprunteur) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Livre livre = session.load(Livre.class, livreId);
		session.save(new Emprunt(livre, emprunteur));
		tx.commit();
		session.close();
	}

	public List<Emprunt> lireEmprunt() {
		Session session = sessionFactory.openSession();
		List<Emprunt> liste = session.createQuery("from Emprunt", Emprunt.class).list();
		session.close();
		return liste;
	}
	
	public void modifierEmprunt(int idEmprunt, String dateRestitution) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Emprunt emprunt= session.load(Emprunt.class,idEmprunt);
		emprunt.setDateRestitution(dateRestitution);
		session.save(emprunt);
		tx.commit();
		session.close();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
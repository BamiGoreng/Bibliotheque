/**
 * 
 */
package fr.ldnr.formation.groupe3.bibliotheque;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cedo
 *
 */
@Service
public class ServiceEmprunt {

	private SessionFactory sessionFactory;

	public void enregistrer(Livre livre, String emprunteur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
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

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
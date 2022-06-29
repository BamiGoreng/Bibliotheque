
package fr.ldnr.formation.groupe3.bibliotheque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author cedo
 *
 */
@Entity
@Table(name = "emprunts")
public class Emprunt {

	private int idEmprunt;
	private Livre livre;
	private String emprunteur;
	private LocalDate dateEmprunt;
	private LocalDate dateRestitution;
	private boolean perdu = false;

	public Emprunt() {
		this(null, null);
	}

	public Emprunt(Livre livre, String emprunteur) {
		this.idEmprunt = 0;
		this.livre = livre;
		this.emprunteur = emprunteur;
		this.dateEmprunt = LocalDate.now();
		this.dateRestitution = dateEmprunt.plusDays(15);
	}

	@Override
	public String toString() {
		return "Emprunt [livre=" + livre + ", emprunteur=" + emprunteur + ", dateEmprunt=" + dateEmprunt
				+ ", dateRestitution=" + dateRestitution + ", perdu=" + perdu + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	// un livre concerne 1 ou plusieurs emprunts
	@ManyToOne(optional = false, fetch = FetchType.LAZY) // fonctionne mais erreurs
	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	@Column(nullable = false, length = 100)
	public String getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(String emprunteur) {
		this.emprunteur = emprunteur;
	}

	@Column(nullable = false)
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	@Column(nullable = false)
	public LocalDate getDateRestitution() {
		return dateRestitution;
	}

	public void setDateRestitution(LocalDate dateRestitution) {
		this.dateRestitution = dateRestitution;
	}

	@Column(nullable = false)
	public boolean isPerdu() {
		return perdu;
	}

	public void setPerdu(boolean perdu) {
		this.perdu = perdu;
	}
}

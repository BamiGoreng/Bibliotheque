
package fr.ldnr.formation.groupe3.bibliotheque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Groupe 3
 *
 */

@Entity
@Table(name = "livres") // nom de la table en BDD
public class Livre {

	private int idLivre;
	private String titre;
	private String anneeEdition;
	private String editeur;
	private String prenomAuteur;
	private String nomAuteur;

	public Livre(String titre, String anneeEdition, String editeur, String prenom, String nom) {
		this.idLivre = 0;
		this.titre = titre;
		this.anneeEdition = anneeEdition;
		this.editeur = editeur;
		this.prenomAuteur = prenom;
		this.nomAuteur = nom;
	}

	public Livre() {
		this(null, null, null, null, null);
	}

	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", titre=" + titre + ", anneeEdition=" + anneeEdition + ", editeur="
				+ editeur + ", prenom=" + prenomAuteur + ", nom=" + nomAuteur + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	@Column(nullable = false, length = 100)
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(nullable = false)
	public String getAnneeEdition() {
		return anneeEdition;
	}

	public void setAnneeEdition(String anneeEdition) {
		this.anneeEdition = anneeEdition;
	}
	

	@Column(nullable = false, length = 50)
	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	@Column(nullable = false, length = 20)
	public String getPrenomAuteur() {
		return prenomAuteur;
	}

	public void setPrenomAuteur(String prenom) {
		this.prenomAuteur = prenom;
	}

	@Column(nullable = false, length = 20)
	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nom) {
		this.nomAuteur = nom;
	}
}

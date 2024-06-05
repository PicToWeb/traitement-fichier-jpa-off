package entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
public class Allergenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	@ManyToMany
	@JoinTable(name = "prod_allergene", joinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_prod", referencedColumnName = "id"))
	private Set<Produit> produits = new HashSet<>();

	/**
	 * Constructor
	 * 
	 */
	public Allergenes() {

	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 */
	public Allergenes(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter for nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter for nom
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter for produits
	 * 
	 * @return the produits
	 */
	public Set<Produit> getProduits() {
		return produits;
	}

	/**
	 * Setter for produits
	 * 
	 * @param produits the produits to set
	 */
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}

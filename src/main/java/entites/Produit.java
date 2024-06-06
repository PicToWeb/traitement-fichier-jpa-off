package entites;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fr.diginamic.recensement.Exception.MessageException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@Column(name="nutrition_grade_fr",length=5)
	private String nutritionGradeFr;

	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_marque")
	private Marque marque;
	
	@ManyToMany
	@JoinTable(name = "prod_ingredients", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_ing", referencedColumnName = "id"))
	private Set<Ingredients> ingredients = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "prod_allergene", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
	private Set<Allergenes> allergenes = new HashSet<>();

	/** Constructor
	 * 
	 */
	public Produit() {
		
	}
	

	/** Constructor
	 * @param nom
	 */
	public Produit(String nom,String grade) {
		this.nom = nom;
		this.nutritionGradeFr=grade;
	}
	
	public void traiter(Recensement prod,String ajout) {


		boolean villeExist = false;
		List<Produit> produits = prod.getProduits();
		for (Produit produit : produits) {
			if (produit.getNom().equalsIgnoreCase(ajout)
					|| produit.getNom().toLowerCase().startsWith(ajout.toLowerCase())) {
				villeExist = true;
				System.out.println(produit);
			}
		}
//		if (!villeExist) {
//			throw new MessageException("Le ville n'est pas reconnu");
//		}
		
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", nutritionGradeFr=" + nutritionGradeFr + ", categorie="
				+ categorie + ", marque=" + marque + getCategorie().getNom() + getIngredients().toString() + "]  \n";
	}
	


	/** Getter for nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter for nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter for categorie
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/** Setter for categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/** Getter for marque
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/** Setter for marque
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/** Getter for ingredients
	 * @return the ingredients
	 */
	public Set<Ingredients> getIngredients() {
		return ingredients;
	}

	/** Setter for ingredients
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	/** Getter for allergenes
	 * @return the allergenes
	 */
	public Set<Allergenes> getAllergenes() {
		return allergenes;
	}

	/** Setter for allergenes
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(Set<Allergenes> allergenes) {
		this.allergenes = allergenes;
	}


	/** Getter for nutritionGradeFr
	 * @return the nutritionGradeFr
	 */
	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}


	/** Setter for nutritionGradeFr
	 * @param nutritionGradeFr the nutritionGradeFr to set
	 */
	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}


	
	
	
	
	
	
	
			
	
}

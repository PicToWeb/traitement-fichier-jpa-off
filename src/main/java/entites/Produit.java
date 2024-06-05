package entites;

import java.util.HashSet;
import java.util.Set;

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
	
	@Column(name="nutrition_grade_fr")
	private char nutritionGradeFr;

	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_marque")
	private Marque marque;
	
	@ManyToMany
	@JoinTable(name = "prod_ingredients", joinColumns = @JoinColumn(name = "id_prod", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_ing", referencedColumnName = "id"))
	private Set<Ingredients> ingredients = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "prod_allergene", joinColumns = @JoinColumn(name = "id_prod", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
	private Set<Allergenes> allergenes = new HashSet<>();

	/** Constructor
	 * 
	 */
	public Produit() {
		
	}
	

	/** Constructor
	 * @param nom
	 */
	public Produit(String nom) {
		super();
		this.nom = nom;
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
	
	
	
	
			
	
}

package utils;

import entites.Categorie;
import entites.Ingredients;
import entites.Marque;
import entites.Produit;
import entites.Recensement;
import jakarta.persistence.EntityManager;


/** Permet de constituer notre recensement progressivement é partir des lignes du fichier
 * @author DIGINAMIC
 *
 */
public class ParseurProduit {
	
	/** Ajoute une ligne représentant une ville au recensement
	 * @param recensement recensement é compléter
	 * @param ligne ligne de laquelle on extrait une ville
	 */
	public static void ajoutLigne(Recensement recensement, String ligne){
		
		String[] colonne = ligne.split("\\|",-1);
		
		String categorie = colonne[0];
		String marque = colonne[1];
		String nomProduit = colonne[2];
		String nutriGrade = colonne[3];
		String [] ingredients = colonne[4].split(",");
		
		//String allergenes = morceaux[28];
		//int ingredientTotal = Integer.parseInt(ingredients.replace(" ", "").trim());
		
		
		
	
		
		Categorie cat = new Categorie(categorie);
		Produit prod = new Produit(nomProduit,nutriGrade);
		Marque marq = new Marque(marque);
		
		for( String ingredient : ingredients)
		{
			Ingredients ing = new Ingredients(ingredient);
			prod.getIngredients().add(ing);
			
		}
		
		
		
		prod.setMarque(marq);
		prod.setCategorie(cat);
		
		
		
		
		
		
		recensement.getProduits().add(prod);
	}

}

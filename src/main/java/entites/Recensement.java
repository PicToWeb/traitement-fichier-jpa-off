package entites;

import java.util.ArrayList;

import java.util.List;


/** Données du recensement
 * @author DIGINAMIC
 *
 */
public class Recensement {
	
	/** villes : List<Produit>*/
	private List<Produit> produits  = new ArrayList<>();

//	public boolean codeDepartementExiste(String codeDept) {
//		
//		for (Produit ville:villes) {
//			if (ville.getCodeDepartement().equals(codeDept)) {
//				return true;
//			}
//		}
//		return false;
//	}
	/** Getter
	 * @return the villes
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/** Setter
	 * @param villes the villes to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}

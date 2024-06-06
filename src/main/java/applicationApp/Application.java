package applicationApp;

import entites.Recensement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import utils.RecensementUtils;

public class Application {
	
	
	
	
	public static void main(String[] args) {
		
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("openFoodFact");
		//EntityManager em = entityManagerFactory.createEntityManager();
		
		String filePath = ClassLoader.getSystemClassLoader().getResource("openFoodFacts.csv").getFile();

		Recensement recensement = RecensementUtils.lire(filePath);

		//em.close();

	}

}

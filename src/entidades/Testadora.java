package entidades;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Testadora {
	
	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("automoveisPU").createEntityManager();
		
	}

}

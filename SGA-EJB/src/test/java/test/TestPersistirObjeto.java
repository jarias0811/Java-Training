package test;



import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.johnarias.sga.domain.Persona;

public class TestPersistirObjeto {

	static EntityManager em = null;
	static EntityManagerFactory emf = null;
	static EntityTransaction tx = null;
	
	Logger log = Logger.getLogger("TestEncontrarObjeto");
	
	@BeforeClass
	public static void init() throws Exception{
		EJBContainer.createEJBContainer();
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
	
	@Before 
	public void setup(){
		try{
			em = emf.createEntityManager();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testPersist(){
		//Paso1. Crea Nuevo Objeto
		//Objeto en estado transitivo
		Persona persona1 = new Persona("Pedro","Luna",null,"pluna@mail.com","19292943");
		
		//Paso2. Inicia transaccion
		
		tx = em.getTransaction();
		tx.begin();
		
		//Paso 3. Ejecuta SQL
		em.persist(persona1);
		
		tx.commit();
		
		log.debug("Objeto Persistido" + persona1);
		
	}
	
	@After
	public void tearDown() throws Exception{
		if (em != null){
			em.close();
		}
	}
}

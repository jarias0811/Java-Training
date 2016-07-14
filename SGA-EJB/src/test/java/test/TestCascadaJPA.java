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
import com.johnarias.sga.domain.Usuario;

public class TestCascadaJPA {

	static EntityManager em = null;
	static EntityManagerFactory emf = null;

	Logger log = Logger.getLogger("TestEncontrarObjeto");

	@BeforeClass
	public static void init() throws Exception {
		EJBContainer.createEJBContainer();
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}

	@Before
	public void setup() {
		try {
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testPersist() {

		// Paso 1. Inicia transacción 1
		EntityTransaction tx1 = em.getTransaction();
		tx1.begin();
		
		//Paso 2. Insertar Persona y luego usuario
		Persona persona1 = new Persona("Carlos","Parra",null,"cparra@mail.com","310000000");
		Usuario usuario1 = new Usuario("cparra", "1234", persona1);
		
		//Paso 3. Persistir el objeto usuario que tiene la referencia de persona
		//Esto es posible ya que en las clases de entidad se definieron las relaciones como cascada
		//Sino esta definida esta cascada, se debe persistir el objeto persona y luego el usuario
		em.persist(usuario1);
		
		//Paso 4. Realizar la transaccion
		tx1.commit();
		
		log.debug("Objeto persistido " + usuario1);
	}

	@After
	public void tearDown() throws Exception {
		if (em != null) {
			em.close();
		}
	}
}

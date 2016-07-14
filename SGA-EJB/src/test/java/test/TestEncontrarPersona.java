package test;

import java.util.List;

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

public class TestEncontrarPersona {

	static EntityManager em = null;
	static EntityManagerFactory emf = null;
	static EntityTransaction tx = null;

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

		String jpql = null;
		List<Persona> personas;
		// Paso1. Inicia transaccion

		tx = em.getTransaction();
		tx.begin();

		// Paso 2. Ejecuta SQL de tipo select
		log.debug("Consulta todas las personas");
		//Persona persona1 = em.find(Persona.class, 3);
		//jpql = "select p.nombre as Nombre, p.apePaterno as Paterno from Persona p ";
		jpql = "select p from Persona p";
		
		personas = em.createQuery(jpql).getResultList();
		
		//Termina Transaccion
		
		
		for (Persona persona : personas) {
			log.debug("Objeto Encontrado" + persona);
		}
		
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		if (em != null) {
			em.close();
		}
	}
}

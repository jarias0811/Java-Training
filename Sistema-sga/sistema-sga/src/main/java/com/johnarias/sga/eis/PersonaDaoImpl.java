package com.johnarias.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.johnarias.sga.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

	//Esta anotaci�n toma el nombre que tiene el archivo persistence.xml
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em; //Entity manager se usa para crear o eliminar instancias de entidades
	
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas() {
		/*Mediante el namedQuery creado en la clase entidad
		se hace el query a SQL y se obtiene una lista resultado*/
		return em.createNamedQuery("Persona.findAll").getResultList();
	}

	public Persona findPersonaById(Persona persona) {
		//Aqui se utiliza el metodo find debido a que es una llave primaria
		return em.find(Persona.class, persona.getIdPersona());
	}

	public Persona findPersonaByEmail(Persona persona) {
		//Se envia un query para buscar solo por email
		Query query = em.createQuery("FROM Persona p WHERE p.email = :email");
		query.setParameter("email", persona.getEmail());
		return (Persona) query.getSingleResult();
	}

	public void insertPersona(Persona persona) {
		//Persiste, es decir, inserta desde java un objeto
		em.persist(persona);
	}

	public void updatePersona(Persona persona) {
		/*Merge verifica si el valor en la base de datos es igual,
		sino, cuando se haga commit, JPA hara el update*/
		em.merge(persona);
	}

	public void deletePersona(Persona persona) {
		//em.merge(persona);
		Persona persona1 = new Persona();
		persona1 = em.find(Persona.class, persona.getIdPersona());
		//em.merge(persona);
		em.remove(persona1);
		em.flush();
	}

}

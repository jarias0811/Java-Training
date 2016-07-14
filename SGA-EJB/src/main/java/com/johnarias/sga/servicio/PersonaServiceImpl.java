package com.johnarias.sga.servicio;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import com.johnarias.sga.domain.Persona;
import com.johnarias.sga.eis.PersonaDao;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	@Resource //Manejo de transacciones
	private SessionContext contexto;
	
	@EJB //Se inyecta una dependecia de PersonaDao
	private PersonaDao personaDao;
	
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	public Persona encontraPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		try{
			personaDao.updatePersona(persona);
		}catch(Throwable t){
			contexto.setRollbackOnly();
		}	
	}

	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);

	}

}

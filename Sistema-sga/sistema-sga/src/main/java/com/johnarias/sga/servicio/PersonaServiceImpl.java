package com.johnarias.sga.servicio;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.johnarias.sga.domain.Persona;
import com.johnarias.sga.eis.PersonaDao;

@WebService(endpointInterface="com.johnarias.sga.servicio.PersonaServiceWS")
@Stateless
//@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
//@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class PersonaServiceImpl 
	implements PersonaServiceRemote, PersonaService, PersonaServiceWS {

	@Resource //Manejo de transacciones
	private SessionContext contexto;
	
	@EJB //Se inyecta una dependecia de PersonaDao
	private PersonaDao personaDao;
	
	@Override
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	public Persona encontraPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}
	
	@Override
	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	@Override
	public void modificarPersona(Persona persona) {
		try{
			personaDao.updatePersona(persona);
		}catch(Throwable t){
			contexto.setRollbackOnly();
		}	
	}
	
	@Override
	@RolesAllowed("ROLE_ADMIN")
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);

	}

}

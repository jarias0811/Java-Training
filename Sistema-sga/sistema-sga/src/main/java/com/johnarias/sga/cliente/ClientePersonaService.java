package com.johnarias.sga.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.johnarias.sga.domain.Persona;
import com.johnarias.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args){
		
		try {
			System.out.println("Iniciando llamada al EJB desde el cliente \n");
			Context jndi = new InitialContext();
			
			//PersonaServiceRemote personaService = (PersonaServiceRemote) 
					//jndi.lookup("java:global/sga-jee/PersonaServiceImpl!com.johnarias.sga.servicio.PersonaServiceRemote");
			
			PersonaServiceRemote personaService = (PersonaServiceRemote) 
					jndi.lookup("java:global/sistema-sga/PersonaServiceImpl!com.johnarias.sga.servicio.PersonaServiceRemote");
			
			List<Persona> personas = personaService.listarPersonas();		
			
			for (Persona persona : personas) {
				System.out.println(persona);
				if(persona.getIdPersona() == 13){
					personaService.eliminarPersona(persona);
				}
			}
			
			System.out.println("\nFin llamada al EJB desde el cliente");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}

package com.johnarias.sga.servicio.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.johnarias.sga.domain.Persona;
import com.johnarias.sga.servicio.PersonaService;

@Path("/personas")
@Stateless
public class PersonaServiceRS {

		@EJB
		PersonaService personaService;
		
		@GET
		@Produces("application/xml")
		public List<Persona> listarPersonas(){
			return personaService.listarPersonas();
		}
		
		@GET
		@Produces("application/xml")
		@Path("{id}") //Hace referencia a la URI /personas/{id}
		public Persona encontrarPersonaPorId(@PathParam("id") int id){
			return personaService.encontraPersonaPorId(new Persona(id));
		}
		
		/*@POST
		@Produces("application/xml")
		@Consumes("application/xml")
		public Response agregarPersona(Persona persona){
			try{
				personaService.registrarPersona(persona);
				return Response.ok().entity(persona).build();
			}catch(Exception e){
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
		}*/
		
		
}

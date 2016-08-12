package com.johnarias.sga.servicio.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
		
		@POST
		@Produces("application/xml")
		@Consumes("application/xml")
		public Response agregarPersona(Persona persona){
			try{
				personaService.registrarPersona(persona);
				return Response.ok().entity(persona).build();
			}catch(Exception e){
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		@PUT
		@Produces("application/xml")
		@Consumes("application/xml")
		public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
			try{
				Persona persona = personaService.encontraPersonaPorId(new Persona(id));
				if (persona != null){
					personaService.modificarPersona(personaModificada);
					return Response.ok().entity(personaModificada).build();
				}else{
					return Response.status(Status.NOT_FOUND).build();
				}
			}
			catch(Exception e){
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}	
			
		}
		
		@DELETE
		@Path("{id}")
		public Response eliminarPersonaPorId(@PathParam("id") int id){
			try{
				personaService.eliminarPersona(new Persona(id));
				return Response.ok().build();
			}catch (Exception e){
				return Response.status(404).build();
			}
		}
		
}

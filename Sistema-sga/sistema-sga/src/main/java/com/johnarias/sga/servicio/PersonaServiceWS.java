package com.johnarias.sga.servicio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.johnarias.sga.domain.Persona;

@WebService
public interface PersonaServiceWS {

	@WebMethod
	public List<Persona> listarPersonas();
	public void registrarPersona(Persona persona);
	public void modificarPersona(Persona persona);
	public void eliminarPersona(Persona persona);
}

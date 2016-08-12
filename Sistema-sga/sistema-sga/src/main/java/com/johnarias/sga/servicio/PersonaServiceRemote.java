package com.johnarias.sga.servicio;

import java.util.List;

import javax.ejb.Remote;

import com.johnarias.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {

	public List<Persona> listarPersonas();
	
	public Persona encontraPersonaPorId(Persona persona);
	
	public Persona encontrarPersonaPorEmail(Persona persona);
	
	public void registrarPersona(Persona persona);
	
	public void modificarPersona(Persona persona);
	
	public void eliminarPersona(Persona persona);
	
}

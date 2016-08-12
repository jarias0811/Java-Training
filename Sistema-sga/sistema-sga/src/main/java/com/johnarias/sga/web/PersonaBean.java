package com.johnarias.sga.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.johnarias.sga.domain.Persona;
import com.johnarias.sga.servicio.PersonaService;

//Esta clase va a ser el controlador del modelo MVC
@ManagedBean
@RequestScoped
public class PersonaBean {

	@EJB
	private PersonaService personaService;
	
	private Persona personaSelec;
	List<Persona> personas;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String email;
	private String telefono;
	
	public PersonaBean(){}
	
	//Esta anotacion hace referencia a que el metodo siguiente se ejecute luego
	//del constructor por defecto
	@PostConstruct
	public void inicializar(){
		personas = personaService.listarPersonas();
	}
	
	public void editListener(RowEditEvent event){
		Persona persona = (Persona)event.getObject();
		personaService.modificarPersona(persona);
	}
	
	
	public void removeListener(SelectEvent selectEvent){
		Persona persona = (Persona) selectEvent.getObject();
		personaService.eliminarPersona(persona);
	}
	
	public void addListener(){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApePaterno(apePaterno);
		persona.setApeMaterno(apeMaterno);
		persona.setEmail(email);
		persona.setTelefono(telefono);
		
		personaService.registrarPersona(persona);
	}
	
	public List<Persona> getPersonas(){
		return personas;
	}
	
	public void setPersonas(List<Persona> personas){
		this.personas = personas;
	}

	public Persona getPersonaSelec() {
		return personaSelec;
	}

	public void setPersonaSelec(Persona personaSelec) {
		this.personaSelec = personaSelec;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}

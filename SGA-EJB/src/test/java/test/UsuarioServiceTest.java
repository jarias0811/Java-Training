package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import com.johnarias.sga.domain.Usuario;
import com.johnarias.sga.servicio.UsuarioService;

public class UsuarioServiceTest {
	
	private UsuarioService usuarioService;
	
	@Before
	public void setUp() throws Exception{
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioService = (UsuarioService) contenedor.getContext().lookup("java:global/classes/UsuarioServiceImpl!com.johnarias.sga.servicio.UsuarioService");	
	}
	
	//@Test
	public void testEJBUsuarioService(){
		
		System.out.println("Iniciando EJB test Usuario Service");
		
		assertTrue(usuarioService != null);
		
		assertEquals(1, usuarioService.listarUsuarios().size());
		
		System.out.println("El numero de usuarios es " + usuarioService.listarUsuarios().size());
		
		this.desplegarUsuarios(usuarioService.listarUsuarios());
		
		System.out.println("Terminado EJB test Usuario Servicio");
	}

	private void desplegarUsuarios(List<Usuario> usuarios) {
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
	
}

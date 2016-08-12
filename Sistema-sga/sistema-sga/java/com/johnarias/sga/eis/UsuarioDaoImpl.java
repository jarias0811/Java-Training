package com.johnarias.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.johnarias.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext (unitName = "PersonaPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	
	public Usuario findUsuarioById(Usuario usuario) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);
	}

	
	public void removeUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove(usuario);
	}

}

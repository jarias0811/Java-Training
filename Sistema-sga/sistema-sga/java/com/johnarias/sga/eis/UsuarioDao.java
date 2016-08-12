package com.johnarias.sga.eis;

import java.util.List;

import com.johnarias.sga.domain.Usuario;

public interface UsuarioDao {

	public List<Usuario> findAllUsuarios();
	
	public Usuario findUsuarioById(Usuario usuario);
	
	public void insertUsuario(Usuario usuario);
	
	public void updateUsuario(Usuario usuario);
	
	public void removeUsuario(Usuario usuario);
	
}

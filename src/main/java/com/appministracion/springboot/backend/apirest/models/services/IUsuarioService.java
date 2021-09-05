package com.appministracion.springboot.backend.apirest.models.services;

import com.appministracion.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	

	public Usuario findByCorreo(String correo); 
	
	public Usuario insertUsuario(Usuario usuario);

}
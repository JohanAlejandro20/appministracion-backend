package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;

import com.appministracion.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	

	public Usuario findByCorreo(String correo); 
	

	public Usuario findById(long id); 
	
	public Usuario insertUsuario(Usuario usuario);
	
	public Usuario save(Usuario usuario);
	
	@Modifying
	public int UpdateUser(String name,String phone,String email,long id);
	
	
	public int  UpdateUserPassword(String name,String phone,String email,String password,long id);

}
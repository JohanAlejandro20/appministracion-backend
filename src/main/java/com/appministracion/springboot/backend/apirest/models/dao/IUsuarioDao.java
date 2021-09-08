package com.appministracion.springboot.backend.apirest.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	
	public Usuario findByCorreo(String correo);
	
//	@Query
//	public Usuario findByUsername(String username);
//	
    @Query(value = "select * from usuarios where cod_usuario = :id", nativeQuery = true )   
	public  Usuario findById(long id);
	
}
	
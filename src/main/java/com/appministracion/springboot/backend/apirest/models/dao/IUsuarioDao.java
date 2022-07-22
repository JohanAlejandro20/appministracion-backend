package com.appministracion.springboot.backend.apirest.models.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.appministracion.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	
	public Usuario findByCorreo(String correo);
	
//	@Query
//	public Usuario findByUsername(String username);
//	
    @Query(value = "select * from usuarios where cod_usuario = :id", nativeQuery = true )   
	public  Usuario findById(long id);
    
    @Transactional
    @Modifying
    @Query(value = "update usuarios u set  u.nombre = :name, u.telefono =:phone, u.correo = :email where u.cod_usuario = :id", nativeQuery = true )   
	public  int updateuser(String name, String phone, String email,long id);
    
    @Transactional
    @Modifying
    @Query(value = "update usuarios u set  u.nombre = :name, u.telefono =:phone, u.correo = :email, u.contraseña=:password where u.cod_usuario = :id", nativeQuery = true )   
	public  int updateuserPassword(String name, String phone, String email,String password,long id);
//    
     
	
}
	
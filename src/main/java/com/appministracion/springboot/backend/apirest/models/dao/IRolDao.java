package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.appministracion.springboot.backend.apirest.models.entity.Rol;



public interface IRolDao extends CrudRepository<Rol, Long> {

	
    @Query(value = "select * from roles where cod_rol = :cod_rol", nativeQuery = true )   
    public Rol findBycod_rol(long cod_rol);
	 
}

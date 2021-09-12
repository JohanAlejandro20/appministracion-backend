package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

public interface IPreguntaLiteDao extends CrudRepository<PreguntaLite, Long> {

	
    @Query(value = "select * from preguntas where cod_usuario = :id_user", nativeQuery = true )   
	public  List<PreguntaLite> findByIdUser(long id_user);
	
}

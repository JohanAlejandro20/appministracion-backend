package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

public interface IPreguntaLiteDao extends CrudRepository<PreguntaLite, Long> {

	
    @Query(value = "select * from preguntas p where cod_usuario = :id_user and (:filter is null or p.descripcion REGEXP :filter)", nativeQuery = true )   
	public  List<PreguntaLite> findByIdUser(long id_user, @Param("filter") String filter);
	 
}

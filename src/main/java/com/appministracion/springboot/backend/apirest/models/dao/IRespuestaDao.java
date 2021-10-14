package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.appministracion.springboot.backend.apirest.models.entity.Respuesta;

public interface IRespuestaDao extends CrudRepository<Respuesta, Long> {

	
	
	@Query(value = "select u.nombre as nombre_usuario, r.nombre as nombre_respuesta, r.descripcion as descripcion_respuesta from  respuestas r \n"
			+ "left join preguntas p on p.cod_pregunta = r.cod_pregunta "
			+ "inner join usuarios u on r.cod_usuario = u.cod_usuario where p.cod_pregunta =:cod_respuesta", nativeQuery = true )   
    public Map<String,Object> findByIdQuestion(long cod_respuesta);
	
}

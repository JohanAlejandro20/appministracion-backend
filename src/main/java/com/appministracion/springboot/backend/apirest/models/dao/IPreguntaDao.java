package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;


@Repository
public interface IPreguntaDao extends CrudRepository<Pregunta, Long> {

	
	@Query(value = "select * from preguntas where cod_pregunta = :cod_pregunta", nativeQuery = true )   
    public Pregunta findBycod_pregunta(long cod_pregunta);
	
    @Query(value = "select * from preguntas where cod_usuario = :id_user", nativeQuery = true )   
	public  List<Pregunta> findByIdUser(long id_user);
    
    
    @Query(value = "select p.cod_pregunta as codigo_pregunta, u.nombre as nombre_usuario, p.nombre as nombre_pregunta, p.descripcion as descripcion_pregunta, p.create_at  as fecha_creacion_pregunta, c.nombre as nombre_conjunto, r.cod_respuesta as codigo_respuesta from \n"
    		+ "usuarios u inner join preguntas p on p.cod_usuario = u.cod_usuario\n"
    		+ "inner join conjuntos c on c.cod_conjunto = u.cod_conjunto  left join respuestas r on r.cod_pregunta  = p.cod_pregunta where u.cod_conjunto = :id_conjunto", nativeQuery = true )  
    public List<Map<String,Object>> findQuestionByConjunto(long id_conjunto);
    
    
    @Query(value ="select p.cod_pregunta as cod_pregunta, p.nombre as nombre, p.descripcion  as descripcion, p.create_at  as createAt,"
    		+ "r.cod_respuesta as cod_respuesta\n"
    		+ "from preguntas p left join respuestas r on p.cod_pregunta = r.cod_pregunta where p.cod_usuario = 1 and r.cod_respuesta is not null \n"
    		+ "", nativeQuery = true)
    public List<Map<String,Object>>  findAnsweredQuestions(long id_usuario);
    
    
    @Query(value ="select p.cod_pregunta as cod_pregunta, p.nombre as nombre, p.descripcion  as descripcion, p.create_at  as createAt,"
    		+ "r.cod_respuesta as cod_respuesta\n"
    		+ "from preguntas p left join respuestas r on p.cod_pregunta = r.cod_pregunta where p.cod_usuario = 1 and r.cod_respuesta is null \n"
    		+ "", nativeQuery = true)
    public List<Map<String,Object>>  findNotAnsweredQuestions(long id_usuario);
    
    
	
} 

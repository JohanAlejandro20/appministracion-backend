package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;

import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

public interface IPreguntaService {

	
	public Pregunta InsertPregunta(Pregunta pregunta);
	
	
	public List<PreguntaLite> findByIdUser(long id_user);
	
	
	public List<Map<String,Object>> findQuestionByConjunto(long id_conjunto);
	
	public Pregunta findById(long cod_pregunta);	
	
	public List<Map<String,Object>> findAnsweredQuestions(long cod_usuario);
	
	 public List<Map<String,Object>>  findNotAnsweredQuestions(long id_usuario);
	
}

package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

public interface IPreguntaService {

	
	public Pregunta InsertPregunta(Pregunta pregunta);
	
	
	public List<PreguntaLite> findByIdUser(long id_user, String filter);
	
	
	public List<Map<String,Object>> findQuestionByConjunto(long id_conjunto);
	
	
	public List<Map<String,Object>> findQuestionByConjuntoWithResponse(long id_conjunto);
	
	
	public List<Map<String,Object>> findQuestionByConjuntoWithNotResponse(long id_conjunto);
	
	
	
	public Pregunta findById(long cod_pregunta);	
	
	public List<Map<String,Object>> findAnsweredQuestions(long cod_usuario, String filter);
	
	 public List<Map<String,Object>> findNotAnsweredQuestions(long id_usuario, String filter);
	
}

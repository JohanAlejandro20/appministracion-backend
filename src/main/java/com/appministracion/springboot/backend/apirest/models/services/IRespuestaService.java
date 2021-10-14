package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;

import com.appministracion.springboot.backend.apirest.models.entity.Respuesta;

public interface IRespuestaService {
	
	
	public Respuesta insertRespuesta(Respuesta respuesta);
	
	public Map<String,Object> findByIdQuestion(Long id_pregunta);

}

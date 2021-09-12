package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;


import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

public interface IPreguntaService {

	
	public Pregunta InsertPregunta(Pregunta pregunta);
	
	
	public List<PreguntaLite> findByIdUser(long id_user);
	
	
}

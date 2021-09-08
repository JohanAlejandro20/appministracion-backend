package com.appministracion.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appministracion.springboot.backend.apirest.models.dao.IPreguntaDao;
import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	
	@Autowired
	private IPreguntaDao preguntaDao;

	@Override
	public Pregunta InsertPregunta(Pregunta pregunta) {
		return preguntaDao.save(pregunta);
	} 

}

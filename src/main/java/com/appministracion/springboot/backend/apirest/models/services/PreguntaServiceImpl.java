package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appministracion.springboot.backend.apirest.models.dao.IPreguntaDao;
import com.appministracion.springboot.backend.apirest.models.dao.IPreguntaLiteDao;
import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	
	@Autowired
	private IPreguntaDao preguntaDao;
	
	@Autowired
	private IPreguntaLiteDao preguntaLiteDao;

	@Override
	public Pregunta InsertPregunta(Pregunta pregunta) {
		return preguntaDao.save(pregunta);
	}

	@Override
	public List<PreguntaLite> findByIdUser(long id_user) {
		
		return (List<PreguntaLite>) preguntaLiteDao.findByIdUser(id_user);
	} 

}

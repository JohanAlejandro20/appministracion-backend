package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appministracion.springboot.backend.apirest.models.dao.IPreguntaDao;
import com.appministracion.springboot.backend.apirest.models.dao.IRespuestaDao;
import com.appministracion.springboot.backend.apirest.models.entity.Respuesta;

@Service
public class RespuestaServiceImpl implements IRespuestaService{

	@Autowired
	private IRespuestaDao respuestaDao;
	
	@Override
	public Respuesta insertRespuesta(Respuesta respuesta) {
		
		return respuestaDao.save(respuesta);
	}

	@Override
	public Map<String,Object> findByIdQuestion(Long id_pregunta) {
		
		return respuestaDao.findByIdQuestion(id_pregunta);
	}

}

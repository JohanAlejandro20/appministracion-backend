package com.appministracion.springboot.backend.apirest.models.services;

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

}

package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public List<PreguntaLite> findByIdUser(long id_user, String filter) {
		
		return (List<PreguntaLite>) preguntaLiteDao.findByIdUser(id_user, filter);
	}

	@Override
	public List<Map<String,Object>> findQuestionByConjunto(long id_conjunto) {
		
		return  preguntaDao.findQuestionByConjunto(id_conjunto);
	}

	@Override
	public Pregunta findById(long cod_pregunta) {
		return preguntaDao.findBycod_pregunta(cod_pregunta);
	}

	@Override
	public List<Map<String,Object>> findAnsweredQuestions(long cod_usuario, String filter) {
		
		return preguntaDao.findAnsweredQuestions(cod_usuario, filter);
	}

	@Override
	public List<Map<String, Object>> findNotAnsweredQuestions(long id_usuario, String filter) {
		
		return preguntaDao.findNotAnsweredQuestions(id_usuario, filter);
	}

	@Override
	public List<Map<String, Object>> findQuestionByConjuntoWithResponse(long id_conjunto) {
		
		return preguntaDao.findQuestionByConjuntoWithResponse(id_conjunto);
	}

	@Override
	public List<Map<String, Object>> findQuestionByConjuntoWithNotResponse(long id_conjunto) {
		
		 return preguntaDao.findQuestionByConjuntoWithNotResponse(id_conjunto);
	}
	
	

}

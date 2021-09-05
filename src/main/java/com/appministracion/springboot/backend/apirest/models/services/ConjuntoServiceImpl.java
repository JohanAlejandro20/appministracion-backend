package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appministracion.springboot.backend.apirest.models.dao.IConjuntoDao;
import com.appministracion.springboot.backend.apirest.models.dao.IConjuntoLiteDao;
import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.ConjuntosLite;

@Service
public class ConjuntoServiceImpl implements IConjuntoService {

	@Autowired
	private IConjuntoLiteDao conjuntoLiteDao;
	
	@Autowired
	private IConjuntoDao conjuntoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ConjuntosLite> findAll() {
		return (List<ConjuntosLite>) conjuntoLiteDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Conjunto findById(long cod_conjunto) {
		return conjuntoDao.findBycod_conjunto(cod_conjunto);
		
	} 
	
	

}

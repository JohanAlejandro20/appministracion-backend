package com.appministracion.springboot.backend.apirest.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appministracion.springboot.backend.apirest.models.dao.IRolDao;
import com.appministracion.springboot.backend.apirest.models.entity.Rol;

@Service
public class RolServiceImpl implements IRolService {

	
	@Autowired
	public IRolDao roldao;
	
	@Override
	@Transactional(readOnly = true)
	public Rol findById(Long  cod_rol) {
		return roldao.findBycod_rol(cod_rol);
	}

}

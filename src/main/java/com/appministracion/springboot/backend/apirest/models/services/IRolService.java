package com.appministracion.springboot.backend.apirest.models.services;

import com.appministracion.springboot.backend.apirest.models.entity.Rol;

public interface IRolService {

	
	public Rol findById(Long cod_rol);
	
}

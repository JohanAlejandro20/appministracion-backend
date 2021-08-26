package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;


import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;

public interface IConjuntoService {
	
	
	public List<Conjunto> findAll();

}

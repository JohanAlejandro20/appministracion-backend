package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.ConjuntosLite;

public interface IConjuntoService {
	
    public List<ConjuntosLite> findAll();
    
    public Conjunto findById(long cod_conjunto);
}

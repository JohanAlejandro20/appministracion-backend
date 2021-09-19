package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.ConjuntosLite;

public interface IConjuntoService {
	
    public List<ConjuntosLite> findAll();
    
    public Conjunto findById(long cod_conjunto);
    
    
    public String findNameByIdUser(long cod_user);
    
}

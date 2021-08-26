package com.appministracion.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.services.IConjuntoService;

@RestController
@RequestMapping("/api")
public class ConjuntoRestController {
	
	@Autowired
	private IConjuntoService conjuntoService;
	
	@GetMapping("/conjuntos")
	public  List<Conjunto> index(){
		return conjuntoService.findAll();
	}
}



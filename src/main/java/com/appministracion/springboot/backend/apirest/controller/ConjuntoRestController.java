package com.appministracion.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.ConjuntosLite;
import com.appministracion.springboot.backend.apirest.models.services.IConjuntoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ConjuntoRestController {
	
	@Autowired
	private IConjuntoService conjuntoService;

//	@Secured("ROLE_RESIDENTE")
	@GetMapping("/conjuntos")
	public  List<ConjuntosLite> index(){
		return conjuntoService.findAll();
	}


	@Secured ({"ROLE_RESIDENTE", "ROLE_ADMINISTRADOR"})
	@GetMapping("/buscar-nombre-conjunto-usuario")
	public  ResponseEntity<?> buscar(@RequestParam (value="id") long id ){
		Map<String, Object> response = new HashMap<>();
		
		String conjunto =  conjuntoService.findNameByIdUser(id);
		
		if(conjunto == null) {
			response.put("Mensaje", "Error este usuario no tiene asociado ningun conjunto");
			response.put("error", true);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String[] respuesta = conjunto.split(",");
		String nombre_usuario = respuesta[0];
		String nombre_conjunto = respuesta[1];
		String cod_conjunto = respuesta[2];
		
		response.put("nombre_usuario", nombre_usuario);
		response.put("nombre_conjunto", nombre_conjunto);
		response.put("cod_conjunto", Long.parseLong(cod_conjunto));
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	}
	
}



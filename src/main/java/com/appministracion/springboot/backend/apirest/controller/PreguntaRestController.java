package com.appministracion.springboot.backend.apirest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;
import com.appministracion.springboot.backend.apirest.models.entity.Usuario;
import com.appministracion.springboot.backend.apirest.models.services.IPreguntaService;
import com.appministracion.springboot.backend.apirest.models.services.IUsuarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PreguntaRestController {
	
	private Logger logger = LoggerFactory.getLogger(IPreguntaService.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@Secured("ROLE_RESIDENTE")
	@PostMapping(path = "/realizar-pregunta", consumes = "application/json")
	public ResponseEntity<?> realizarPregunta(@RequestBody Map<String, Object>  request ) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Pregunta pregunta =new Pregunta();
			
			logger.warn("Llegue  a Realizar la pregunta" + request);

			//cargue de datos 
			int cod_usuario_request =  (int) request.get("cod_usuario");
			Long cod_usuario = Long.valueOf(cod_usuario_request);
			String nombre_pregunta = (String) request.get("nombre_pregunta");
			String descripcion = (String) request.get("descripcion");
			
			
			//Busqueda de usuario
			Usuario usuario = null;
			try {
				 usuario = usuarioService.findById(cod_usuario);
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar la consulta del usuario en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(usuario == null) {
				response.put("error", true);
				response.put("Mensaje", "El usuario con el id: ".concat(cod_usuario.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}
			
	
			//cargar datos de la pregunta
			pregunta = new Pregunta();
			pregunta.setNombre(nombre_pregunta);
			pregunta.setDescripcion(descripcion);
			pregunta.setUsuario(usuario);
			
			//Insertar pregunta
			preguntaService.InsertPregunta(pregunta);
			
			logger.warn("Este es el usuario " + usuario.getNombre()+ " " + usuario.getCorreo());
			
			return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
		}catch (Exception e) {
			response.put("error", true);
			response.put("Mensaje", "Error al al intentar registrar la pregunta"); 
			response.put("Detail", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		 
	}  

	@Secured("ROLE_RESIDENTE") 
	@GetMapping(path = "/buscar-preguntas-usuario")
	public ResponseEntity<?> buscarPreguntasByUsuario(@RequestParam (value="id") long id ){
		
		logger.warn("Llegue a buscar la pregunta que el usuario con codigo " + id + " ah realizado");
		
		//Busqueda de la pregunta 
		Map<String, Object> response = new HashMap<>();
		List<PreguntaLite> pregunta = null;
		try {
			 pregunta  = preguntaService.findByIdUser(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta del usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity <List<PreguntaLite>>(pregunta, HttpStatus.OK);
		
	}
	
	@Secured("ROLE_ADMINISTRADOR") 
	@GetMapping(path = "/buscar-preguntas-usuario-conjunto")
    @ResponseBody
	public ResponseEntity<?> buscarPreguntasPorUsuarioConjunto(@RequestParam (value="id") long id){
		
		logger.warn("Llegue a buscar la pregunta");
		
		Map<String, Object> response = new HashMap<>();
		
		List<Map<String,Object>> pregunta =  preguntaService.findQuestionByConjunto(id);
		
		
		if(pregunta.isEmpty()) {
			response.put("Mensaje", "No hay ninguna pregunta realizada para ese conjunto");
			response.put("error", true);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		}
		
		logger.warn("soy la pregunta"+ pregunta.toString());
		 
		
		return new ResponseEntity <List<Map<String,Object>>> (pregunta, HttpStatus.ACCEPTED);	
	}
	
	@Secured("ROLE_ADMINISTRADOR") 
	@GetMapping(path = "/buscar-preguntas-Byid")
	public ResponseEntity<?> buscarPregunta(@RequestParam(value = "id") long id_pregunta) {

		Map<String, Object> response = new HashMap<>();

		Pregunta pregunta = null;
		try {
			pregunta = preguntaService.findById(id_pregunta);

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta de la pregunta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		}

		if (pregunta == null) {
			response.put("error", true);
			response.put("Mensaje", "la pregunta  " + id_pregunta + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
	}
	
	
}

package com.appministracion.springboot.backend.apirest.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;
import com.appministracion.springboot.backend.apirest.models.entity.PreguntaLite;
import com.appministracion.springboot.backend.apirest.models.entity.Respuesta;
import com.appministracion.springboot.backend.apirest.models.entity.Usuario;
import com.appministracion.springboot.backend.apirest.models.services.IPreguntaService;
import com.appministracion.springboot.backend.apirest.models.services.IRespuestaService;
import com.appministracion.springboot.backend.apirest.models.services.IUsuarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RespuestaRestController {
	
	private Logger logger = LoggerFactory.getLogger(IRespuestaService.class);
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@Autowired
	private IRespuestaService respuestaService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	
	
	@Secured("ROLE_ADMINISTRADOR")
	@PostMapping(path = "/responder-pregunta", consumes = "application/json")
	public ResponseEntity<?>  responderPregunta(@RequestBody Map<String, Object>  request ){
	
		Map<String, Object> response = new HashMap<>();
		try {
			
		logger.warn("Llegue  a Responde la pregunta" + request);
		
		Respuesta respuesta = new Respuesta();
		
		//cargue de datos
		
		int cod_pregunta_request =  (int) request.get("cod_pregunta");
		Long cod_pregunta = Long.valueOf(cod_pregunta_request);
		String nombre_respuesta = (String) request.get("nombre_respuesta");
		String descripcion = (String) request.get("descripcion");
		int cod_usuario_request =  (int) request.get("cod_usuario");
		Long cod_usuario = Long.valueOf(cod_usuario_request);
		
		
		//Busqueda de pregunta
		Pregunta pregunta = null;
		try {
			pregunta = preguntaService.findById(cod_pregunta);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta de la pregunta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//busqueda de usuario
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
		
		if(pregunta == null) {
			response.put("error", true);
			response.put("Mensaje", "La pregunta con el id: ".concat(cod_pregunta.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		}
		
		logger.warn("Soy la pregunta" + pregunta.getDescripcion());
		
		//cargar datos de la respuesta
		respuesta.setNombre(nombre_respuesta);
		respuesta.setDescripcion(descripcion);
		respuesta.setPregunta(pregunta);
		respuesta.setUsuario(usuario);
		
		//Insertar pregunta
		respuestaService.insertRespuesta(respuesta);

		
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}catch (Exception e) {
			response.put("error", true);
			response.put("Mensaje", "Error al al intentar registrar la respuesta"); 
			response.put("Detail", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Secured ({"ROLE_RESIDENTE", "ROLE_ADMINISTRADOR"})
	@GetMapping(path = "/buscar-respuesta-by-id-pregunta")
	public ResponseEntity<?> buscarRespuestaByIdPregunta(@RequestParam (value="id") long id ){

		logger.warn("Llegue a buscar la respuesta  con codigo " + id +"que existe");
		
		//Busqueda de la respuesta 
		Map<String, Object> response = new HashMap<>();
		Map<String,Object> respuesta = null;
		try {
			respuesta = respuestaService.findByIdQuestion(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta del usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (respuesta.isEmpty()) {
			response.put("error", true);
			response.put("Mensaje", "No hay ninguna respuesta para esta pregunta :(");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);

		}
		
		
		return new ResponseEntity <Map<String,Object>>(respuesta, HttpStatus.OK); 
	} 

}

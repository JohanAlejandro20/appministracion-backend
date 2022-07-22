package com.appministracion.springboot.backend.apirest.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.Rol;
import com.appministracion.springboot.backend.apirest.models.entity.Usuario;
import com.appministracion.springboot.backend.apirest.models.services.IConjuntoService;
import com.appministracion.springboot.backend.apirest.models.services.IRolService;
import com.appministracion.springboot.backend.apirest.models.services.IUsuarioService;
import com.appministracion.springboot.backend.apirest.models.services.UsuarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {

	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IConjuntoService conjuntoService;
	
	@Autowired
	private IRolService rolService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@PostMapping(path = "/registrar", consumes = "application/json")
	public  ResponseEntity<?> RegistrarUsuario(@RequestBody Map<String, Object>  request ){
		
		Map<String, Object> response = new HashMap<>();
		try {
			Usuario usuario = new Usuario();
			logger.warn("Llegue  a Registrar el usuario." + request.get("activo"));
			logger.warn("Llegue  a Registrar el usuario." + request);

			
			//cargue de datos
			boolean activo = (boolean) request.get("activo");
			String correo = (String) request.get("correo");
			String nombre = (String) request.get("nombre");
			String telefono = (String) request.get("telefono");
			int cod_conjunto_request =  (int) request.get("cod_conjunto");
			Long cod_conjunto = Long.valueOf(cod_conjunto_request);
			int cod_rol_request =  (int) request.get("cod_rol");
			
			Long cod_rol = Long.valueOf(cod_rol_request);
			
			
			String contraseña = (String) request.get("contraseña");
			
			String contraseñaEncript = passwordEncoder.encode(contraseña);
			
			
			//busqueda de conjunto
			Conjunto conjunto = null;
			try {
				 conjunto = conjuntoService.findById(cod_conjunto);
				
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar la consulta del conjunto  en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			if(conjunto == null) {
				
				response.put("error", true);
				response.put("Mensaje", "El conjunto con el id: ".concat(cod_conjunto.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
				
			}
			
			
			Rol rol = asignarRol(usuario, cod_rol);
			if( rol == null) {
				response.put("error", true);
				response.put("Mensaje", "El rol con el id: ".concat(cod_rol.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}
			
			Usuario UsuarioRegistrado = null;
			try {
				UsuarioRegistrado = usuarioService.findByCorreo(correo);
				
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar la consulta del usuarname en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}
			
			if(UsuarioRegistrado != null) {
				response.put("error", true);
				response.put("Mensaje", "EL correo ".concat(correo.toString().concat(" Ya se encuentra registrado")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
				
			}
			
			//cargue de usuario
			usuario.setActivo(activo);
			usuario.setCorreo(correo);
			usuario.setNombre(nombre);
			usuario.setTelefono(telefono);
			usuario.setContraseña(contraseñaEncript);
			usuario.setConjunto(conjunto);				

			
			logger.warn("SIuuuuuuuuuuuuuuu" + activo);
			
			
			logger.warn("conjunto :v" + conjunto.getNombre());
			

			usuarioService.insertUsuario(usuario);
			
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			response.put("error", true);
			response.put("Mensaje", "Error al al intentar registrar el usuario");
			response.put("Detail", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public Rol asignarRol(Usuario usuario, Long cod_rol) {
		Rol rol = rolService.findById(cod_rol);
		usuario.getRoles().add(rol);
		return rol;
	}

	@Secured ({"ROLE_RESIDENTE", "ROLE_ADMINISTRADOR"})
	@GetMapping(path = "/buscar-usuario-id")
	public ResponseEntity<?> buscarUsuario(@RequestParam (value="id") long id_usuario) {
		
		
		Map<String, Object> response = new HashMap<>();
		
		Usuario Usuario = null;
		try {
			logger.warn("conjunto :v" +id_usuario);
			Usuario = usuarioService.findById(id_usuario);
				
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta del usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		}
		
		if(Usuario == null) {
			response.put("error", true);
			response.put("Mensaje", "EL usuario con id "+ id_usuario + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			
		}
		
		
		return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);
	}
	
	@PostMapping("/usuario/upload")
	public ResponseEntity<?> upload (@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		
		
		Map<String, Object> response = new HashMap<>();

		Usuario usuario = usuarioService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = archivo.getOriginalFilename();
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			usuario.setFoto(nombreArchivo);
			
			//usuarioService.
		}

		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
		
	}
	
	
	@Secured ({"ROLE_RESIDENTE", "ROLE_ADMINISTRADOR"})
	@PutMapping("/actualizar-usuario")
	public ResponseEntity<?> updateUser (@RequestBody Map<String, Object>  request ){
		
		
		Map<String, Object> response = new HashMap<>();
			logger.warn("Llegue  a actualizar el usuario." + request);

			
			//cargue de datos
			boolean cambiarContraseña = (boolean) request.get("cambiaContraseña");
			String correo = (String) request.get("correo");
			String nombre = (String) request.get("nombre");
			String telefono = (String) request.get("telefono");
			int cod_usuario_request =  (int) request.get("cod_user");
			Long cod_usuario = Long.valueOf(cod_usuario_request);
			
			int usuario = 0;
			
			try {
			if (cambiarContraseña) {
				String contraseña = (String) request.get("nuevaContraseña");
				String contraseñaEncript = passwordEncoder.encode(contraseña);
				
				usuario = usuarioService.UpdateUserPassword(nombre, telefono, correo, contraseñaEncript, cod_usuario_request);
				
			}else { 
				usuario = usuarioService.UpdateUser(nombre, telefono,correo, cod_usuario);
				logger.warn("Llegue  a actualizar el usuario." + usuario);
 
				
			}
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar la consulta del usuario en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}
			
			if(usuario == 0) {
				response.put("Mensaje", "no se ah encontrado ningun usuario en la base de datos");
				response.put("error", true);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}else {
				response.put("Mensaje", "Usario actualizado correctamente");
				response.put("error", false );
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
			}
		

	}
	
	
	
}

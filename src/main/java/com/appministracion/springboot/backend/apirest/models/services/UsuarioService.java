package com.appministracion.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appministracion.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.appministracion.springboot.backend.apirest.models.entity.Usuario;


@Service
public class UsuarioService implements UserDetailsService,IUsuarioService {

	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByCorreo(username);
		
		if(usuario == null) {
			logger.error("Error en el login no existe el usuario en el sistema "+ username + " En el sistema");
			throw new UsernameNotFoundException("Error en el login no existe el usuario en el sistema"+ username + "En el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Rol:"+ authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getCorreo(), usuario.getContraseña(), usuario.getActivo(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByCorreo(String correo) {
		
		return usuarioDao.findByCorreo(correo);
	}

	@Override
	public Usuario insertUsuario(Usuario usuario) {
		
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario findById(long id) {
		
		return usuarioDao.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public int UpdateUser(String name, String phone, String email,long id) {

		return usuarioDao.updateuser(name, phone, email, id);
	}

	@Override
	public int UpdateUserPassword(String name, String phone, String email, String password,long id) {
		
		return this.usuarioDao.updateuserPassword(name, phone, email, password, id);
		
	}

	
	
}

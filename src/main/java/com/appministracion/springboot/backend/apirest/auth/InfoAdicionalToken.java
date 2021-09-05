package com.appministracion.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.appministracion.springboot.backend.apirest.models.entity.Usuario;
import com.appministracion.springboot.backend.apirest.models.services.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	
	@Autowired
	private IUsuarioService usuarioService;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Map<String, Object> info = new HashMap<>();
		
		System.out.println("HOLAAAAAAAAAAAA" + authentication.toString());
		Usuario usuario = usuarioService.findByCorreo(authentication.getName());
		
		info.put("info_adicional",  "Hola que tal".concat(authentication.getName()) );
	
		
		info.put("telefono", usuario.getTelefono());
		
		info.put("id_usuario", usuario.getCod_usuario());
		info.put("nombre", usuario.getNombre());
		info.put("correo", usuario.getCorreo());
		
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}

package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Respuesta;

public interface IRespuestaDao extends CrudRepository<Respuesta, Long> {

}

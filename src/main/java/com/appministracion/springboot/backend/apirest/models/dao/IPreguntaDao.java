package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Pregunta;

public interface IPreguntaDao extends CrudRepository<Pregunta, Long> {

}

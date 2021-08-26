package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;

public interface IConjuntoDao extends CrudRepository<Conjunto, Long> {

}

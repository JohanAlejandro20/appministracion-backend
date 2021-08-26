package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Rol;



public interface IRolDao extends CrudRepository<Rol, Long> {

}

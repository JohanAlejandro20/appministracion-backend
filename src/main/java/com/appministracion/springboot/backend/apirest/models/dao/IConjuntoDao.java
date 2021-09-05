package com.appministracion.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;

public interface IConjuntoDao extends CrudRepository<Conjunto, Long> {

	
    @Query(value = "select * from conjuntos where cod_conjunto = :cod_conjunto", nativeQuery = true )   
    public Conjunto findBycod_conjunto(long cod_conjunto);

}

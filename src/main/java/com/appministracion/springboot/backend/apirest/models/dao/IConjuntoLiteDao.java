package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;
import com.appministracion.springboot.backend.apirest.models.entity.ConjuntosLite;

@Repository
public interface IConjuntoLiteDao extends CrudRepository<ConjuntosLite, Long> {

	
//	@Query("select com.appministracion.springboot.backend.apirest.models.entity.Conjunto(c.nombre) from Conjunto")
    @Query(value = "select * from conjuntos", nativeQuery = true )    
    public List<ConjuntosLite> findAll();
    
    
    @Query(value = "select * from conjuntos where cod_conjunto = cod_conjunto", nativeQuery = true )   
    public Conjunto findByCod_conjunto(Long cod_conjunto);
}
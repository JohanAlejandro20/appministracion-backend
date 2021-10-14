package com.appministracion.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import com.appministracion.springboot.backend.apirest.models.entity.Conjunto;

public interface IConjuntoDao extends CrudRepository<Conjunto, Long> {

	
    @Query(value = "select * from conjuntos where cod_conjunto = :cod_conjunto", nativeQuery = true )   
    public Conjunto findBycod_conjunto(long cod_conjunto);
    
    @Query(value = "select u.nombre as nombreUsuario,c.nombre as nombreConjunto, c.cod_conjunto from usuarios u inner join conjuntos c on u.cod_conjunto = c.cod_conjunto where u.cod_usuario = :cod_usuario", nativeQuery = true )   
    public String findNameByIdUser(long cod_usuario);

}

package com.appministracion.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="rol")
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_rol;
	private String nombre;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy  = "rol", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"rol","hibernateLazyInitializer","handler"})
	private List<Usuario> usuarios;
	
	
	
	
	
	 
	public Rol( ) {
		this.usuarios = new ArrayList<>();
	}

	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}


	public long getCod_rol() {
		return cod_rol;
	}



	public void setCod_rol(Long cod_rol) {
		this.cod_rol = cod_rol;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}




	private static final long serialVersionUID = 1L;
}

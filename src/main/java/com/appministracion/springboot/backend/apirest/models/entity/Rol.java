package com.appministracion.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;




@Entity
@Table(name="roles")
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_rol;
	
	@Column(unique = true, length = 40)
	private String nombre;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;

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

	
	private static final long serialVersionUID = 1L;
}

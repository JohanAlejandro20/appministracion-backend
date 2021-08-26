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
@Table(name = "conjunto")
public class Conjunto implements Serializable {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_conjunto;
	private String nombre;
	private String nit;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conjunto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"conjunto","hibernateLazyInitializer","handler"})
	private List<Usuario> usuarios;
	
	
	public Conjunto() {
		this.usuarios = new ArrayList<>();
	}
	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public long getCod_conjunto() {
		return cod_conjunto;
	}


	public void setCod_conjunto(Long cod_conjunto) {
		this.cod_conjunto = cod_conjunto;
	}	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	private static final long serialVersionUID = 1L;
	
	

}

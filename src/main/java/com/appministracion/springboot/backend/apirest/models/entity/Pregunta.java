package com.appministracion.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_pregunta;
	
	
	private String nombre;
	
	@Column(columnDefinition = "text")
	private String descripcion;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;
	
	@JsonIgnoreProperties({"preguntas","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario;

	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	
	public Long getCod_pregunta() {
		return cod_pregunta;
	}

	public void setCod_pregunta(Long cod_pregunta) {
		this.cod_pregunta = cod_pregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	

}

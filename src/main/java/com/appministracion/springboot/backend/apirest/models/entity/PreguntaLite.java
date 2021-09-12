package com.appministracion.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "preguntas")
public class PreguntaLite implements Serializable {
	
	



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_pregunta;
	
	
	private String nombre;
	
	@Column(columnDefinition = "text")
	private String descripcion;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}

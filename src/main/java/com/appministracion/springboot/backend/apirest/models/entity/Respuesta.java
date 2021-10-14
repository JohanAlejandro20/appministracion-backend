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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable{
	
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long cod_respuesta;
	
	private String nombre;
	
	@Column(columnDefinition = "text")
	private String descripcion;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;
	
	@JsonIgnoreProperties({"respuestas","hibernateLazyInitializer","handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pregunta")
	private Pregunta pregunta;
	
	@JsonIgnoreProperties({"respuestas","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getCod_respuesta() {
		return cod_respuesta;
	}

	public void setCod_respuesta(Long cod_respuesta) {
		this.cod_respuesta = cod_respuesta;
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

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
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

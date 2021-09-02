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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_usuario;
	@NotNull
	private String nombre;
	@Column(unique= true, length  = 40)
	private String correo;
	@Column(length = 60)
	private String contraseña;
	private long telefono;
	private Boolean activo;
	
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date  createAt;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JsonIgnoreProperties({"usuarios","hibernateLazyInitializer","handler"})
	@JoinColumn(name = "cod_rol")
	@JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="cod_usuario"),inverseJoinColumns = @JoinColumn(name="cod_rol"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"cod_usuario","cod_rol"})})
	private Set<Rol> roles = new HashSet<>();
	 
	@JsonIgnoreProperties({"usuarios","hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_conjunto")
	private Conjunto conjunto;
	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	
	public Long getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}


	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}


	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Conjunto getConjunto() {
		return conjunto;
	}
	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	

	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}

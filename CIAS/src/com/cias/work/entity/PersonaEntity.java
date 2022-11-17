package com.cias.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[Persona]")
public class PersonaEntity {

	@Id
	@Column(name="ident")
	private String ident;
		
	@Column(name="nombre")
	private String nombre;
		
	@Column(name="primer_apellido")
	private String primer_apellido;
	
	@Column(name="segundo_apellido")
	private String segundo_apellido;
		
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="estatus")
	private String estatus;
	
	@Column(name="fecha_ins")
	private String fecha_ins;
		
	@Column(name="fecha_upd")
	private String fecha_upd;

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFecha_ins() {
		return fecha_ins;
	}

	public void setFecha_ins(String fecha_ins) {
		this.fecha_ins = fecha_ins;
	}

	public String getFecha_upd() {
		return fecha_upd;
	}

	public void setFecha_upd(String fecha_upd) {
		this.fecha_upd = fecha_upd;
	}

}

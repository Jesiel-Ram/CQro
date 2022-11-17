package com.cias.work.dto;

import java.util.List;


public class PersonaDTO {

	private String ident;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String telefono;
	private String estatus;
	private String fecha_ins;
	private String fecha_upd;
	private String actualizar;
	
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
	
	private List<PersonaDTO> data;
	
	public List<PersonaDTO> getData() {
		return data;
	}

	public void setData(List<PersonaDTO> data) {
		this.data = data;
	}

	public String getActualizar() {
		return actualizar;
	}

	public void setActualizar(String actualizar) {
		this.actualizar = actualizar;
	}

	@Override
	public String toString() {
		return "PersonaDTO [ident=" + ident + ", nombre=" + nombre + ", primer_apellido=" + primer_apellido
				+ ", segundo_apellido=" + segundo_apellido + ", telefono=" + telefono + ", estatus=" + estatus
				+ ", fecha_ins=" + fecha_ins + ", fecha_upd=" + fecha_upd + ", actualizar=" + actualizar + ", data="
				+ data + "]";
	}
	
	
}

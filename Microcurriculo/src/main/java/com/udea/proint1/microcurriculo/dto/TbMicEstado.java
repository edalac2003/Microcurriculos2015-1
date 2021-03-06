package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.Set;

/**
 * TbMicEstados generated by hbm2java
 */
public class TbMicEstado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbIdestado;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;

	
	public TbMicEstado() {
		super();
	}

	public TbMicEstado(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	@SuppressWarnings("rawtypes")
	public TbMicEstado(String vrDescripcion,
			String vrModusuario, Date dtModfecha, Set tbMicMicroxestados) {
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
//		this.tbMicMicroxestados = tbMicMicroxestados;
	}

	public int getNbIdestado() {
		return this.nbIdestado;
	}

	public void setNbIdestado(int nbIdestado) {
		this.nbIdestado = nbIdestado;
	}

	public String getVrDescripcion() {
		return this.vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	public String getVrModusuario() {
		return this.vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public Date getDtModfecha() {
		return this.dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	

}

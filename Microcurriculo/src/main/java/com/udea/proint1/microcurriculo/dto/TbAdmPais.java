package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbAdmPaises generated by hbm2java
 */
public class TbAdmPais implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbIdpais;
	private String vrNombre;
	private String vrModusuario;
	private Date dtModfecha;

	public TbAdmPais() {
	}

	public TbAdmPais(int nbIdpais) {
		this.nbIdpais = nbIdpais;
	}

	public TbAdmPais(int nbIdpais, String vrNombre,
			String vrModusuario, Date dtModfecha) {
		this.nbIdpais = nbIdpais;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbIdpais() {
		return this.nbIdpais;
	}

	public void setNbIdpais(int nbIdpais) {
		this.nbIdpais = nbIdpais;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
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

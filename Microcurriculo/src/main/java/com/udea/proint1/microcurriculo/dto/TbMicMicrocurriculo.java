package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;


/**
 * TbMicMicrocurriculos generated by hbm2java
 */
public class TbMicMicrocurriculo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vrIdmicrocurriculo;
	private TbAdmMateria tbAdmMateria;
	private TbAdmSemestre tbAdmSemestre;
	private String vrProposito;
	private String vrJustificacion;
	private String vrResumen;
	private TbAdmPersona tbAdmPersona;
	private TbMicEstado tbMicEstado;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicMicrocurriculo() {
		
	}

	public TbMicMicrocurriculo(String vrIdmicrocurriculo,
		TbAdmMateria tbAdmMateria, TbAdmSemestre tbAdmSemestre,
		String vrProposito, String vrJustificacion, String vrResumen,
		TbAdmPersona tbAdmPersona, TbMicEstado tbMicEstado,
		String vrModusuario, Date dtModfecha) {
		super();
		this.vrIdmicrocurriculo = vrIdmicrocurriculo;
		this.tbAdmMateria = tbAdmMateria;
		this.tbAdmSemestre = tbAdmSemestre;
		this.vrProposito = vrProposito;
		this.vrJustificacion = vrJustificacion;
		this.vrResumen = vrResumen;
		this.tbAdmPersona = tbAdmPersona;
		this.tbMicEstado = tbMicEstado;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public String getVrIdmicrocurriculo() {
		return this.vrIdmicrocurriculo;
	}
	
	public void setVrIdmicrocurriculo(String vrIdmicrocurriculo) {
		this.vrIdmicrocurriculo = vrIdmicrocurriculo;
	}

	public TbAdmMateria getTbAdmMateria() {
		return this.tbAdmMateria;
	}

	public void setTbAdmMateria(TbAdmMateria tbAdmMateria) {
		this.tbAdmMateria = tbAdmMateria;
	}	

	public TbAdmSemestre getTbAdmSemestre() {
		return tbAdmSemestre;
	}

	public void setTbAdmSemestre(TbAdmSemestre tbAdmSemestre) {
		this.tbAdmSemestre = tbAdmSemestre;
	}

	public String getVrResumen() {
		return this.vrResumen;
	}

	public void setVrResumen(String vrResumen) {
		this.vrResumen = vrResumen;
	}

	public TbAdmPersona getTbAdmPersona() {
		return tbAdmPersona;
	}

	public void setTbAdmPersona(TbAdmPersona tbAdmPersona) {
		this.tbAdmPersona = tbAdmPersona;
	}

	
	public TbMicEstado getTbMicEstado() {
		return tbMicEstado;
	}

	public void setTbMicEstado(TbMicEstado tbMicEstado) {
		this.tbMicEstado = tbMicEstado;
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


	public String getVrProposito() {
		return vrProposito;
	}

	public void setVrProposito(String vrProposito) {
		this.vrProposito = vrProposito;
	}

	public String getVrJustificacion() {
		return vrJustificacion;
	}

	public void setVrJustificacion(String vrJustificacion) {
		this.vrJustificacion = vrJustificacion;
	}

}

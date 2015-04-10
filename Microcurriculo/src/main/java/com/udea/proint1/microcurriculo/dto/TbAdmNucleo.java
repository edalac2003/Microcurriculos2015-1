package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmNucleo generated by hbm2java
 */
public class TbAdmNucleo implements java.io.Serializable {

	private String vrIdnucleo;
	private TbAdmDependencia tbAdmDependencia;
	private String vrNombre;
	private String vrModusuario;
	private Date vrModfecha;
	private Set tbAdmDocentesxnucleos = new HashSet(0);
	private Set tbAdmMateriases = new HashSet(0);

	public TbAdmNucleo() {
	}
	
	
	
	public TbAdmNucleo(String vrIdnucleo, TbAdmDependencia tbAdmDependencia,
			String vrNombre, String vrModusuario, Date vrModfecha) {
		super();
		this.vrIdnucleo = vrIdnucleo;
		this.tbAdmDependencia = tbAdmDependencia;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
	}



	public TbAdmNucleo(String vrIdnucleo, TbAdmDependencia tbAdmDependencia) {
		this.vrIdnucleo = vrIdnucleo;
		this.tbAdmDependencia = tbAdmDependencia;
	}

	public TbAdmNucleo(String vrIdnucleo, TbAdmDependencia tbAdmDependencia,
			String vrNombre, String vrModusuario, Date vrModfecha,
			Set tbAdmDocentesxnucleos, Set tbAdmMateriases) {
		this.vrIdnucleo = vrIdnucleo;
		this.tbAdmDependencia = tbAdmDependencia;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
		this.tbAdmDocentesxnucleos = tbAdmDocentesxnucleos;
		this.tbAdmMateriases = tbAdmMateriases;
	}

	public String getVrIdnucleo() {
		return this.vrIdnucleo;
	}

	public void setVrIdnucleo(String vrIdnucleo) {
		this.vrIdnucleo = vrIdnucleo;
	}

	public TbAdmDependencia getTbAdmDependencia() {
		return this.tbAdmDependencia;
	}

	public void setTbAdmDependencia(TbAdmDependencia tbAdmDependencia) {
		this.tbAdmDependencia = tbAdmDependencia;
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

	public Date getVrModfecha() {
		return this.vrModfecha;
	}

	public void setVrModfecha(Date vrModfecha) {
		this.vrModfecha = vrModfecha;
	}

	public Set getTbAdmDocentesxnucleos() {
		return this.tbAdmDocentesxnucleos;
	}

	public void setTbAdmDocentesxnucleos(Set tbAdmDocentesxnucleos) {
		this.tbAdmDocentesxnucleos = tbAdmDocentesxnucleos;
	}

	public Set getTbAdmMateriases() {
		return this.tbAdmMateriases;
	}

	public void setTbAdmMateriases(Set tbAdmMateriases) {
		this.tbAdmMateriases = tbAdmMateriases;
	}

}

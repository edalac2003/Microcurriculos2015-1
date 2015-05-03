package com.udea.proint1.microcurriculo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TbAdmArea {

	
	private String vrIdArea;
	private String vrNombre;
	private TbAdmNucleo tbAdmNucleo;
	private String vrAlias;
	private TbAdmPersona vrResponsable;
	private String vrModusuario;
	private Date vrModfecha;	
	private Set tbAdmMateriases = new HashSet(0);
	
	public TbAdmArea() {
	}

	public TbAdmArea(String vrIdArea, String vrNombre, TbAdmNucleo tbAdmNucleo,
			String vrAlias, TbAdmPersona vrResponsable, String vrModusuario,
			Date vrModfecha) {
		super();
		this.vrIdArea = vrIdArea;
		this.vrNombre = vrNombre;
		this.tbAdmNucleo = tbAdmNucleo;
		this.vrAlias = vrAlias;
		this.vrResponsable = vrResponsable;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
	}

	public TbAdmArea(String vrIdArea, String vrNombre, TbAdmNucleo tbAdmNucleo,
			String vrModusuario, Date vrModfecha) {
		super();
		this.vrIdArea = vrIdArea;
		this.vrNombre = vrNombre;
		this.tbAdmNucleo = tbAdmNucleo;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
	}

	public String getVrIdArea() {
		return vrIdArea;
	}

	public void setVrIdArea(String vrIdArea) {
		this.vrIdArea = vrIdArea;
	}

	public String getVrNombre() {
		return vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public TbAdmNucleo getTbAdmNucleo() {
		return tbAdmNucleo;
	}

	public void setTbAdmNucleo(TbAdmNucleo tbAdmNucleo) {
		this.tbAdmNucleo = tbAdmNucleo;
	}

	public String getVrAlias() {
		return vrAlias;
	}

	public void setVrAlias(String vrAlias) {
		this.vrAlias = vrAlias;
	}

	public TbAdmPersona getVrResponsable() {
		return vrResponsable;
	}

	public void setVrResponsable(TbAdmPersona vrResponsable) {
		this.vrResponsable = vrResponsable;
	}

	public String getVrModusuario() {
		return vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public Date getVrModfecha() {
		return vrModfecha;
	}

	public void setVrModfecha(Date vrModfecha) {
		this.vrModfecha = vrModfecha;
	}

	public Set getTbAdmMateriases() {
		return tbAdmMateriases;
	}

	public void setTbAdmMateriases(Set tbAdmMateriases) {
		this.tbAdmMateriases = tbAdmMateriases;
	}
	
}

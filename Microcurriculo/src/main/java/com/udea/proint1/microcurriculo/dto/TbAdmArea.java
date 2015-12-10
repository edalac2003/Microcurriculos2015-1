package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmArea {

	
	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	private String vrIdArea;
	private String vrNombre;
	private TbAdmNucleo tbAdmNucleo;
	private String vrAlias;
	private TbAdmPersona vrResponsable;
	private String vrModusuario;
	private Date dtModfecha;
	
	public TbAdmArea() {
		super();
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
		this.dtModfecha = vrModfecha;
	}

	public TbAdmArea(String vrIdArea, String vrNombre, TbAdmNucleo tbAdmNucleo,
			String vrModusuario, Date vrModfecha) {
		super();
		this.vrIdArea = vrIdArea;
		this.vrNombre = vrNombre;
		this.tbAdmNucleo = tbAdmNucleo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = vrModfecha;
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

}

package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmRol {

	private int nbId;
	private String vrNivel;
	private String vrDescripcion;
	
	public TbAdmRol(int nbId, String vrNivel, String vrDescripcion) {
		super();
		this.nbId = nbId;
		this.vrNivel = vrNivel;
		this.vrDescripcion = vrDescripcion;
	}

	public int getNbId() {
		return nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public String getVrNivel() {
		return vrNivel;
	}

	public void setVrNivel(String vrNivel) {
		this.vrNivel = vrNivel;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}
	
}

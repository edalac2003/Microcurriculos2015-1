package com.udea.proint1.microcurriculo.dto;

public class TbAdmTabla {

	private int nbIdtabla;
	private String vrNombretabla;

	public TbAdmTabla(int nbIdtabla, String vrNombretabla) {
		this.nbIdtabla = nbIdtabla;
		this.vrNombretabla = vrNombretabla;
	}

	public int getNbIdtabla() {
		return nbIdtabla;
	}

	public void setNbIdtabla(int nbIdtabla) {
		this.nbIdtabla = nbIdtabla;
	}

	public String getVrNombretabla() {
		return vrNombretabla;
	}

	public void setVrNombretabla(String vrNombretabla) {
		this.vrNombretabla = vrNombretabla;
	}
	 
}

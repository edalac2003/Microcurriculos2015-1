package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmAuditoria {

	private int nbIdauditoria;
	private TbAdmUsuario tbAdmUsuario;
	private TbAdmTabla tbAdmTabla;
	private String vrObservaciones;
	private Date dtFecha;

	public TbAdmAuditoria() {
	}

	public TbAdmAuditoria(int nbIdauditoria, TbAdmUsuario tbAdmUsuario,
			TbAdmTabla tbAdmTabla) {
		this.nbIdauditoria = nbIdauditoria;
		this.tbAdmUsuario = tbAdmUsuario;
		this.tbAdmTabla = tbAdmTabla;
	}

	public TbAdmAuditoria(int nbIdauditoria, TbAdmUsuario tbAdmUsuario,
			TbAdmTabla tbAdmTabla, String vrObservaciones, Date dtFecha) {
		this.nbIdauditoria = nbIdauditoria;
		this.tbAdmUsuario = tbAdmUsuario;
		this.tbAdmTabla = tbAdmTabla;
		this.vrObservaciones = vrObservaciones;
		this.dtFecha = dtFecha;
	}

	public int getNbIdauditoria() {
		return nbIdauditoria;
	}

	public void setNbIdauditoria(int nbIdauditoria) {
		this.nbIdauditoria = nbIdauditoria;
	}

	public TbAdmUsuario getTbAdmUsuario() {
		return tbAdmUsuario;
	}

	public void setTbAdmUsuario(TbAdmUsuario tbAdmUsuario) {
		this.tbAdmUsuario = tbAdmUsuario;
	}

	public TbAdmTabla getTbAdmTabla() {
		return tbAdmTabla;
	}

	public void setTbAdmTabla(TbAdmTabla tbAdmTabla) {
		this.tbAdmTabla = tbAdmTabla;
	}

	public String getVrObservaciones() {
		return vrObservaciones;
	}

	public void setVrObservaciones(String vrObservaciones) {
		this.vrObservaciones = vrObservaciones;
	}

	public Date getDtFecha() {
		return dtFecha;
	}

	public void setDtFecha(Date dtFecha) {
		this.dtFecha = dtFecha;
	}
	
}

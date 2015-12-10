package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicSubtemaxtema {

	private int nbid;
	private TbMicTema tbMicTema;
	private TbMicSubtema tbMicSubtema;
	private String vrModUsuario;
	private Date dtModFecha;
	
	
	
	public TbMicSubtemaxtema() {
		super();
	}

	public TbMicSubtemaxtema(TbMicTema tbMicTema, TbMicSubtema tbMicSubtema, String vrModUsuario, 
			Date dtModFecha) {
		super();
		this.tbMicTema = tbMicTema;
		this.tbMicSubtema = tbMicSubtema;
		this.vrModUsuario = vrModUsuario;
		this.dtModFecha = dtModFecha;
	}


	public TbMicSubtemaxtema(TbMicTema tbMicTema,TbMicSubtema tbMicSubtema) {
		super();
		this.tbMicTema = tbMicTema;
		this.tbMicSubtema = tbMicSubtema;
	}


	public int getNbid() {
		return nbid;
	}


	public void setNbid(int nbid) {
		this.nbid = nbid;
	}

	
	public TbMicTema getTbMicTema() {
		return tbMicTema;
	}


	public void setTbMicTema(TbMicTema tbMicTema) {
		this.tbMicTema = tbMicTema;
	}


	public TbMicSubtema getTbMicSubtema() {
		return tbMicSubtema;
	}


	public void setTbMicSubtema(TbMicSubtema tbMicSubtema) {
		this.tbMicSubtema = tbMicSubtema;
	}


	public String getVrModUsuario() {
		return vrModUsuario;
	}


	public void setVrModUsuario(String vrModUsuario) {
		this.vrModUsuario = vrModUsuario;
	}


	public Date getDtModFecha() {
		return dtModFecha;
	}


	public void setDtModFecha(Date dtModFecha) {
		this.dtModFecha = dtModFecha;
	}
	
	
	
	
}

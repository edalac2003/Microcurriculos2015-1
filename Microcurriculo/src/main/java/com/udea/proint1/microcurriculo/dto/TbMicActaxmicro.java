package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicActaxmicro {

	private int nbIdactas;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private TbAdmUsuario tbAdmUsuario;
	private Date dtFechaaprobacion;

	
	public TbMicActaxmicro() {
		super();
	}

	public TbMicActaxmicro(int nbIdactas, TbMicMicrocurriculo tbMicMicrocurriculo, TbAdmUsuario tbAdmUsuario) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.tbAdmUsuario = tbAdmUsuario;
	}

	public TbMicActaxmicro(int nbIdactas, TbMicMicrocurriculo tbMicMicrocurriculo, 
			TbAdmUsuario tbAdmUsuario, Date dtFechaaprobacion) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.tbAdmUsuario = tbAdmUsuario;
		this.dtFechaaprobacion = dtFechaaprobacion;
	}

	public int getNbIdactas() {
		return nbIdactas;
	}

	public void setNbIdactas(int nbIdactas) {
		this.nbIdactas = nbIdactas;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public Date getDtFechaaprobacion() {
		return dtFechaaprobacion;
	}

	public void setDtFechaaprobacion(Date dtFechaaprobacion) {
		this.dtFechaaprobacion = dtFechaaprobacion;
	}

	public TbAdmUsuario getTbAdmUsuario() {
		return tbAdmUsuario;
	}

	public void setTbAdmUsuario(TbAdmUsuario tbAdmUsuario) {
		this.tbAdmUsuario = tbAdmUsuario;
	}
	
}

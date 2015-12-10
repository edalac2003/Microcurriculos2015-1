package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmHistorico {

	private int nbId;
	private Date dtFecha;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private String vrCampo;
	private String vrUsuario;
	private String vrModusuario;
	private Date dtModfecha;
	
	public TbAdmHistorico(Date dtFecha,	TbMicMicrocurriculo tbMicMicrocurriculo, String vrCampo,
			String vrUsuario, String vrModusuario, Date dtModfecha) {
		super();
		this.dtFecha = dtFecha;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.vrCampo = vrCampo;
		this.vrUsuario = vrUsuario;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}
	public int getNbId() {
		return nbId;
	}
	public void setNbId(int nbId) {
		this.nbId = nbId;
	}
	public Date getDtFecha() {
		return dtFecha;
	}
	public void setDtFecha(Date dtFecha) {
		this.dtFecha = dtFecha;
	}
	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return tbMicMicrocurriculo;
	}
	public void setTbMicMicrocurriculo(TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}
	public String getVrCampo() {
		return vrCampo;
	}
	public void setVrCampo(String vrCampo) {
		this.vrCampo = vrCampo;
	}
	public String getVrUsuario() {
		return vrUsuario;
	}
	public void setVrUsuario(String vrUsuario) {
		this.vrUsuario = vrUsuario;
	}
	public String getVrModusuario() {
		return vrModusuario;
	}
	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}
	public Date getDtModfecha() {
		return dtModfecha;
	}
	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}
	
}

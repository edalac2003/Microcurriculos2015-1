package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicActividadxmicro {

	private int nbIdactividad;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private String vrModusuario;
	private String vrDescripcion;
	private Date dtModfecha;

	
	public TbMicActividadxmicro() {
		super();
	}

	public TbMicActividadxmicro(int nbIdactividad, TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.nbIdactividad = nbIdactividad;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public TbMicActividadxmicro(int nbIdactividad, TbMicMicrocurriculo tbMicMicrocurriculo,
			String vrDescripcion, String vrModusuario, Date dtModfecha) {
		this.nbIdactividad = nbIdactividad;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.vrDescripcion = vrDescripcion;
	}

	public int getNbIdactividad() {
		return nbIdactividad;
	}

	public void setNbIdactividad(int nbIdactividad) {
		this.nbIdactividad = nbIdactividad;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public String getVrModusuario() {
		return vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}
	
}

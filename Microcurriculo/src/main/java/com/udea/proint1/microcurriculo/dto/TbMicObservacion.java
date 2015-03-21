package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicObservacion {

	private int nbIdobservacion;
	private String vrDescripcion;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private Date dtFechaobservacion;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicObservacion() {
		super();
	}



	public TbMicObservacion(int nbIdobservacion, String vrDescripcion,
			TbMicMicrocurriculo tbMicMicrocurriculo, Date dtFechaobservacion) {
		super();
		this.nbIdobservacion = nbIdobservacion;
		this.vrDescripcion = vrDescripcion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.dtFechaobservacion = dtFechaobservacion;
	}



	public TbMicObservacion(int nbIdobservacion, String vrDescripcion,
			TbMicMicrocurriculo tbMicMicrocurriculo, Date dtFechaobservacion,
			String vrModusuario, Date dtModfecha) {
		super();
		this.nbIdobservacion = nbIdobservacion;
		this.vrDescripcion = vrDescripcion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.dtFechaobservacion = dtFechaobservacion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}



	public int getNbIdobservacion() {
		return nbIdobservacion;
	}

	public void setNbIdobservacion(int nbIdobservacion) {
		this.nbIdobservacion = nbIdobservacion;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public Date getDtFechaobservacion() {
		return dtFechaobservacion;
	}

	public void setDtFechaobservacion(Date dtFechaobservacion) {
		this.dtFechaobservacion = dtFechaobservacion;
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

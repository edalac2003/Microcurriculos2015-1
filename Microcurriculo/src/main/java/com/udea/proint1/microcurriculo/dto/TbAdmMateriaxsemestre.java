package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmMateriaxsemestre {

	private int nbId;
	private TbAdmMateria tbAdmMateria;
	private TbAdmSemestre tbAdmSemestre;
	private Date vrModusuario;
	private String dtModUsuario;
	private Date dtModfecha;

	public TbAdmMateriaxsemestre(TbAdmMateria tbAdmMateria,	TbAdmSemestre tbAdmSemestre, Date vrModusuario,
			String dtModUsuario, Date dtModfecha) {
		super();
		this.tbAdmMateria = tbAdmMateria;
		this.tbAdmSemestre = tbAdmSemestre;
		this.vrModusuario = vrModusuario;
		this.dtModUsuario = dtModUsuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbId() {
		return nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbAdmMateria getTbAdmMateria() {
		return tbAdmMateria;
	}

	public void setTbAdmMateria(TbAdmMateria tbAdmMateria) {
		this.tbAdmMateria = tbAdmMateria;
	}

	public TbAdmSemestre getTbAdmSemestre() {
		return tbAdmSemestre;
	}

	public void setTbAdmSemestre(TbAdmSemestre tbAdmSemestre) {
		this.tbAdmSemestre = tbAdmSemestre;
	}

	public Date getVrModusuario() {
		return vrModusuario;
	}

	public void setVrModusuario(Date vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public String getDtModUsuario() {
		return dtModUsuario;
	}

	public void setDtModUsuario(String dtModUsuario) {
		this.dtModUsuario = dtModUsuario;
	}

	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}
	
}

package com.udea.proint1.microcurriculo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TbAdmRol implements java.io.Serializable{

	
	private Integer nbId;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmRolxUsuarios = new HashSet(0); 
	
	public TbAdmRol() {
		// TODO Auto-generated constructor stub
	}

	public TbAdmRol(Integer nbId, String vrDescripcion) {
		super();
		this.nbId = nbId;
		this.vrDescripcion = vrDescripcion;
	}

	public TbAdmRol(Integer nbId, String vrDescripcion, String vrModusuario,
			Date dtModfecha) {
		super();
		this.nbId = nbId;
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public Integer getNbId() {
		return nbId;
	}

	public void setNbId(Integer nbId) {
		this.nbId = nbId;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
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
	

	public Set getTbAdmRolxUsuarios() {
		return tbAdmRolxUsuarios;
	}

	public void setTbAdmRolxUsuarios(Set tbAdmRolxUsuarios) {
		this.tbAdmRolxUsuarios = tbAdmRolxUsuarios;
	}

}

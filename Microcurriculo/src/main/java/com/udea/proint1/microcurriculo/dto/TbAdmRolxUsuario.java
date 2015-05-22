package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmRolxUsuario {
	
	private Integer nbId;
	private TbAdmRol tbAdmRol;
	private TbAdmUsuario tbAdmUsuario;
	private String vrNivel;
	private String vrModusuario;
	private Date dtModfecha;
	
	
	public TbAdmRolxUsuario() {
		
	}
	
	public TbAdmRolxUsuario(Integer nbId, TbAdmRol tbAdmRol, TbAdmUsuario tbAdmUsuario, String vrNivel) {
		super();
		this.nbId = nbId;
		this.tbAdmRol = tbAdmRol;
		this.tbAdmUsuario = tbAdmUsuario;
		this.vrNivel = vrNivel;
	}

	public TbAdmRolxUsuario(Integer nbId, TbAdmRol tbAdmRol, TbAdmUsuario tbAdmUsuario, String vrNivel, 
			String vrModusuario, Date dtModfecha) {
		super();
		this.nbId = nbId;
		this.tbAdmRol = tbAdmRol;
		this.tbAdmUsuario = tbAdmUsuario;
		this.vrNivel = vrNivel;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}




	public Integer getNbId() {
		return nbId;
	}

	public void setNbId(Integer nbId) {
		this.nbId = nbId;
	}

	public TbAdmRol getTbAdmRol() {
		return tbAdmRol;
	}

	public void setTbAdmRol(TbAdmRol tbAdmRol) {
		this.tbAdmRol = tbAdmRol;
	}

	public String getVrNivel() {
		return vrNivel;
	}

	public void setVrNivel(String vrNivel) {
		this.vrNivel = vrNivel;
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

	public TbAdmUsuario getTbAdmUsuario() {
		return tbAdmUsuario;
	}

	public void setTbAdmUsuario(TbAdmUsuario tbAdmUsuario) {
		this.tbAdmUsuario = tbAdmUsuario;
	}

	
}

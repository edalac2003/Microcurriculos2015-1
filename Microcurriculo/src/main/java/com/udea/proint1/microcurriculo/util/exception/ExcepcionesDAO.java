package com.udea.proint1.microcurriculo.util.exception;

import org.apache.log4j.Logger;

public class ExcepcionesDAO extends Exception {
	
	private static Logger logger=Logger.getLogger(ExcepcionesDAO.class);
	
	private String msjUsuario;
	private String msjTecnico;
	private Exception origen;
	
	public String getMsjUsuario() {
		return msjUsuario;
	}
	public void setMsjUsuario(String msjUsuario) {
		this.msjUsuario = msjUsuario;
	}
	public String getMsjTecnico() {
		return msjTecnico;
	}
	public void setMsjTecnico(String msjTecnico) {
		this.msjTecnico = msjTecnico;
	}
	public Exception getOrigen() {
		return origen;
	}
	public void setOrigen(Exception origen) {
		this.origen = origen;
	}
	
	public ExcepcionesDAO() {
		
	}

	public ExcepcionesDAO(String arg0) {
		super(arg0);
	}

	public ExcepcionesDAO(String arg0, String arg1) {
		super(arg0);
	}
	public ExcepcionesDAO(Throwable arg0) {
		super(arg0);
		
	}

	public ExcepcionesDAO(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ExcepcionesDAO(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}

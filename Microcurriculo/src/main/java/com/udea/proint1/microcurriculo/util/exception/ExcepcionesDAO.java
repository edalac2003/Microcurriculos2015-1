package com.udea.proint1.microcurriculo.util.exception;

import org.apache.log4j.Logger;

public class ExcepcionesDAO extends Exception {
	
	private static Logger logger=Logger.getLogger(ExcepcionesDAO.class);
	
	private String mensajeTecnico = "";
	private String mensajeUsuario = "";
	
	public ExcepcionesDAO() {
		this.mensajeTecnico = "No se ha especificado un mensaje para este este Error.";
	}

	public ExcepcionesDAO(String arg0) {
		super(arg0);
		this.mensajeTecnico = arg0;
	}

	public ExcepcionesDAO(String arg0, String arg1) {
		super(arg0);
		this.mensajeTecnico = arg0;
		this.mensajeUsuario = arg1;
	}
	public ExcepcionesDAO(Throwable arg0) {
		super(arg0);
		
	}

	public ExcepcionesDAO(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.mensajeTecnico = arg0;
	}

	public ExcepcionesDAO(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	
	

}

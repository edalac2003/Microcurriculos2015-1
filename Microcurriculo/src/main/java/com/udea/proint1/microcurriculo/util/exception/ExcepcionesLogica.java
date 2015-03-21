package com.udea.proint1.microcurriculo.util.exception;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ngc.impl.PersonaNGCImpl;

public class ExcepcionesLogica extends Exception {
	
	private static Logger logger=Logger.getLogger(PersonaNGCImpl.class);

	public ExcepcionesLogica() {
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesLogica(String message) {
		super(message);
		logger.error(message);
	}

	public ExcepcionesLogica(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesLogica(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesLogica(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TipoPersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.ngc.TipoPersonaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TipoPersonaNGCImpl implements TipoPersonaNGC {
	
	private static Logger log=Logger.getLogger(TipoPersonaNGCImpl.class);
	
	TipoPersonaDAO tipoPersonaDao;

	public void setTipoPersonaDao(TipoPersonaDAO tipoPersonaDao) {
		this.tipoPersonaDao = tipoPersonaDao;
	}

	public TipoPersonaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public void guardarTipoPersona(TbAdmTipopersona tipoPersona) throws ExcepcionesLogica {
		
		 * Comprobamos que el objeto id no esté vacio
		 
		if(tipoPersona == null){
			throw new ExcepcionesLogica("El objeto tipoPersona está vacio");
		}
		try {
			int id = tipoPersona.getNbIdpersona();
			TbAdmTipopersona tipoPersonaConsulta = tipoPersonaDao.obtenerTipoPersona(id);
		
			if(tipoPersonaConsulta != null){
				throw new ExcepcionesLogica("La tipoPersona a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoPersona de la clase tipoPersonaDao: "+ e);
		}
		
		try {
			
			tipoPersonaDao.guardarTipoPersona(tipoPersona);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarTipoPersona de la clase tipoPersonaDao: "+ e);
		}
	}

	@Override
	public void actualizarTipoPersona(TbAdmTipopersona tipoPersona) throws ExcepcionesLogica {
		
		 * Comprobamos que el objeto id no esté vacio
		 
		if(tipoPersona == null){
			throw new ExcepcionesLogica("El objeto tipoPersona está vacio");
		}
		try {
			int id = tipoPersona.getNbIdpersona();
			TbAdmTipopersona tipoPersonaConsulta = tipoPersonaDao.obtenerTipoPersona(id);
		
			if(tipoPersonaConsulta == null){
				throw new ExcepcionesLogica("La tipoPersona a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoPersona de la clase tipoPersonaDao: "+ e);
		}
		
		try {
			
			tipoPersonaDao.actualizarTipoPersona(tipoPersona);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarTipoPersona de la clase tipoPersonaDao: "+ e);
		}
	}*/

	@Override
	public List<TbAdmTipopersona> listarTipoPersona() throws ExcepcionesLogica {
		List<TbAdmTipopersona> listaTipoPersonas = null;
		try {
			listaTipoPersonas = tipoPersonaDao.listarTipoPersonas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTipoPersona de la clase tipoPersonaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTipoPersonas == null){
			throw new ExcepcionesLogica("No se encontraron TipoPersonas en la tabla TbAdmTipopersona");
		}else{
			return listaTipoPersonas;
		}
	}

	@Override
	public TbAdmTipopersona obtenerTipoPersona(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de tipoPersona, está vacia");
		}
		TbAdmTipopersona tipoPersona = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tipoPersona = tipoPersonaDao.obtenerTipoPersona(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoPersona de la clase tipoPersonaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tipoPersona == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró tipoPersona con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return tipoPersona;
		}
	}

}

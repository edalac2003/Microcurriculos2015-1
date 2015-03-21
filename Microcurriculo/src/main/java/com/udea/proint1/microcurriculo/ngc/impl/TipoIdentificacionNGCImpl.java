package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TipoIdentificacionDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
import com.udea.proint1.microcurriculo.ngc.TipoIdentificacionNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TipoIdentificacionNGCImpl implements TipoIdentificacionNGC {

	private static Logger log=Logger.getLogger(TipoIdentificacionNGCImpl.class);
	
	TipoIdentificacionDAO tipoIdentificacionDao;

	public void setTipoIdentificacionDao(TipoIdentificacionDAO tipoIdentificacionDao) {
		this.tipoIdentificacionDao = tipoIdentificacionDao;
	}

	public TipoIdentificacionNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tipoIdentificacion == null){
			throw new ExcepcionesLogica("El objeto tipoIdentificacion está vacio");
		}
		try {
			int id = tipoIdentificacion.getNbIdidentificacion();
			TbAdmTipoidentificacion tipoIdentificacionConsulta = tipoIdentificacionDao.obtenerTipoIdentificacion(id);
		
			if(tipoIdentificacionConsulta != null){
				throw new ExcepcionesLogica("El tipoIdentificacion a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
		
		try {
			
			tipoIdentificacionDao.guardarTipoIdentificacion(tipoIdentificacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
	}

	@Override
	public void actualizarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tipoIdentificacion == null){
			throw new ExcepcionesLogica("El objeto tipoIdentificacion está vacio");
		}
		try {
			int id = tipoIdentificacion.getNbIdidentificacion();
			TbAdmTipoidentificacion tipoIdentificacionConsulta = tipoIdentificacionDao.obtenerTipoIdentificacion(id);
		
			if(tipoIdentificacionConsulta == null){
				throw new ExcepcionesLogica("El tipoIdentificacion a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
		
		try {
			
			tipoIdentificacionDao.actualizarTipoIdentificacion(tipoIdentificacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
	}

	@Override
	public List<TbAdmTipoidentificacion> listarTipoIdentificacion() throws ExcepcionesLogica {
		List<TbAdmTipoidentificacion> listaTipoIdentificacion = null;
		try {
			listaTipoIdentificacion = tipoIdentificacionDao.listarTipoIdentificacion();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTipoIdentificacion == null){
			throw new ExcepcionesLogica("No se encontraron TipoIdentificaciones en la tabla TbAdmTipoidentificacion");
		}else{
			return listaTipoIdentificacion;
		}
	}

	@Override
	public TbAdmTipoidentificacion obtenerTipoIdentificacion(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de tipoIdentificacion, está vacia");
		}
		TbAdmTipoidentificacion tipoIdentificacion = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tipoIdentificacion = tipoIdentificacionDao.obtenerTipoIdentificacion(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTipoIdentificacion de la clase tipoIdentificacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tipoIdentificacion == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró tipoIdentificacion con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return tipoIdentificacion;
		}
	}

}

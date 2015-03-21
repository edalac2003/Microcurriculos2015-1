package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.ObservacionDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObservacion;
import com.udea.proint1.microcurriculo.ngc.ObservacionNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObservacionNGCImpl implements ObservacionNGC {

	private static Logger log=Logger.getLogger(ObservacionNGCImpl.class);

	ObservacionDAO observacionDao;
	
	public void setObservacionDao(ObservacionDAO observacionDao) {
		this.observacionDao = observacionDao;
	}

	@Override
	public TbMicObservacion obtenerObservacion(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de observacion, está vacia");
		}
		TbMicObservacion observacion = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			observacion = observacionDao.obtenerObservacion(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacion de la clase observacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(observacion == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró observacion con el id "+ id);
		}else{
			return observacion;
		}
	}

	@Override
	public void guardarObservacion(TbMicObservacion observacion)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacion == null){
			throw new ExcepcionesLogica("El objeto observacion está vacio");
		}
		try {
			int id = observacion.getNbIdobservacion();
			TbMicObservacion observacionConsulta = observacionDao.obtenerObservacion(id);
		
			if(observacionConsulta != null){
				throw new ExcepcionesLogica("La observacion a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacion de la clase observacionDao: "+ e);
		}
		
		try {
			
			observacionDao.guardarObservacion(observacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarObservacion de la clase observacionDao: "+ e);
		}
	}

	@Override
	public void actualizarObservacion(TbMicObservacion observacion)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacion == null){
			throw new ExcepcionesLogica("El objeto observacion está vacio");
		}
		try {
			int id = observacion.getNbIdobservacion();
			TbMicObservacion observacionConsulta = observacionDao.obtenerObservacion(id);
		
			if(observacionConsulta == null){
				throw new ExcepcionesLogica("La observacion a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutores de la clase observacionDao: "+ e);
		}
		
		try {
			
			observacionDao.actualizarObservacion(observacion);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAutor de la clase observacionDao: "+ e);
		}
	}

	@Override
	public List<TbMicObservacion> listarObservacion() throws ExcepcionesLogica {
		List<TbMicObservacion> listaObservacion = null;
		try {
			listaObservacion = observacionDao.listarObservacion();
		} catch (ExcepcionesDAO e) {
			log.error("fallo al invocar el metodo listarObservacion de la clase observacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObservacion == null){
			throw new ExcepcionesLogica("No se encontraron Observacion en la tabla TbMicObservacion");
		}else{
			return listaObservacion;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = observacionDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica(e);
//		}
//		
//		return registro;
//	}
	
	

}

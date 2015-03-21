package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.ngc.EvaluacionNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionNGCImpl implements EvaluacionNGC {
	
	private static Logger log=Logger.getLogger(EvaluacionNGCImpl.class);
	
	EvaluacionDAO evaluacionDao;

	public void setEvaluacionDao(EvaluacionDAO evaluacionDao) {
		this.evaluacionDao = evaluacionDao;
	}

	@Override
	public void guardarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			throw new ExcepcionesLogica("El objeto evaluacion está vacio");
		}
		try {
			int id = evaluacion.getNbIdevaluacion();
			TbMicEvaluacion evaluacionConsulta = evaluacionDao.obtenerEvaluaciones(id);
		
			if(evaluacionConsulta != null){
				throw new ExcepcionesLogica("La evaluacion a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionDao: "+ e);
		}
		
		try {
			
			evaluacionDao.guardarEvaluaciones(evaluacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarEvaluaciones de la clase evaluacionDao: "+ e);
		}
	}

	@Override
	public void actualizarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			throw new ExcepcionesLogica("El objeto evaluacion está vacio");
		}
		try {
			int id = evaluacion.getNbIdevaluacion();
			TbMicEvaluacion evaluacionConsulta = evaluacionDao.obtenerEvaluaciones(id);
		
			if(evaluacionConsulta == null){
				throw new ExcepcionesLogica("La evaluacion a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionDao: "+ e);
		}
		
		try {
			
			evaluacionDao.actualizarEvaluaciones(evaluacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluaciones de la clase evaluacionDao: "+ e);
		}
	}

	@Override
	public TbMicEvaluacion obtenerEvaluacion(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de evaluacion, está vacia");
		}
		TbMicEvaluacion evaluacion = null;
		
		try {
			evaluacion = evaluacionDao.obtenerEvaluaciones(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(evaluacion == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró evaluacion con el id "+ id);
		}else{
			return evaluacion;
		}
	}

	@Override
	public List<TbMicEvaluacion> listarEvaluacion() throws ExcepcionesLogica {
		List<TbMicEvaluacion> listaEvaluaciones = null;
		try {
			listaEvaluaciones = evaluacionDao.listarEvaluaciones();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarEvaluaciones de la clase evaluacionDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEvaluaciones == null){
			throw new ExcepcionesLogica("No se encontraron evaluaciones en la tabla TbMicEvaluaciones");
		}else{
			return listaEvaluaciones;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registros = 0;
//			
//		try {
//			registros = evaluacionDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Se presentaron errores al intentar Obtener el numero de Registros de la Tabla Evaluaciones.");
//		}
//		return registros;
//	}
	
	

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.ObservacionxTablaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmObservacionxtabla;
import com.udea.proint1.microcurriculo.ngc.ObservacionxTablaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObservacionxTablaNGCImpl implements ObservacionxTablaNGC {

	private static Logger log=Logger.getLogger(ObservacionxTablaNGCImpl.class);

	ObservacionxTablaDAO observacionxTablaDao;
	
	public void setObservacionxTablaDao(ObservacionxTablaDAO observacionxTablaDao) {
		this.observacionxTablaDao = observacionxTablaDao;
	}

	@Override
	public TbAdmObservacionxtabla obtenerObservacionxTabla(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de observacionxtabla, está vacia");
		}
		TbAdmObservacionxtabla observacionxtabla = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			observacionxtabla = observacionxTablaDao.obtenerObservacionxTabla(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxTabla de la clase observacionxTablaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(observacionxtabla == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró observacionxtabla con el id "+ id);
		}else{
			return observacionxtabla;
		}
	}

	@Override
	public void guardarObservacionxTabla(
			TbAdmObservacionxtabla observacionxtabla) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacionxtabla == null){
			throw new ExcepcionesLogica("El objeto observacionxtabla está vacio");
		}
		try {
			int id = observacionxtabla.getNbIdobservaciones();
			TbAdmObservacionxtabla observacionxtablaConsulta = observacionxTablaDao.obtenerObservacionxTabla(id);
		
			if(observacionxtablaConsulta != null){
				throw new ExcepcionesLogica("La observacionxtabla a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxTabla de la clase observacionxTablaDao: "+ e);
		}
		
		try {
			
			observacionxTablaDao.guardarObservacionxTabla(observacionxtabla);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarObservacionxTabla de la clase observacionxTablaDao: "+ e);
		}
	}

	@Override
	public void actualizarObservacionxTabla(
			TbAdmObservacionxtabla observacionxtabla) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacionxtabla == null){
			throw new ExcepcionesLogica("El objeto observacionxtabla está vacio");
		}
		try {
			int id = observacionxtabla.getNbIdobservaciones();
			TbAdmObservacionxtabla observacionxtablaConsulta = observacionxTablaDao.obtenerObservacionxTabla(id);
		
			if(observacionxtablaConsulta == null){
				throw new ExcepcionesLogica("La observacionxtabla a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxTabla de la clase observacionxTablaDao: "+ e);
		}
		
		try {
			
			observacionxTablaDao.actualizarObservacionxTabla(observacionxtabla);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarObservacionxTabla de la clase observacionxTablaDao: "+ e);
		}
	}

	@Override
	public List<TbAdmObservacionxtabla> listarObservacionxTabla()
			throws ExcepcionesLogica {
		List<TbAdmObservacionxtabla> listaObservacionxtabla = null;
		try {
			listaObservacionxtabla = observacionxTablaDao.listarObservacionxTabla();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObservacionxtabla de la clase observacionxTablaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObservacionxtabla == null){
			throw new ExcepcionesLogica("No se encontraron Autores en la tabla TbAdmObservacionxtabla");
		}else{
			return listaObservacionxtabla;
		}
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.ActividadxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicActividadxmicro;
import com.udea.proint1.microcurriculo.ngc.ActividadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ActividadxMicroNGCImpl implements ActividadxMicroNGC {

	private static Logger log=Logger.getLogger(ActividadxMicroNGCImpl.class);

	ActividadxMicroDAO actividadxMicroDao;
	
	public void setActividadxMicroDao(ActividadxMicroDAO actividadxMicroDao) {
		this.actividadxMicroDao = actividadxMicroDao;
	}

	@Override
	public TbMicActividadxmicro obtenerActividadxmicro(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de actividadxMicro, está vacia");
		}
		TbMicActividadxmicro actividadxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			actividadxMicro = actividadxMicroDao.obtenerActividadxMicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(actividadxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró actividadxMicro con el id "+ id);
		}else{
			return actividadxMicro;
		}
	}

	@Override
	public void guardarActividadxmicro(TbMicActividadxmicro actividadxmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(actividadxmicro == null){
			throw new ExcepcionesLogica("El objeto actaxmicro está vacio");
		}
		try {
			int id = actividadxmicro.getNbIdactividad();
			TbMicActividadxmicro actividadxmicroConsulta = actividadxMicroDao.obtenerActividadxMicro(id);
		
			if(actividadxmicroConsulta != null){
				throw new ExcepcionesLogica("La actaxmicro a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
		
		try {
			
			actividadxMicroDao.guardarActividadxMicro(actividadxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
	}

	@Override
	public void actualizarActividadxmicro(TbMicActividadxmicro actividadxmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(actividadxmicro == null){
			throw new ExcepcionesLogica("El objeto actividadxmicro está vacio");
		}
		try {
			int id = actividadxmicro.getNbIdactividad();
			TbMicActividadxmicro actividadxmicroConsulta = actividadxMicroDao.obtenerActividadxMicro(id);
		
			if(actividadxmicroConsulta == null){
				throw new ExcepcionesLogica("La actividadxmicro a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
		
		try {
			
			actividadxMicroDao.actualizarActividadxMicro(actividadxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
	}

	@Override
	public List<TbMicActividadxmicro> listarActividadxmicro()
			throws ExcepcionesLogica {
		List<TbMicActividadxmicro> listaActividadxmicro = null;
		try {
			listaActividadxmicro = actividadxMicroDao.listarActividadxMicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarActividadxMicro de la clase actividadxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaActividadxmicro == null){
			throw new ExcepcionesLogica("No se encontraron Actividadxmicro en la tabla TbMicActividadxmicro");
		}else{
			return listaActividadxmicro;
		}
	}

}

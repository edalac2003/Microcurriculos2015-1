package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadNGCImpl  implements UnidadNGC {
	
private static Logger log = Logger.getLogger(UnidadNGCImpl.class);
	
	UnidadDAO unidadDao;
	
	public void setunidadDao(UnidadDAO unidadDao) {
		this.unidadDao = unidadDao;
	}

	
	@Override
	public void guardarUnidades(TbMicUnidad unidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidad == null){
			throw new ExcepcionesLogica("El objeto unidad est� vacio");
		}
		try {
			int id = unidad.getNbIdunidad();
			TbMicUnidad unidadConsulta = unidadDao.obtenerUnidad(id);
		
			if(unidadConsulta != null){
				throw new ExcepcionesLogica("La Unidad a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
		}
		
		try {
			
			unidadDao.guardarUnidad(unidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUnidad de la clase unidadDao: "+ e);
		}
	}

	@Override
	public TbMicUnidad obtenerUnidades(int idUnidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(idUnidad == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de unidad, está vacia");
		}
		TbMicUnidad unidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidad = unidadDao.obtenerUnidad(idUnidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Unidad con el id "+ idUnidad);
		}else{
			//si no esta vacio retorna la ciudad
			return unidad;
		}
	}

	@Override
	public void actualizarUnidades(TbMicUnidad unidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidad == null){
			throw new ExcepcionesLogica("El objeto unidad está vacio");
		}
		try {
			int id = unidad.getNbIdunidad();
			TbMicUnidad unidadConsulta = unidadDao.obtenerUnidad(id);
		
			if(unidadConsulta == null){
				throw new ExcepcionesLogica("La Unidad a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
		}
		
		try {
			
			unidadDao.modificarUnidad(unidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarUnidad de la clase unidadDao: "+ e);
		}
	}

	@Override
	public List<TbMicUnidad> listarUnidades() throws ExcepcionesLogica {
		List<TbMicUnidad> listaUnidades = null;
		try {
			listaUnidades = unidadDao.listarUnidades();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidades de la clase unidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidades == null){
			throw new ExcepcionesLogica("No se encontraron unidades en la tabla TbMicUnidades");
		}else{
			return listaUnidades;
		}
	}

	
//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		try {
//			registro = unidadDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("Se produjo un Error al Contar los Registros de la Tabla Unidades.");
//		}
//		
//		return registro;
//	}
	
}

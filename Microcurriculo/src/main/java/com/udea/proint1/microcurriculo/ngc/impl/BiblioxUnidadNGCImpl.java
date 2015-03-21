package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
import com.udea.proint1.microcurriculo.dao.UnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BiblioxUnidadNGCImpl implements BiblioxunidadNGC{

	private static Logger log=Logger.getLogger(BiblioxUnidadNGCImpl.class);
	
	BiblioxUnidadDAO biblioxUnidadDao;
	
	UnidadDAO unidadDao;
	
	public void setBiblioxUnidadDao(BiblioxUnidadDAO biblioxUnidadDao) {
		this.biblioxUnidadDao = biblioxUnidadDao;
	}

	public void setUnidadDao(UnidadDAO unidadDao) {
		this.unidadDao = unidadDao;
	}

	public BiblioxUnidadNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(biblioxUnidad == null){
			throw new ExcepcionesLogica("El objeto biblioxUnidad est� vacio");
		}
		try {
			int id = biblioxUnidad.getNbId();
			TbMicBiblioxunidad biblioxUnidadConsulta = biblioxUnidadDao.obtenerBiblioxUnidad(id);
		
			if(biblioxUnidadConsulta != null){
				throw new ExcepcionesLogica("La Bibliografia x Unidad a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
		
		try {
			
			biblioxUnidadDao.guardarBiblioxUnidad(biblioxUnidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(biblioxUnidad == null){
			throw new ExcepcionesLogica("El objeto biblioxUnidad está vacio");
		}
		try {
			int id = biblioxUnidad.getNbId();
			TbMicBiblioxunidad biblioxUnidadConsulta = biblioxUnidadDao.obtenerBiblioxUnidad(id);
		
			if(biblioxUnidadConsulta == null){
				throw new ExcepcionesLogica("La Bibliografia x Unidad a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
		
		try {
			
			biblioxUnidadDao.modificarBiblioxUnidad(biblioxUnidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de bibliosxUnidad, está vacia");
		}
		TbMicBiblioxunidad bibliosxUnidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			bibliosxUnidad = biblioxUnidadDao.obtenerBiblioxUnidad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(bibliosxUnidad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Bibliografia x Unidad con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return bibliosxUnidad;
		}
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesLogica {
		List<TbMicBiblioxunidad> listaBibliosxUnidad = null;
		try {
			listaBibliosxUnidad = biblioxUnidadDao.listadoBiblioxUnidad();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listadoBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliosxUnidad == null){
			throw new ExcepcionesLogica("No se encontraron bibliografias x unidad en la tabla TbMicBiblioxunidad");
		}else{
			return listaBibliosxUnidad;
		}
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad)
			throws ExcepcionesLogica {
		List<TbMicBiblioxunidad> listaBibliosxUnidad = null;
		
		TbMicUnidad unidad= null;
		
		try {
			unidad = unidadDao.obtenerUnidad(idUnidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
		}
		
		
		try {
			listaBibliosxUnidad = biblioxUnidadDao.listadoBiblioxUnidad(unidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listadoBiblioxUnidad(TbMicUnidades) de la clase biblioxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaBibliosxUnidad;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = biblioxUnidadDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica();
//		}
//		
//		return registro;
//	}

}

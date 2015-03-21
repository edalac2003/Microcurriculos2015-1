package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadAcademicaNGCImpl implements UnidadAcademicaNGC {

	private static Logger log=Logger.getLogger(UnidadAcademicaNGCImpl.class);
	
	UnidadAcademicaDAO unidadAcademicaDao;

	public void setUnidadAcademicaDao(UnidadAcademicaDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public UnidadAcademicaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidadAcademica == null){
			throw new ExcepcionesLogica("El objeto unidadAcademica está vacio");
		}
		try {
			String id = unidadAcademica.getVrIdunidad();
			TbAdmUnidadAcademica unidadAcademicaConsulta = unidadAcademicaDao.obtenerUnidad(id);
		
			if(unidadAcademicaConsulta != null){
				throw new ExcepcionesLogica("La unidadAcademica a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadAcademicaDao: "+ e);
		}
		
		try {
			
			unidadAcademicaDao.guardarUnidad(unidadAcademica);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarUnidad de la clase unidadAcademicaDao: "+ e);
		}
	}

	@Override
	public void actualizarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidadAcademica == null){
			throw new ExcepcionesLogica("El objeto unidadAcademica está vacio");
		}
		try {
			String id = unidadAcademica.getVrIdunidad();
			TbAdmUnidadAcademica unidadAcademicaConsulta = unidadAcademicaDao.obtenerUnidad(id);
		
			if(unidadAcademicaConsulta == null){
				throw new ExcepcionesLogica("La unidadAcademica a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadAcademicaDao: "+ e);
		}
		
		try {
			
			unidadAcademicaDao.modificarUnidad(unidadAcademica);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarUnidadAcademica de la clase unidadAcademicaDao: "+ e);
		}
	}

	@Override
	public TbAdmUnidadAcademica obtenerUnidadAcademica(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de unidadAcademica, está vacia");
		}
		TbAdmUnidadAcademica unidadAcademica = null;
		
		try {
			unidadAcademica = unidadAcademicaDao.obtenerUnidad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadAcademicaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidadAcademica == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró unidadAcademica con el id "+ id);
		}else{
			return unidadAcademica;
		}
	}

	@Override
	public List<TbAdmUnidadAcademica> listarUnidadAcademicas() throws ExcepcionesLogica {
		List<TbAdmUnidadAcademica> listaUnidadAcademicas = null;
		try {
			listaUnidadAcademicas = unidadAcademicaDao.listarUnidades();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidadesAcademicas de la clase unidadAcademicaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidadAcademicas == null){
			throw new ExcepcionesLogica("No se encontraron Unidades Academicas en la tabla TbAdmUnidadAcademica");
		}else{
			return listaUnidadAcademicas;
		}
	}

}

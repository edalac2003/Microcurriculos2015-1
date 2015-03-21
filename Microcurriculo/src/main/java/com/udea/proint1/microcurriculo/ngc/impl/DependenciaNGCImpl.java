package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DependenciaDAO;
import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DependenciaNGCImpl implements DependenciaNGC {
	
	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);
	
	DependenciaDAO dependenciaDao;
	UnidadAcademicaDAO unidadAcademicaDao;

	public void setDependenciaDao(DependenciaDAO dependenciaDao) {
		this.dependenciaDao = dependenciaDao;
	}

	public void setUnidadAcademicaDao(UnidadAcademicaDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public DependenciaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(dependencia == null){
			throw new ExcepcionesLogica("El objeto dependencia está vacio");
		}
		try {
			String id = dependencia.getVrIddependencia();
			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencias(id);
		
			if(dependenciaConsulta != null){
				throw new ExcepcionesLogica("La dependencia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		try {
			
			dependenciaDao.guardarDependencia(dependencia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(dependencia == null){
			throw new ExcepcionesLogica("El objeto dependencia está vacio");
		}
		try {
			String id = dependencia.getVrIddependencia();
			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencias(id);
		
			if(dependenciaConsulta == null){
				throw new ExcepcionesLogica("La dependencia a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		try {
			
			dependenciaDao.actualizarDependencias(dependencia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de dependencia,está vacia");
		}
		TbAdmDependencia dependencia = null;
		
		try {
			dependencia = dependenciaDao.obtenerDependencias(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(dependencia == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró dependencia con el id "+ id);
		}else{
			return dependencia;
		}
	}
	

	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesLogica {
		List<TbAdmDependencia> listaDependencia = null;
		
		if(unidad != null){
			try {
				listaDependencia = dependenciaDao.listarDependenciasPorUnidad(unidad);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica(e);
			}
		} else {
			throw new ExcepcionesLogica("El Objeto <Tb_Adm_UnidadAcademica> est� Vacio.");
		}		
		return listaDependencia;
	}

	@Override
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesLogica {
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.listarDependencias();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDependencias de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			throw new ExcepcionesLogica("No se encontraron dependencias en la tabla TbAdmDependencia");
		}else{
			return listaDependencias;
		}
	}

	

	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(String unidad) throws ExcepcionesLogica {
		if(unidad.equals("")||(unidad.equals(null))){
			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
		}
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.listarDependenciasPorUnidad(unidad);
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("NGC : Se presentaron errores al listar las Dependencias por Unidad. "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			throw new ExcepcionesLogica("No se encontraron dependencias en la tabla TbAdmDependencia");
		}else{
			return listaDependencias;
		}
	}
	
	@Override
	public List<TbAdmDependencia> buscarDepedencias(String buscar) throws ExcepcionesLogica{
//		if(buscar.equals("")||(buscar.equals(null))){
//			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
//		}
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.buscarDependencias(buscar);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo buscarDependencias de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			throw new ExcepcionesLogica("No se encontraron dependencias en la tabla TbAdmDependencia");
		}else{
			return listaDependencias;
		}
	}
	
	
}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DocentexDependenciaDAO;
import com.udea.proint1.microcurriculo.dao.DependenciaDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.ngc.DocentexDependenciaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DocentexDependenciaNGCImpl implements DocentexDependenciaNGC {
	

	private static Logger log=Logger.getLogger(DocentexDependenciaNGCImpl.class);
	
	DocentexDependenciaDAO docentexDependenciaDao;	
	DependenciaDAO dependenciaDao;	
	PersonaDAO personaDao;
	
	public void setDocentexDependenciaDao(DocentexDependenciaDAO docentexDependenciaDao) {
		this.docentexDependenciaDao = docentexDependenciaDao;
	}

	public void setDependenciaDao(DependenciaDAO dependenciaDao) {
		this.dependenciaDao = dependenciaDao;
	}
	
	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	public DocentexDependenciaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDocentexDependencia(TbAdmDocentexDependencia docentesxDependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxDependencia == null){
			throw new ExcepcionesLogica("El objeto docentesxDependencia está vacio");
		}
		try {
			int id = docentesxDependencia.getNbId();
			TbAdmDocentexDependencia docentesxDependenciaConsulta = docentexDependenciaDao.obtenerDocentesxDependencia(id);
		
			if(docentesxDependenciaConsulta != null){
				throw new ExcepcionesLogica("El docentesxDependencia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxDependencia de la clase docentexDependenciaDao: "+ e);
		}
		
		try {
			
			docentexDependenciaDao.guardarDocentesxDependencia(docentesxDependencia);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarDocentexDependencia(TbAdmDocentexDependencia docentesxDependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxDependencia == null){
			throw new ExcepcionesLogica("El objeto docentesxDependencia está vacio");
		}
		try {
			int id = docentesxDependencia.getNbId();
			TbAdmDocentexDependencia docentesxDependenciaConsulta = docentexDependenciaDao.obtenerDocentesxDependencia(id);
		
			if(docentesxDependenciaConsulta == null){
				throw new ExcepcionesLogica("El docentesxDependencia a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxDependencia de la clase docentexDependenciaDao: "+ e);
		}
		
		try {
			
			docentexDependenciaDao.actualizarDocentesxDependencia(docentesxDependencia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarDocentesxDependencia de la clase docentexDependenciaDao: "+ e);
		}
	}

	@Override
	public List<TbAdmDocentexDependencia> listarDocentesxDependencia() throws ExcepcionesLogica {
		List<TbAdmDocentexDependencia> listaDocentesxDependencia = null;
		
		try {
			listaDocentesxDependencia = docentexDependenciaDao.listarDocentesxDependencia();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDocentesxDependencia de la clase docentexDependenciaDao: "+ e);
		}
		
		return listaDocentesxDependencia;
		
	}


	
	@Override
	public List<TbAdmDocentexDependencia> listarDocentesxDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		List<TbAdmDocentexDependencia> listaDocentexDependencia = null;
		
		try {
			listaDocentexDependencia = docentexDependenciaDao.listaDocentesxDependencia(dependencia);
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaDocentexDependencia;
	}


	
	@Override
	public TbAdmDocentexDependencia obtenerDocentexDependencia(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de docentesxDependencia, está vacia");
		}
		TbAdmDocentexDependencia docentesxDependencia = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			docentesxDependencia = docentexDependenciaDao.obtenerDocentesxDependencia(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxDependencia de la clase docentexDependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(docentesxDependencia == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró docentesxDependencia con el id "+ id);
		}else{
			return docentesxDependencia;
		}
	}
	
	public List<TbAdmDocentexDependencia> listarDependenciasxDocente(TbAdmPersona docente) throws ExcepcionesDAO, ExcepcionesLogica{
		if(docente == null){
			throw new ExcepcionesLogica("No se encontró una identificación de docente");
		}
		
		List<TbAdmDocentexDependencia> dependeciasxDocente = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			dependeciasxDocente = docentexDependenciaDao.listarDependenciasxDocente(docente);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		return dependeciasxDocente;
	}
	
	public List<TbAdmDocentexDependencia> listarDependenciasxDocentexUnidad(TbAdmPersona docente, TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO, ExcepcionesLogica{
		if(docente == null){
			throw new ExcepcionesLogica("No se encontró una identificación de docente");
		}
		
		List<TbAdmDocentexDependencia> dependeciasxDocente = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			dependeciasxDocente = docentexDependenciaDao.listarDependenciasxDocente(docente);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		List<TbAdmDocentexDependencia> dependeciasxDocenteFiltrada = new ArrayList<TbAdmDocentexDependencia>();
		if(dependeciasxDocente != null){
			for(TbAdmDocentexDependencia dependecia: dependeciasxDocente){
				if(dependecia.getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad().equals(unidadAcademica.getVrIdunidad())){
					dependeciasxDocenteFiltrada.add(dependecia);
				}
			}
		}
		
		return dependeciasxDocenteFiltrada;
	}

}

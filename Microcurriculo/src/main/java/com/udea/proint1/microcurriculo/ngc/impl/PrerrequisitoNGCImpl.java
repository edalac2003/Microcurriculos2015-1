package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dao.PrerrequisitoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PrerrequisitoNGCImpl implements PrerrequisitoNGC {

	private static Logger log=Logger.getLogger(PrerrequisitoNGCImpl.class);	
	
	PrerrequisitoDAO prerrequisitoDao;
	MateriaDAO materiaDao;
	
	public void setPrerrequisitoDao(PrerrequisitoDAO prerrequisitoDao) {
		this.prerrequisitoDao = prerrequisitoDao;
	}

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public PrerrequisitoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(prerrequisito == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = prerrequisito.getNbId();
			TbAdmPrerrequisito prerrequisitoConsulta = prerrequisitoDao.obtenerPrerrequisito(id);
		
			if(prerrequisitoConsulta != null){
				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitoDao: "+ e);
		}
		
		try {
			
			prerrequisitoDao.guardarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarPrerrequisito de la clase prerrequisitoDao: "+ e);
		}
	}

	@Override
	public void actualizarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(prerrequisito == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = prerrequisito.getNbId();
			TbAdmPrerrequisito prerrequisitoConsulta = prerrequisitoDao.obtenerPrerrequisito(id);
		
			if(prerrequisitoConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitoDao: "+ e);
		}
		
		try {
			
			prerrequisitoDao.actualizarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPrerrequisito de la clase prerrequisitoDao: "+ e);
		}
	}

	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitos() throws ExcepcionesLogica {
		List<TbAdmPrerrequisito> listaPrerrequisitos = null;
		try {
			listaPrerrequisitos = prerrequisitoDao.listarPrerrequisitos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPrerrequisitos de la clase prerrequisitoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaPrerrequisitos == null){
			throw new ExcepcionesLogica("No se encontraron prerrequisitos en la tabla TbAdmPrerrequisitos");
		}else{
			return listaPrerrequisitos;
		}
	}

	@Override
	public TbAdmPrerrequisito obtenerPrerrequisito(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de prerrequisito, está vacia");
		}
		TbAdmPrerrequisito prerrequisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			prerrequisito = prerrequisitoDao.obtenerPrerrequisito(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(prerrequisito == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró prerrequisito con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return prerrequisito;
		}
	}
	
	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitosxMateria(String id) throws ExcepcionesDAO{
		List<TbAdmPrerrequisito> listaPrerrequisitos = null;
		
		TbAdmMateria materia= null;
		
		try {
			materia = materiaDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiaDao: "+ e);
		}
		
		
		try {
			listaPrerrequisitos = prerrequisitoDao.listarPrerrequisitosxMateria(materia);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitosxmateria de la clase correquisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaPrerrequisitos;
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CorrequisitoDAO;
import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitoNGCImpl implements CorrequisitoNGC {
	
	private static Logger log=Logger.getLogger(CorrequisitoNGCImpl.class);	

	CorrequisitoDAO correquisitoDao;
	MateriaDAO materiaDao;
	
	public void setCorrequisitoDao(CorrequisitoDAO correquisitoDao) {
		this.correquisitoDao = correquisitoDao;
	}

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public CorrequisitoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			throw new ExcepcionesLogica("El objeto correquisito está vacio");
		}
		try {
			int id = correquisito.getNbId();
			TbAdmCorrequisito correquisitoConsulta = correquisitoDao.obtenerCorrequisitos(id);
		
			if(correquisitoConsulta != null){
				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisitos de la clase correquisitoDao: "+ e);
		}
		
		try {
			
			correquisitoDao.guardarCorrequisito(correquisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarCorrequisito de la clase correquisitoDao: "+ e);
		}
	}

	@Override
	public void actualizarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			throw new ExcepcionesLogica("El objeto correquisito está vacio");
		}
		try {
			int id = correquisito.getNbId();
			TbAdmCorrequisito correquisitoConsulta = correquisitoDao.obtenerCorrequisitos(id);
		
			if(correquisitoConsulta == null){
				throw new ExcepcionesLogica("El correquisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisito de la clase correquisitoDao: "+ e);
		}
		
		try {
			
			correquisitoDao.actualizarCorrequisito(correquisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
	}

	@Override
	public List<TbAdmCorrequisito> listarCorrequisitos() throws ExcepcionesLogica {
		List<TbAdmCorrequisito> listaCorrequisitos = null;
		try {
			listaCorrequisitos = correquisitoDao.listarCorrequisitos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitos de la clase correquisitoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaCorrequisitos == null){
			throw new ExcepcionesLogica("No se encontraron Correquisitos en la tabla TbAdmCorrequisitos");
		}else{
			return listaCorrequisitos;
		}
	}

	@Override
	public TbAdmCorrequisito obtenerCorrequisito(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de correquisito, está vacia");
		}
		TbAdmCorrequisito correquisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			correquisito = correquisitoDao.obtenerCorrequisitos(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisitos de la clase correquisitoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(correquisito == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró correquisito con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return correquisito;
		}
	}
	
	@Override
	public List<TbAdmCorrequisito> listarCorrequisitosxMateria(String id) throws ExcepcionesLogica{
		
		List<TbAdmCorrequisito> listaCorrequisitos = null;
		
		TbAdmMateria materia= null;
		
		try {
			materia = materiaDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiaDao: "+ e);
		}
		
		if(materia == null){
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
		try {
			listaCorrequisitos = correquisitoDao.listarCorrequisitosxMateria(materia);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitosxmateria de la clase correquisitoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaCorrequisitos;
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DocentexNucleoDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexnucleo;
import com.udea.proint1.microcurriculo.ngc.DocentexNucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DocentexNucleoNGCImpl implements DocentexNucleoNGC {
	
	private static Logger log=Logger.getLogger(DocentexNucleoNGCImpl.class);
	
	DocentexNucleoDAO docentexNucleoDao;
	
	NucleoDAO nucleoDao;
	
	PersonaDAO personaDao;
	
	public void setDocentexNucleoDao(DocentexNucleoDAO docentexNucleoDao) {
		this.docentexNucleoDao = docentexNucleoDao;
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	public DocentexNucleoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDocentexNucleo(TbAdmDocentexnucleo docentesxNucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxNucleo == null){
			throw new ExcepcionesLogica("El objeto docentesxNucleo está vacio");
		}
		try {
			int id = docentesxNucleo.getNbId();
			TbAdmDocentexnucleo docentesxNucleoConsulta = docentexNucleoDao.obtenerDocentesxNucleo(id);
		
			if(docentesxNucleoConsulta != null){
				throw new ExcepcionesLogica("El docentesxNucleo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxNucleo de la clase docentexNucleoDao: "+ e);
		}
		
		try {
			
			docentexNucleoDao.guardarDocentesxNucleo(docentesxNucleo);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarDocentexNucleo(TbAdmDocentexnucleo docentesxNucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxNucleo == null){
			throw new ExcepcionesLogica("El objeto docentesxNucleo está vacio");
		}
		try {
			int id = docentesxNucleo.getNbId();
			TbAdmDocentexnucleo docentesxNucleoConsulta = docentexNucleoDao.obtenerDocentesxNucleo(id);
		
			if(docentesxNucleoConsulta == null){
				throw new ExcepcionesLogica("El docentesxNucleo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxNucleo de la clase docentexNucleoDao: "+ e);
		}
		
		try {
			
			docentexNucleoDao.actualizarDocentesxNucleo(docentesxNucleo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarDocentesxNucleo de la clase docentexNucleoDao: "+ e);
		}
	}

	@Override
	public List<TbAdmDocentexnucleo> listarDocentesxNucleo() throws ExcepcionesLogica {
		List<TbAdmDocentexnucleo> listaDocentesxNucleo = null;
		try {
			listaDocentesxNucleo = docentexNucleoDao.listarDocentesxNucleo();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDocentesxNucleo de la clase docentexNucleoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDocentesxNucleo == null){
			throw new ExcepcionesLogica("No se encontraron docentesxNucleo en la tabla TbAdmDocentesxnucleo");
		}else{
			return listaDocentesxNucleo;
		}
	}

	@Override
	public TbAdmDocentexnucleo obtenerDocentexNucleo(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de docentesxNucleo, está vacia");
		}
		TbAdmDocentexnucleo docentesxNucleo = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			docentesxNucleo = docentexNucleoDao.obtenerDocentesxNucleo(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxNucleo de la clase docentexNucleoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(docentesxNucleo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró docentesxNucleo con el id "+ id);
		}else{
			return docentesxNucleo;
		}
	}

}

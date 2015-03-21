package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SemestreNGCImpl implements SemestreNGC {

	private static Logger log=Logger.getLogger(SemestreNGCImpl.class);
	
	SemestreDAO semestreDao;
	
	public void setSemestreDao(SemestreDAO semestreDao) {
		this.semestreDao = semestreDao;
	}

	public SemestreNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(semestre == null){
			throw new ExcepcionesLogica("El objeto semestre está vacio");
		}
		try {
			String id = semestre.getVrIdsemestre();
			TbAdmSemestre semestreConsulta = semestreDao.obtenerSemestre(id);
		
			if(semestreConsulta != null){
				throw new ExcepcionesLogica("El semestre a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSemestre de la clase semestreDao: "+ e);
		}
		
		try {
			
			semestreDao.guardarSemestre(semestre);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarSemestre de la clase semestreDao: "+ e);
		}*/
	}

	@Override
	public void actualizarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(semestre == null){
			throw new ExcepcionesLogica("El objeto semestre está vacio");
		}
		try {
			String id = semestre.getVrIdsemestre();
			TbAdmSemestre semestreConsulta = semestreDao.obtenerSemestre(id);
		
			if(semestreConsulta == null){
				throw new ExcepcionesLogica("El semestre a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSemestre de la clase semestreDao: "+ e);
		}
		
		try {
			
			semestreDao.actualizarSemestre(semestre);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarSemestre de la clase semestreDao: "+ e);
		}*/
		
	}

	@Override
	public TbAdmSemestre obtenerSemestre(String id) throws ExcepcionesLogica {
		TbAdmSemestre semestre = null;
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.trim().length() > 0) && (id != null)){
			try {
				semestre = semestreDao.obtenerSemestre(id);
			} catch (ExcepcionesDAO e) {
				log.error("Problemas al invocar el metodo obtenerSemestre de la clase semestreDao: "+ e);
			}
			
		} else
			throw new ExcepcionesLogica("El ID de Semestre est� vacio.");
		
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(semestre != null){			
			return semestre;
			
		}else{
			//Se lanza una Excepcion en caso que el Semestre no se encuentre
			throw new ExcepcionesLogica("No se encontr� semestre con el id "+ id);
		}
	}

	@Override
	public List<TbAdmSemestre> listarSemestres() throws ExcepcionesLogica {
		List<TbAdmSemestre> listaSemestres = null;
		try {
			listaSemestres = semestreDao.listarSemestres();
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo listarSemestres de la clase semestreDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if (listaSemestres != null)
			return listaSemestres;
		else
			throw new ExcepcionesLogica("No se encontraron semestres en la tabla TbAdmSemestre");
		
		
	}

}

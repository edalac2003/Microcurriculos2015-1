package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaxPensumDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.ngc.MateriaxPensumNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MateriaxPensumNGCImpl implements MateriaxPensumNGC {

	private static Logger log=Logger.getLogger(MateriaxPensumNGCImpl.class);

	MateriaxPensumDAO materiaxPensumDao;
	
	public void setMateriaxPensumDao(MateriaxPensumDAO materiaxPensumDao) {
		this.materiaxPensumDao = materiaxPensumDao;
	}

	@Override
	public TbMicMateriaxpensum obtenerMateriasxpensum(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de materiasxPensum, está vacia");
		}
		TbMicMateriaxpensum materiasxPensum = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			materiasxPensum = materiaxPensumDao.obtenerMateriasxPensum(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateriasxPensum de la clase materiaxPensumDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(materiasxPensum == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró materiasxPensum con el id "+ id);
		}else{
			return materiasxPensum;
		}
	}

	@Override
	public void guardarMateriasxpensum(TbMicMateriaxpensum materiasxPensum)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materiasxPensum == null){
			throw new ExcepcionesLogica("El objeto materiasxPensum está vacio");
		}
		try {
			int id = materiasxPensum.getNbId();
			TbMicMateriaxpensum materiasxPensumConsulta = materiaxPensumDao.obtenerMateriasxPensum(id);
		
			if(materiasxPensumConsulta != null){
				throw new ExcepcionesLogica("La materiasxPensum a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateriasxPensum de la clase materiaxPensumDao: "+ e);
		}
		
		try {
			
			materiaxPensumDao.guardarMateriasxPensum(materiasxPensum);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMateriasxPensum de la clase materiaxPensumDao: "+ e);
		}
	}

	@Override
	public void actualizarMateriasxpensum(TbMicMateriaxpensum materiasxPensum)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materiasxPensum == null){
			throw new ExcepcionesLogica("El objeto materiasxPensum está vacio");
		}
		try {
			int id = materiasxPensum.getNbId();
			TbMicMateriaxpensum materiasxPensumConsulta = materiaxPensumDao.obtenerMateriasxPensum(id);
		
			if(materiasxPensumConsulta == null){
				throw new ExcepcionesLogica("La materiasxPensum a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateriasxPensum de la clase materiaxPensumDao: "+ e);
		}
		
		try {
			
			materiaxPensumDao.actualizarMateriasxPensum(materiasxPensum);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarMateriasxPensum de la clase materiaxPensumDao: "+ e);
		}
	}

	@Override
	public List<TbMicMateriaxpensum> listarMateriasxpensum()
			throws ExcepcionesLogica {
		List<TbMicMateriaxpensum> listaMateriaxpensum = null;
		try {
			listaMateriaxpensum = materiaxPensumDao.listarMateriasxPensum();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarAutores de la clase autorDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMateriaxpensum == null){
			throw new ExcepcionesLogica("No se encontraron Materiaxpensum en la tabla TbMicMateriaxpensum");
		}else{
			return listaMateriaxpensum;
		}
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.PensumDAO;
import com.udea.proint1.microcurriculo.dto.TbMicPensum;
import com.udea.proint1.microcurriculo.ngc.PensumNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PensumNGCImpl implements PensumNGC {

	private static Logger log=Logger.getLogger(PensumNGCImpl.class);

	PensumDAO pensumDao;
	
	public void setPensumDao(PensumDAO pensumDao) {
		this.pensumDao = pensumDao;
	}

	@Override
	public TbMicPensum obtenerPensum(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de pensum, está vacia");
		}
		TbMicPensum pensum = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			pensum = pensumDao.obtenerPensum(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPensum de la clase pensumDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(pensum == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró pensum con el id "+ id);
		}else{
			return pensum;
		}
	}

	@Override
	public void guardarPensum(TbMicPensum pensum) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(pensum == null){
			throw new ExcepcionesLogica("El objeto pensum está vacio");
		}
		try {
			int id = pensum.getNbIdpensum();
			TbMicPensum pensumConsulta = pensumDao.obtenerPensum(id);
		
			if(pensumConsulta != null){
				throw new ExcepcionesLogica("El pensum a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPensum de la clase pensumDao: "+ e);
		}
		
		try {
			
			pensumDao.guardarPensum(pensum);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarPensum de la clase pensumDao: "+ e);
		}
	}

	@Override
	public void actualizarPensum(TbMicPensum pensum) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(pensum == null){
			throw new ExcepcionesLogica("El objeto pensum está vacio");
		}
		try {
			int id = pensum.getNbIdpensum();
			TbMicPensum pensumConsulta = pensumDao.obtenerPensum(id);
		
			if(pensumConsulta == null){
				throw new ExcepcionesLogica("El pensum a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPensum de la clase pensumDao: "+ e);
		}
		
		try {
			
			pensumDao.actualizarPensum(pensum);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPensum de la clase pensumDao: "+ e);
		}
	}

	@Override
	public List<TbMicPensum> listarPensum() throws ExcepcionesLogica {
		List<TbMicPensum> listapensum = null;
		try {
			listapensum = pensumDao.listarPensum();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPensum de la clase pensumDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listapensum == null){
			throw new ExcepcionesLogica("No se encontraron pensums en la tabla TbMicPensum");
		}else{
			return listapensum;
		}
	}

}

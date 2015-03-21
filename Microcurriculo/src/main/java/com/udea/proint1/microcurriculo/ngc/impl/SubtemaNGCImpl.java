package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SubtemaDAO;
import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemaNGCImpl implements SubtemaNGC {
		
	private static Logger log=Logger.getLogger(SubtemaNGCImpl.class);
		
	SubtemaDAO subtemaDao;
	TemaDAO temaDao;
		
	public void setsubtemaDao(SubtemaDAO subtemaDao) {
		this.subtemaDao = subtemaDao;
	}
		
	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}

	@Override
	public TbMicSubtema obtenerSubtemas(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de subtema, está vacia");
		}
		TbMicSubtema subtema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			subtema = subtemaDao.obtenerSubtemas(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(subtema == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró subtema con el id "+ id);
		}else{
			return subtema;
		}
	}

	@Override
	public void guardarSubtemas(TbMicSubtema subtema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			throw new ExcepcionesLogica("El objeto subtema está vacio");
		}
		try {
			int id = subtema.getNbIdsubtema();
			TbMicSubtema subtemaConsulta = subtemaDao.obtenerSubtemas(id);
		
			if(subtemaConsulta != null){
				throw new ExcepcionesLogica("El subtemaConsulta a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemaDao: "+ e);
		}
		
		try {
			
			subtemaDao.guardarSubtema(subtema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarSubtema de la clase subtemaDao: "+ e);
		}
	}
	
	@Override
	public void actualizarSubtemas(TbMicSubtema subtema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			throw new ExcepcionesLogica("El objeto subtema está vacio");
		}
		try {
			int id = subtema.getNbIdsubtema();
			TbMicSubtema subtemaConsulta = subtemaDao.obtenerSubtemas(id);
		
			if(subtemaConsulta == null){
				throw new ExcepcionesLogica("El subtema a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemaDao: "+ e);
		}
		
		try {
			
			subtemaDao.modificarSubtema(subtema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarSubtema de la clase subtemaDao: "+ e);
		}
	}

	@Override
	public List<TbMicSubtema> listarSubtemas() throws ExcepcionesLogica {
		List<TbMicSubtema> listaSubtemas = null;
		try {
			listaSubtemas = subtemaDao.listarSubtemas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarSubtemas de la clase subtemaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaSubtemas == null){
			throw new ExcepcionesLogica("No se encontraron subtemas en la tabla TbMicSubtemas");
		}else{
			return listaSubtemas;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = subtemaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
////			throw new ExcepcionesLogica("Se presentaron errores al intentar obtener el numero de Registros de la tabla Subtemas.");
//			throw new ExcepcionesLogica(e);
//		}
//		
//		return registro;
//	}
	
	@Override
	public List<TbMicSubtema> listarSubtemasxTema(int idTema) throws ExcepcionesLogica{
		List<TbMicSubtema> listaSubtemas = null;
		
		TbMicTema tema= null;
		
		try {
			tema = temaDao.obtenerTema(idTema);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temaDao: "+ e);
		}
		
		
		try {
			listaSubtemas = subtemaDao.listarSubtemasxTema(tema);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarSubtemasxTema(tema) de la clase subtemaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaSubtemas;
	}

}

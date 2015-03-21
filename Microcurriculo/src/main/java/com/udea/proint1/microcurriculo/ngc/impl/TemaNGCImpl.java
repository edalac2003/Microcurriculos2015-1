package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
	
public class TemaNGCImpl implements TemaNGC {
		
	private static Logger log=Logger.getLogger(TemaNGCImpl.class);
		
	TemaDAO temaDao;

	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}
	
	@Override
	public TbMicTema obtenerTemas(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de Tema, está vacia");
		}
		TbMicTema tema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tema = temaDao.obtenerTema(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tema == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró tema con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return tema;
		}
	}

	@Override
	public void guardarTemas(TbMicTema tema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = tema.getNbIdtema();
			TbMicTema temasConsulta = temaDao.obtenerTema(id);
		
			if(temasConsulta != null){
				throw new ExcepcionesLogica("El tema a insertar ya existe");
			}		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temaDao: "+ e);
		}
		
		try {			
			temaDao.guardarTema(tema);		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarTema de la clase temaDao: "+ e);
		}
	}

	@Override
	public void actualizarTema(TbMicTema tema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			throw new ExcepcionesLogica("El objeto tema está vacio");
		}
		try {
			int id = tema.getNbIdtema();
			TbMicTema temaConsulta = temaDao.obtenerTema(id);
		
			if(temaConsulta == null){
				throw new ExcepcionesLogica("El tema a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temaDao: "+ e);
		}
		
		try {
			
			temaDao.modificarTema(tema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarTema de la clase temaDao: "+ e);
		}
	}

	@Override
	public List<TbMicTema> listarTemas() throws ExcepcionesLogica {
		List<TbMicTema> listaTemas = null;
		try {
			listaTemas = temaDao.listarTemas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTemas de la clase temaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTemas == null){
			throw new ExcepcionesLogica("No se encontraron temas en la tabla TbMicTemas");
		}else{
			return listaTemas;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = temaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Se produjo un Error al intentar Contar los Registros de Temas.");
//		}
//		
//		return registro;
//	}
	
	@Override
	public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesLogica{
		List<TbMicTema> listaTemas = null;
		
		try {
			listaTemas = temaDao.obtenerTemaxNombre(nombre);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemaxNombre(nombre) de la clase temaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaTemas;
	}

}

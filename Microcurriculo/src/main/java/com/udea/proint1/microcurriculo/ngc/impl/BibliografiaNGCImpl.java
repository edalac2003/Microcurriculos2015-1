package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BibliografiaNGCImpl implements BibliografiaNGC {
	
	private static Logger log=Logger.getLogger(BibliografiaNGCImpl.class);
	
	BibliografiaDAO bibliografiaDao;
	
	public void setBibliografiaDao(BibliografiaDAO bibliografiaDao) {
		this.bibliografiaDao = bibliografiaDao;
	}


	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(bibliografia == null){
			throw new ExcepcionesLogica("El objeto bibliografia est� vacio");
		}
		try {
			int id = bibliografia.getNbIdbibliografia();
			TbMicBibliografia bibliografiaConsulta = bibliografiaDao.obtenerBibliografia(id);
		
			if(bibliografiaConsulta != null){
				throw new ExcepcionesLogica("La bibliografia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerBibliografia de la clase bibliografiaDao: "+ e);
		}
		
		try {
			
			bibliografiaDao.guardarBibliografia(bibliografia);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarBibliografia de la clase bibliografiaDao: "+ e);
		}
	}

	@Override
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesLogica{
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de bibliografia, está vacia");
		}
		TbMicBibliografia bibliografia = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			bibliografia = bibliografiaDao.obtenerBibliografia(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBibliografia de la clase bibliografiaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(bibliografia == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró bibliografia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return bibliografia;
		}
	}
	
	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(bibliografia == null){
			throw new ExcepcionesLogica("El objeto bibliografia está vacio");
		}
		try {
			int id = bibliografia.getNbIdbibliografia();
			TbMicBibliografia bibliografiaConsulta = bibliografiaDao.obtenerBibliografia(id);
		
			if(bibliografiaConsulta == null){
				throw new ExcepcionesLogica("La bibliografia a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBibliografia de la clase bibliografiaDao: "+ e);
		}
		
		try {
			
			bibliografiaDao.modificarBibliografia(bibliografia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBibliografia de la clase bibliografiaDao: "+ e);
		}
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo)
			throws ExcepcionesLogica {
		List<TbMicBibliografia> listaBibliografias = null;
		try {
			listaBibliografias = bibliografiaDao.listarBibliografias();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarBibliografias de la clase bibliografiaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliografias == null){
			throw new ExcepcionesLogica("No se encontraron bibliografias en la tabla TbMicBibliografia");
		}else{
			return listaBibliografias;
		}
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(char tipo)
			throws ExcepcionesLogica {
		List<TbMicBibliografia> listaBibliografias = null;
		try {
			listaBibliografias = bibliografiaDao.listarBibliografiaxTipo(tipo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarBibliografias de la clase bibliografiaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliografias == null){
			throw new ExcepcionesLogica("No se encontraron bibliografias en la tabla TbMicBibliografia");
		}else{
			return listaBibliografias;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = bibliografiaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica();
//		}
//		
//		return registro;
//	}

	
}

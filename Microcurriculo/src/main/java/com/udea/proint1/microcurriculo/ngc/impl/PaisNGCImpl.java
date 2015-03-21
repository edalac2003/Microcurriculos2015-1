package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.PaisDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PaisNGCImpl implements PaisNGC {

	private static Logger log = Logger.getLogger(PaisNGCImpl.class);
	
	PaisDAO paisDao;
	
	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}

	public PaisNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmPais> listarPaises() throws ExcepcionesLogica {
		List<TbAdmPais> listaPaises = null;
		try {
			listaPaises = paisDao.listarPaises();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPaises de la clase paisDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if (listaPaises != null){
			return listaPaises;
		}else {
			throw new ExcepcionesLogica("No se encontraron paises en la tabla TbAdmPaises");
		}
	}

	@Override
	public TbAdmPais obtenerPais(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de país, está vacia");
		}
		TbAdmPais pais = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			pais = paisDao.obtenerPais(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPais de la clase paisDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(pais == null){
			throw new ExcepcionesLogica("No se encontró pais con el id "+ id);
		}else{
			return pais;
		}
	}

}

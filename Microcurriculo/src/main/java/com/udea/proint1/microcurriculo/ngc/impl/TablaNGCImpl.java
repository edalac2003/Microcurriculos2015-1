package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TablaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTabla;
import com.udea.proint1.microcurriculo.ngc.TablaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TablaNGCImpl implements TablaNGC {

	private static Logger log=Logger.getLogger(TablaNGCImpl.class);

	TablaDAO tablaDao;
	
	public void setTablaDao(TablaDAO tablaDao) {
		this.tablaDao = tablaDao;
	}

	@Override
	public TbAdmTabla obtenerTabla(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de tabla, está vacia");
		}
		TbAdmTabla tabla = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tabla = tablaDao.obtenerTabla(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTabla de la clase tablaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tabla == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró tabla con el id "+ id);
		}else{
			return tabla;
		}
	}

	@Override
	public void guardarTabla(TbAdmTabla tabla) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tabla == null){
			throw new ExcepcionesLogica("El objeto tabla está vacio");
		}
		try {
			int id = tabla.getNbIdtabla();
			TbAdmTabla tablaConsulta = tablaDao.obtenerTabla(id);
		
			if(tablaConsulta != null){
				throw new ExcepcionesLogica("La tabla a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTabla de la clase tablaDao: "+ e);
		}
		
		try {
			
			tablaDao.guardarTabla(tabla);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarTabla de la clase tablaDao: "+ e);
		}
	}

	@Override
	public void actualizarTabla(TbAdmTabla tabla) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tabla == null){
			throw new ExcepcionesLogica("El objeto tabla está vacio");
		}
		try {
			int id = tabla.getNbIdtabla();
			TbAdmTabla tablaConsulta = tablaDao.obtenerTabla(id);
		
			if(tablaConsulta == null){
				throw new ExcepcionesLogica("La tabla a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutores de la clase tablaDao: "+ e);
		}
		
		try {
			
			tablaDao.actualizarTabla(tabla);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAutor de la clase tablaDao: "+ e);
		}
	}

	@Override
	public List<TbAdmTabla> listarTabla() throws ExcepcionesLogica {
		List<TbAdmTabla> listaTabla = null;
		try {
			listaTabla = tablaDao.listarTabla();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTabla de la clase tablaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTabla == null){
			throw new ExcepcionesLogica("No se encontraron Tablas en la tabla TbAdmTabla");
		}else{
			return listaTabla;
		}
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EstadoNGCImpl implements EstadoNGC {

	private static Logger log = Logger.getLogger(EstadoNGCImpl.class);
	
	EstadoDAO estadoDao;
	
	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}

	public EstadoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicEstado obtenerEstados(int idEstado) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(idEstado == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de estado, está vacia");
		}
		TbMicEstado estado = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			estado = estadoDao.obtenerEstado(idEstado);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEstado de la clase estadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(estado == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró estado con el id "+ idEstado);
		}else{
			//si no esta vacio retorna la ciudad
			return estado;
		}
	}

	@Override
	public void guardarEstados(TbMicEstado estado) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(estado == null){
			throw new ExcepcionesLogica("El objeto estado est� vacio");
		}
		try {
			int id = estado.getNbIdestado();
			TbMicEstado estadoConsulta = estadoDao.obtenerEstado(id);
		
			if(estadoConsulta != null){
				throw new ExcepcionesLogica("El estado a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerEstado de la clase estadoDao: "+ e);
		}
		
		try {
			
			estadoDao.guardarEstado(estado);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarEstado de la clase estadoDao: "+ e);
		}
	}

	@Override
	public void actualizarEstados(TbMicEstado estado) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(estado == null){
			throw new ExcepcionesLogica("El objeto estado está vacio");
		}
		try {
			int id = estado.getNbIdestado();
			TbMicEstado estadoConsulta = estadoDao.obtenerEstado(id);
		
			if(estadoConsulta == null){
				throw new ExcepcionesLogica("La Bibliografia x Unidad a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
		
		try {
			
			estadoDao.actualizarEstado(estado);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
		}
	}

	@Override
	public List<TbMicEstado> listarEstados() throws ExcepcionesLogica {
		List<TbMicEstado> listaEstados = null;
		try {
			listaEstados = estadoDao.listarEstados();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarEstados de la clase estadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEstados == null){
			throw new ExcepcionesLogica("No se encontraron estados en la tabla TbMicEstados");
		}else{
			return listaEstados;
		}
	}
	
	@Override
	public List<TbMicEstado> obtenerEstadoxNombre(String nombre) throws ExcepcionesLogica{
		List<TbMicEstado> listaEstados = null;
		
		try {
			listaEstados = estadoDao.obtenerEstadoxNombre(nombre);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listadoBiblioxUnidad(TbMicUnidades) de la clase biblioxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaEstados;
	}

}

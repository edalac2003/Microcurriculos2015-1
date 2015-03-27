package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.ActaxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicActaxmicro;
import com.udea.proint1.microcurriculo.ngc.ActaxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ActaxMicroNGCImpl implements ActaxMicroNGC {

	ActaxMicroDAO actaxMicroDao; 
	
	public void setActaxMicroDao(ActaxMicroDAO actaxMicroDao) {
		this.actaxMicroDao = actaxMicroDao;
	}

	private static Logger log=Logger.getLogger(ActaxMicroNGCImpl.class);

	@Override
	public TbMicActaxmicro obtenerActaxmicro(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de actaxMicro, está vacia");
		}
		TbMicActaxmicro actaxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			actaxMicro = actaxMicroDao.obtenerActaxMicro(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error validando persona");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(actaxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró actaxMicro con el id "+ id);
		}else{
			return actaxMicro;
		}
	}

	@Override
	public void guardarActaxmicro(TbMicActaxmicro actaxmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(actaxmicro == null){
			throw new ExcepcionesLogica("El objeto actaxmicro está vacio");
		}
		try {
			int id = actaxmicro.getNbIdactas();
			TbMicActaxmicro actaxMicroConsulta = actaxMicroDao.obtenerActaxMicro(id);
		
			if(actaxMicroConsulta != null){
				throw new ExcepcionesLogica("La actaxmicro a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerActaxMicro de la clase actaxMicroDao: "+ e);
		}
		
		try {
			
			actaxMicroDao.guardarActaxMicro(actaxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarActaxMicro de la clase actaxMicroDao: "+ e);
		}
	}

	@Override
	public void actualizarActaxmicro(TbMicActaxmicro actaxmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(actaxmicro == null){
			throw new ExcepcionesLogica("El objeto actaxmicro está vacio");
		}
		try {
			int id = actaxmicro.getNbIdactas();
			TbMicActaxmicro actaxmicroConsulta = actaxMicroDao.obtenerActaxMicro(id);
		
			if(actaxmicroConsulta == null){
				throw new ExcepcionesLogica("La actaxmicro a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerActaxMicro de la clase actaxMicroDao: "+ e);
		}
		
		try {
			
			actaxMicroDao.actualizarActaxMicro(actaxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarActaxMicro de la clase actaxMicroDao: "+ e);
		}
	}

	@Override
	public List<TbMicActaxmicro> listarActaxmicro() throws ExcepcionesLogica {
		List<TbMicActaxmicro> listaActaxmicro = null;
		try {
			listaActaxmicro = actaxMicroDao.listarActaxMicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarActaxMicro de la clase actaxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaActaxmicro == null){
			throw new ExcepcionesLogica("No se encontraron Actaxmicro en la tabla TbMicActaxmicro");
		}else{
			return listaActaxmicro;
		}
	}

}

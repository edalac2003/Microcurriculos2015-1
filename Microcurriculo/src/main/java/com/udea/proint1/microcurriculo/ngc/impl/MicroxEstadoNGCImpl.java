package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EstadoDAO;
import com.udea.proint1.microcurriculo.dao.MicroxEstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicroxEstadoNGCImpl implements MicroxEstadoNGC {

	private static Logger log=Logger.getLogger(PersonaNGCImpl.class);
	
	MicroxEstadoDAO microxEstadoDao;
	EstadoDAO estadoDao;
	
	public void setmicroxEstadoDao(MicroxEstadoDAO microxEstadoDao) {
		this.microxEstadoDao = microxEstadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}
	
	@Override
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		TbMicMicroxestado microxEstadoConsulta = null;
		
		if(microxEstado != null){
			try {
				microxEstadoConsulta = microxEstadoDao.obtenerMicroxestado(microxEstado.getNbId());
			} catch (ExcepcionesDAO e1) {
				throw new ExcepcionesLogica();
			}
			
			if(microxEstadoConsulta == null){
				
				try {
					microxEstadoDao.guardarMicroxestado(microxEstado);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica();
				}
				
			} else {
				throw new ExcepcionesLogica("El Registro que desea guardar ya existe en la Base de Datos.");
			}
		} else {
			throw new ExcepcionesLogica("El registro que desea ingresar no contiene informaci�n v�lida.");
		}
	}

	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microxEstado == null){
			throw new ExcepcionesLogica("El objeto microxEstado está vacio");
		}
		try {
			int id = microxEstado.getNbId();
			TbMicMicroxestado microxEstadoConsulta = microxEstadoDao.obtenerMicroxestado(id);
		
			if(microxEstadoConsulta == null){
				throw new ExcepcionesLogica("El micro x estado a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxestado de la clase microxEstadoDao: "+ e);
		}
		
		try {
			
			microxEstadoDao.actualizarMicroxestado(microxEstado);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarMicroxestado de la clase microxEstadoDao: "+ e);
		}
	}

	@Override
	public TbMicMicroxestado obtenerMicroxestado(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de microxEstado, está vacia");
		}
		TbMicMicroxestado microxEstado = null;
		
		try {
			microxEstado = microxEstadoDao.obtenerMicroxestado(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxestado de la clase microxEstadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(microxEstado == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró microxEstado con el id "+ id);
		}else{
			return microxEstado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicroxestado()
			throws ExcepcionesLogica {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		try {
			listaMicrosxestado = microxEstadoDao.listarMicroxestado();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicroxestado de la clase microxEstadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			throw new ExcepcionesLogica("No se encontraron Micros x Estado en la tabla TbMicMicroxestado");
		}else{
			return listaMicrosxestado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicrosxestado(int idEstado)
			throws ExcepcionesLogica {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		
		TbMicEstado estado = null;
		
		try {
			estado = estadoDao.obtenerEstado(idEstado);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEstado de la clase estadoDao: "+ e);
		}
		
		try {
			listaMicrosxestado = microxEstadoDao.listarMicrosxestado(estado);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrosxestado de la clase microxEstadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			throw new ExcepcionesLogica("No se encontraron Micros x estado de tipo estado en la tabla TbMicMicroxestado");
		}else{
			return listaMicrosxestado;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;		
//		try {
//			registro = microxEstadoDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Ocurri� un error al contar los registros de MicroxEstado.");
//		}
//		
//		return registro;
//	}
//	
	

}

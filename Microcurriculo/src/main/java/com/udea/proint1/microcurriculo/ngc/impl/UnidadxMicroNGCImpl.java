package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.UnidadXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadxMicroNGCImpl  implements UnidadxMicroNGC {
	
	private static Logger log=Logger.getLogger(UnidadxMicroNGCImpl.class);
	
	UnidadXMicroDAO unidadxMicroDao;
	
	MicrocurriculoDAO microcurriculoDao;
	
	public void setUnidadxMicroDao(UnidadXMicroDAO unidadxMicroDao) {
		this.unidadxMicroDao = unidadxMicroDao;
	}

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidadXmicro == null){
			throw new ExcepcionesLogica("El objeto unidadXmicro est� vacio");
		}
		try {
			int id = unidadXmicro.getNbId();
			TbMicUnidadxmicro unidadXmicroConsulta = unidadxMicroDao.obtenerUnidadXmicro(id);
		
			if(unidadXmicroConsulta != null){
				throw new ExcepcionesLogica("La Unidad x Microcurriculo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUnidadXmicro de la clase unidadxMicroDao: "+ e);
		}
		
		try {
			
			unidadxMicroDao.guardarUnidadXmicro(unidadXmicro);;
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUnidadXmicro de la clase unidadxMicroDao: "+ e);
		}
	}

	
	/*@Override
	public void guardarUnidadXmicro(List<TbMicUnidadesxmicro> listaUnidadxMicro) throws ExcepcionesLogica {
		if(listaUnidadxMicro != null){
			for(TbMicUnidadesxmicro uxM : listaUnidadxMicro){
				guardarUnidadXmicro(uxM);
			}
		}else{
			throw new ExcepcionesLogica();
		}		
	}*/

	@Override
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidadXmicro == null){
			throw new ExcepcionesLogica("El objeto unidadXmicro está vacio");
		}
		try {
			int id = unidadXmicro.getNbId();
			TbMicUnidadxmicro unidadXmicroConsulta = unidadxMicroDao.obtenerUnidadXmicro(id);
		
			if(unidadXmicroConsulta == null){
				throw new ExcepcionesLogica("La unidad x micro actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidadXmicro de la clase unidadxMicroDao: "+ e);
		}
		
		try {
			
			unidadxMicroDao.modificarUnidadXmicro(unidadXmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarUnidadXmicro de la clase unidadxMicroDao: "+ e);
		}
	}

	@Override
	public TbMicUnidadxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de unidadxmicro, está vacia");
		}
		TbMicUnidadxmicro unidadXmicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidadXmicro = unidadxMicroDao.obtenerUnidadXmicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidadXmicro de la clase unidadxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidadXmicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Unidad x Micro con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return unidadXmicro;
		}
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		List<TbMicUnidadxmicro> listaUnidadesxMicro = null;
		
		TbMicMicrocurriculo microcurriculo= null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculoDao: "+ e);
		}
		
		
		try {
			listaUnidadesxMicro = unidadxMicroDao.listarUnidadesXMicroxMicro(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidadesXMicroxMicro de la clase unidadxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaUnidadesxMicro;
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXmicro()
			throws ExcepcionesLogica {
		List<TbMicUnidadxmicro> listaUnidadesxMicro = null;
		try {
			listaUnidadesxMicro = unidadxMicroDao.listarUnidadesXmicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidadesXmicro de la clase unidadxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidadesxMicro == null){
			throw new ExcepcionesLogica("No se encontraron UnidadesxMicro en la tabla TbMicUnidadesxmicro");
		}else{
			return listaUnidadesxMicro;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = unidadxMicroDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("Se produjeron Errores al Obtener el numero de Registros de la Tabla Unidades x Microcurriculo.");
//		}
//				
//		return registro;
//	}
	
}

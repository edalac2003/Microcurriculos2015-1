package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivoDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivoxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivoxMicroNGCImpl implements ObjetivoxMicroNGC {

	private static Logger log=Logger.getLogger(ObjetivoxMicroNGC.class);
	
	ObjetivoxMicroDAO objetivoxMicroDao;
	
	MicrocurriculoDAO microcurriculoDao;
	
	ObjetivoDAO objetivoDao;
		
	public void setObjetivoxMicroDao(ObjetivoxMicroDAO objetivoxMicroDao) {
		this.objetivoxMicroDao = objetivoxMicroDao;
	}

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	public void setObjetivoDao(ObjetivoDAO objetivoDao) {
		this.objetivoDao = objetivoDao;
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro)	throws ExcepcionesLogica {
		TbMicObjetivoxmicro objetivosxMicroTMP = null;
		
		if(objetivoxMicro != null){
			try {
				objetivosxMicroTMP = objetivoxMicroDao.obtenerObjetivoxMicro(objetivoxMicro.getNbId());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar obtener el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El Objeto <ObjetivoxMicro> est� vacio.");
		}
		
		if(objetivosxMicroTMP == null){
			try {
				objetivoxMicroDao.guardarObjetivosxMicro(objetivoxMicro);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar guardar el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El objeto <ObjetivoxMicro> ya Existe.");
		}
	}

	/*@Override
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesLogica {
		if (listaObjetivoxMicro != null){
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivoxMicro){
				guardarObjetivosxMicro(objetivoxMicro);				
			}
		}else{
			throw new ExcepcionesLogica("El objeto <Lista ObjetivoxMicrocurriculo no tiene informaci�n v�lida.");
		}
	}*/

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro)throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivoxMicro == null){
			throw new ExcepcionesLogica("El objeto objetivoxMicro está vacio");
		}
		try {
			int id = objetivoxMicro.getNbId();
			TbMicObjetivoxmicro biblioxUnidadConsulta = objetivoxMicroDao.obtenerObjetivoxMicro(id);
		
			if(biblioxUnidadConsulta == null){
				throw new ExcepcionesLogica("El Objetivo x micro a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivoxMicro de la clase objetivoxMicroDao: "+ e);
		}
		
		try {
			
			objetivoxMicroDao.modificarObjetivoxMicro(objetivoxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarObjetivoxMicro de la clase objetivoxMicroDao: "+ e);
		}
	}

	@Override
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de objetivosxMicro, está vacia");
		}
		TbMicObjetivoxmicro objetivosxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivosxMicro = objetivoxMicroDao.obtenerObjetivoxMicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivoxMicro de la clase objetivoxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivosxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Objetivos x Micro con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return objetivosxMicro;
		}
	}
	
	@Override
	public TbMicObjetivoxmicro obtenerObjetivosxMicroxObjetivo(int idObjetivo) throws ExcepcionesLogica {
		TbMicObjetivoxmicro objetivoxMicro = null;
		
		try {
			objetivoxMicro = objetivoxMicroDao.obtenerObjetivoxMicro(idObjetivo);
			if (objetivoxMicro != null)
				return objetivoxMicro;
			else
				return null;
			
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Error al intentar objetener el Objeto <ObjetivoxMicrocurriculo>");
		}
		
	}

	@Override
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro()
			throws ExcepcionesLogica {
		List<TbMicObjetivoxmicro> listaObjetivosxMicro = null;
		try {
			listaObjetivosxMicro = objetivoxMicroDao.listarObjetivosxMicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosxMicro de la clase objetivoxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivosxMicro == null){
			throw new ExcepcionesLogica("No se encontraron objetivos x microcurriculos en la tabla TbMicObjetivosxmicro");
		}else{
			return listaObjetivosxMicro;
		}
	}

	@Override
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		List<TbMicObjetivoxmicro> listaObjetivosxMicro = null;
		
		TbMicMicrocurriculo microcurriculo= null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculoDao: "+ e);
		}
		
		
		try {
			listaObjetivosxMicro = objetivoxMicroDao.obtenerObjetivosxMicroxMicro(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivosxMicroxMicro de la clase objetivoxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivosxMicro;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = objetivoxMicroDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("Se presentaron error al Obtener el numero de Registros de la Tabla Objetivos x Microcurriculo.");
//		}		
//		
//		return registro;
//	}

}

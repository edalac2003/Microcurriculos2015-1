package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.ngc.ObjetivoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivoNGCImpl implements ObjetivoNGC {

	private static Logger log=Logger.getLogger(ObjetivoNGCImpl.class);
	
	ObjetivoDAO objetivoDao;
	
	MicrocurriculoDAO microcurriculoDao;
	
	public void setObjetivoDao(ObjetivoDAO objetivoDao) {
		this.objetivoDao = objetivoDao;
	}

	public void setmicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	@Override
	public TbMicObjetivo obtenerObjetivo(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de objetivo, está vacia");
		}
		TbMicObjetivo objetivo = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivo = objetivoDao.obtenerObjetivo(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivo de la clase objetivoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró objetivo con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return objetivo;
		}
	}

	@Override
	public void guardarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesLogica {
		TbMicObjetivo objetivosTMP = null;
		
		if (objetivo != null){
			
			try {
				objetivosTMP = objetivoDao.obtenerObjetivo(objetivo.getNbIdobjetivo());		
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("No fue posible comprobar la existencia del Obejtivo.");
			}
			if (objetivosTMP == null){
				try {
					objetivoDao.guardarObjetivo(objetivo);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica("Se presentaron problemas al momento de intentar Guardar el registor <OBJETIVO>");
				}
			}else {
				throw new ExcepcionesLogica("El objeto de tipo <Objetivo> ya se Encuentra en la Base de Datos.");
			}
		} else {
			throw new ExcepcionesLogica("EL Objeto <Objetivo> est� vacio.");
		}
	}

/*		
	@Override
	public void guardarObjetivos(List<TbMicObjetivos> listaObjetivo) throws ExcepcionesLogica {
		if (listaObjetivo != null){
			for(TbMicObjetivos objetivo:listaObjetivo){
				guardarObjetivos(objetivo);
			}
		} else{
			throw new ExcepcionesLogica("El objeto <Lista Objetivos> no tiene informaci�n v�lida.");
		}
	}
*/
	
	@Override
	public void actualizarObjetivos(TbMicObjetivo objetivo)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivo == null){
			throw new ExcepcionesLogica("El objeto objetivo está vacio");
		}
		try {
			int id = objetivo.getNbIdobjetivo();
			TbMicObjetivo objetivoConsulta = objetivoDao.obtenerObjetivo(id);
		
			if(objetivoConsulta == null){
				throw new ExcepcionesLogica("El Objetivo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivo de la clase objetivoDao: "+ e);
		}
		
		try {
			
			objetivoDao.modificarObjetivo(objetivo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarObjetivo de la clase objetivoDao: "+ e);
		}
	}

	@Override
	public List<TbMicObjetivo> listarObjetivos() throws ExcepcionesLogica {
		List<TbMicObjetivo> listaObjetivos = null;
		try {
			listaObjetivos = objetivoDao.listarObjetivos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivos de la clase objetivoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivos == null){
			throw new ExcepcionesLogica("No se encontraron objetivos en la tabla TbMicObjetivos");
		}else{
			return listaObjetivos;
		}
	}

//	@Override
//	public int numeroRegistros() throws ExcepcionesLogica {
//		int numeroRegistro = 0;
//		try {
//			numeroRegistro = objetivoDao.numeroRegistros();
//		} catch (ExcepcionesDAO e) {
//			e.printStackTrace();
//		}
//		
//		return numeroRegistro;
//	}

	@Override
	public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica{
		List<TbMicObjetivo> listaObjetivos = null;
		
		TbMicMicrocurriculo microcurriculo = null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculoDao: "+ e);
		}
		
		try {
			listaObjetivos = objetivoDao.listarObjetivosPorMicrocurriculo(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosPorMicrocurriculo(TbMicMicrocurriculos) de la clase objetivoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
	@Override
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica{
		List<TbMicObjetivo> listaObjetivos = null;
		
		try {
			listaObjetivos = objetivoDao.listarObjetivosPorTipo(tipo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosPorTipo(char tipo) de la clase objetivoDao: "+ e);
		}
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
}

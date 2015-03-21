package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dao.TemaxUnidadDAO;
import com.udea.proint1.microcurriculo.dao.UnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemaxUnidadNGCImpl implements TemaxUnidadNGC {
	
	private static Logger log=Logger.getLogger(TemaxUnidadNGCImpl.class);
	
	TemaxUnidadDAO temaxUnidadDao;
	UnidadDAO unidadDao;	
	TemaDAO temaDao;

	
	public void settemaxUnidadDao(TemaxUnidadDAO temaxUnidadDao) {
		this.temaxUnidadDao = temaxUnidadDao;
	}

	public void setUnidadDao(UnidadDAO unidadDao) {
		this.unidadDao = unidadDao;
	}

	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}

	
	@Override
	public TbMicTemaxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de temaxunidad, está vacia");
		}
		TbMicTemaxunidad temaxUnidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			temaxUnidad = temaxUnidadDao.obtenerTemaXunidad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemaXunidad de la clase temaxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(temaxUnidad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Tema x Unidad con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return temaxUnidad;
		}
	}

	@Override
	public void guardarTemasxUnidad(TbMicTemaxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		TbMicTemaxunidad temaxUnidadTmp = null;
		if (temasxunidad != null){
			try {
				temaxUnidadTmp = temaxUnidadDao.obtenerTemaXunidad(temasxunidad.getNbId());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}			
		}else{
			throw new ExcepcionesLogica();
		}
		
		if(temaxUnidadTmp == null){
			try {
				temaxUnidadDao.guardarTemasXUnidad(temasxunidad);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}
		}else{
			throw new ExcepcionesLogica();
		}
	}
	
  /*@Override
	public void guardarTemasxUnidad(List<TbMicTemasxunidad> listaTemasxUnidad) throws ExcepcionesLogica {
		if (listaTemasxUnidad != null){
			for(TbMicTemasxunidad txU : listaTemasxUnidad)
				guardarTemasxUnidad(txU);
		}
		
	}*/

	@Override
	public void actualizarTemaxUnidad(TbMicTemaxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad está vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbAdmPrerrequisitos temasxunidadConsulta = temaxUnidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemasxunidad de la clase temaxUnidadDao: "+ e);
		}
		
		try {
			
			temaxUnidadDao.actualizarTemasxunidad(temasxunidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarTemasxunidad de la clase temaxUnidadDao: "+ e);
		}*/
	}

	

	@Override
	public List<TbMicTemaxunidad> listarTemasxUnidad()
			throws ExcepcionesLogica {
		List<TbMicTemaxunidad> listatemasxunidad = null;
		try {
			listatemasxunidad = temaxUnidadDao.ListarTemasXunidad();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo ListarTemasXunidad de la clase temaxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listatemasxunidad == null){
			throw new ExcepcionesLogica("No se encontraron temas x unidad en la tabla TbMicTemasxunidad");
		}else{
			return listatemasxunidad;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = temaxUnidadDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			//throw new ExcepcionesLogica("Se presentaron problemas al intentar obtener el numero de registros de la tabla <TB_MIC_TEMASXUNIDAD>.");
//			throw new ExcepcionesLogica(e);
//		}
//		
//		return registro;
//	}
	
	public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(int idUnidad) throws ExcepcionesLogica{
		List<TbMicTemaxunidad> listaTemasxUnidad = null;
		
		TbMicUnidad unidad= null;
		
		try {
			unidad = unidadDao.obtenerUnidad(idUnidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
		}
		
		
		try {
			listaTemasxUnidad = temaxUnidadDao.ListarTemasxUnidadxUnidad(unidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo ListarTemasxUnidadxUnidad(TbMicUnidades) de la clase temaxUnidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaTemasxUnidad;
	}

}

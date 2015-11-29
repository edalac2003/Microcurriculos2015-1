package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
import com.udea.proint1.microcurriculo.dao.UnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BiblioxUnidadNGCImpl implements BiblioxunidadNGC{

	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(BiblioxUnidadNGCImpl.class);
	
	BiblioxUnidadDAO biblioxUnidadDao;
	
	UnidadDAO unidadDao;
	
	public void setBiblioxUnidadDao(BiblioxUnidadDAO biblioxUnidadDao) {
		this.biblioxUnidadDao = biblioxUnidadDao;
	}

	public void setUnidadDao(UnidadDAO unidadDao) {
		this.unidadDao = unidadDao;
	}

	public BiblioxUnidadNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(biblioxUnidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Bibliografia x Unidad esta vacio");
			throw expLog;
		}
//		try {
//			int id = biblioxUnidad.getNbId();
//			TbMicBiblioxunidad biblioxUnidadConsulta = biblioxUnidadDao.obtenerBiblioxUnidad(id);
//		
//			if(biblioxUnidadConsulta != null){
//				throw new ExcepcionesLogica("La Bibliografia x Unidad a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("fall� al invocar el metodo obtenerBiblioxUnidad de la clase biblioxUnidadDao: "+ e);
//		}
		
		try {
			
			biblioxUnidadDao.guardarBiblioxUnidad(biblioxUnidad);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Bibliografia x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(biblioxUnidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Bibliografia esta vacio");
			throw expLog;
		}
		try {
			int id = biblioxUnidad.getNbId();
			TbMicBiblioxunidad biblioxUnidadConsulta = biblioxUnidadDao.obtenerBiblioxUnidad(id);
		
			if(biblioxUnidadConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Bibliografia x Unidad a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Bibliografia x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			biblioxUnidadDao.modificarBiblioxUnidad(biblioxUnidad);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Bibliografia x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Bibliografia x Unidad, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicBiblioxunidad bibliosxUnidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			bibliosxUnidad = biblioxUnidadDao.obtenerBiblioxUnidad(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Bibliografia x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(bibliosxUnidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Bibliografia x Unidad con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return bibliosxUnidad;
		}
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicBiblioxunidad> listaBibliosxUnidad = null;
		try {
			listaBibliosxUnidad = biblioxUnidadDao.listadoBiblioxUnidad();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Bibliografias x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliosxUnidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Bibliografias x Unidad");
			throw expLog;
		}else{
			return listaBibliosxUnidad;
		}
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad)
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicBiblioxunidad> listaBibliosxUnidad = null;
		
		TbMicUnidad unidad= null;
		
		try {
			unidad = unidadDao.obtenerUnidad(idUnidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Bibliografias x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaBibliosxUnidad = biblioxUnidadDao.listadoBiblioxUnidad(unidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Bibliografias x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaBibliosxUnidad;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = biblioxUnidadDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica();
//		}
//		
//		return registro;
//	}
	
	@Override
	public void eliminarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			biblioxUnidadDao.eliminarBiblioxunidad(biblioxUnidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Bibliografia x Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}

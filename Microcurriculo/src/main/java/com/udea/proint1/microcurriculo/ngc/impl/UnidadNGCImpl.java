package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
//import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadNGCImpl  implements UnidadNGC {
	
@SuppressWarnings("unused")
private static Logger log = Logger.getLogger(UnidadNGCImpl.class);
	
	UnidadDAO unidadDao;
	
	public void setunidadDao(UnidadDAO unidadDao) {
		this.unidadDao = unidadDao;
	}

	
	@Override
	public void guardarUnidades(TbMicUnidad unidad)  throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto unidad esta vacio");
			throw expLog;
		}
//		try {
//			int id = unidad.getNbIdunidad();
//			TbMicUnidad unidadConsulta = unidadDao.obtenerUnidad(id);
//		
//			if(unidadConsulta != null){
//				throw new ExcepcionesLogica("La Unidad a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("fall� al invocar el metodo obtenerUnidad de la clase unidadDao: "+ e);
//		}
		
		try {
			
			unidadDao.guardarUnidad(unidad);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicUnidad obtenerUnidades(int idUnidad)  throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(idUnidad == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Unidad, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicUnidad unidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidad = unidadDao.obtenerUnidad(idUnidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró unidad con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return unidad;
		}
	}

	@Override
	public void actualizarUnidades(TbMicUnidad unidad)  throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidad == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto unidad esta vacio");
			throw expLog;
		}
		try {
			int id = unidad.getNbIdunidad();
			TbMicUnidad unidadConsulta = unidadDao.obtenerUnidad(id);
		
			if(unidadConsulta == null){
				throw new ExcepcionesLogica("La Unidad a actualizar no existe");
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			unidadDao.modificarUnidad(unidad);
		
		}catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicUnidad> listarUnidades()  throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicUnidad> listaUnidades = null;
		try {
			listaUnidades = unidadDao.listarUnidades();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Unidades");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidades == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de unidades");
			throw expLog;
		}else{
			return listaUnidades;
		}
	}

	
//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		try {
//			registro = unidadDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("Se produjo un Error al Contar los Registros de la Tabla Unidades.");
//		}
//		
//		return registro;
//	}
	
	@Override
	public void eliminarUnidad(TbMicUnidad unidad) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			unidadDao.eliminarUnidad(unidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Unidad");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
}

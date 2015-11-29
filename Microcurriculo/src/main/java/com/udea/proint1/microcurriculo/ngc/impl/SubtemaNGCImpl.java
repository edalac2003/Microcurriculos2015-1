package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SubtemaDAO;
import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
//import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemaNGCImpl implements SubtemaNGC {
		
	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(SubtemaNGCImpl.class);
		
	SubtemaDAO subtemaDao;
	TemaDAO temaDao;
		
	public void setsubtemaDao(SubtemaDAO subtemaDao) {
		this.subtemaDao = subtemaDao;
	}
		
	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}

	@Override
	public TbMicSubtema obtenerSubtemas(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Subtema, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicSubtema subtema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			subtema = subtemaDao.obtenerSubtemas(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(subtema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Subtema con Id");
			throw expLog;
		}else{
			return subtema;
		}
	}

	@Override
	public void guardarSubtemas(TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Subtema esta vacio");
			throw expLog;
		}
//		try {
//			int id = subtema.getNbIdsubtema();
//			TbMicSubtema subtemaConsulta = subtemaDao.obtenerSubtemas(id);
//		
//			if(subtemaConsulta != null){
//				throw new ExcepcionesLogica("El subtemaConsulta a insertar ya existe");
//			}
//		
//		} catch(ExcepcionesDAO expDAO){
//			throw expDAO;
//		} catch(Exception exp){
//			ExcepcionesLogica expLog = new ExcepcionesLogica();
//			expLog.setMsjUsuario("Error al invocar el metodo obtener Subtema");
//			expLog.setMsjTecnico(exp.getMessage());
//			expLog.setOrigen(exp);
//			throw expLog;
//		}
		
		try {
			
			subtemaDao.guardarSubtema(subtema);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
	@Override
	public void actualizarSubtemas(TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Subtema esta vacio");
			throw expLog;
		}
		try {
			int id = subtema.getNbIdsubtema();
			TbMicSubtema subtemaConsulta = subtemaDao.obtenerSubtemas(id);
		
			if(subtemaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("El Subtema a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			subtemaDao.modificarSubtema(subtema);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicSubtema> listarSubtemas() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicSubtema> listaSubtemas = null;
		try {
			listaSubtemas = subtemaDao.listarSubtemas();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaSubtemas == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Subtemas");
			throw expLog;
		}else{
			return listaSubtemas;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
//		int registro = 0;
//		
//		try {
//			registro = subtemaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
////			throw new ExcepcionesLogica("Se presentaron errores al intentar obtener el numero de Registros de la tabla Subtemas.");
//			throw new ExcepcionesLogica(e);
//		}
//		
//		return registro;
//	}
	
	@Override
	public List<TbMicSubtema> listarSubtemasxTema(int idTema) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicSubtema> listaSubtemas = null;
		
		TbMicTema tema= null;
		
		try {
			tema = temaDao.obtenerTema(idTema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaSubtemas = subtemaDao.listarSubtemasxTema(tema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaSubtemas;
	}
	
	@Override
	public void eliminarSubtema(TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			subtemaDao.eliminarSubtema(subtema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Subtema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}

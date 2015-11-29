package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
	
public class TemaNGCImpl implements TemaNGC {
		
	private static Logger log=Logger.getLogger(TemaNGCImpl.class);
		
	TemaDAO temaDao;

	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}
	
	@Override
	public TbMicTema obtenerTemas(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Tema, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicTema tema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tema = temaDao.obtenerTema(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontro Tema con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return tema;
		}
	}

	@Override
	public void guardarTemas(TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Tema esta vacio");
			throw expLog;
		}
//		try {
//			int id = tema.getNbIdtema();
//			TbMicTema temasConsulta = temaDao.obtenerTema(id);
//		
//			if(temasConsulta != null){
//				throw new ExcepcionesLogica("El tema a insertar ya existe");
//			}		
//		} catch(ExcepcionesDAO expDAO){
//			throw expDAO;
//		} catch(Exception exp){
//			ExcepcionesLogica expLog = new ExcepcionesLogica();
//			expLog.setMsjUsuario("Error al invocar el metodo obtener Tema");
//			expLog.setMsjTecnico(exp.getMessage());
//			expLog.setOrigen(exp);
//			throw expLog;
//		}
		
		try {			
			temaDao.guardarTema(tema);		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarTema(TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Tema esta vacio");
			throw expLog;
		}
		try {
			int id = tema.getNbIdtema();
			TbMicTema temaConsulta = temaDao.obtenerTema(id);
		
			if(temaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Tema a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			temaDao.modificarTema(tema);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicTema> listarTemas() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicTema> listaTemas = null;
		try {
			listaTemas = temaDao.listarTemas();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Temas");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTemas == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Temas");
			throw expLog;
		}else{
			return listaTemas;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
//		int registro = 0;
//		
//		try {
//			registro = temaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Se produjo un Error al intentar Contar los Registros de Temas.");
//		}
//		
//		return registro;
//	}
	
	@Override
	public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicTema> listaTemas = null;
		
		try {
			listaTemas = temaDao.obtenerTemaxNombre(nombre);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo buscar Temas");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaTemas;
	}
	
	@Override
	public void eliminarTema(TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			temaDao.eliminarTema(tema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EstadoDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicroxEstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicroxEstadoNGCImpl implements MicroxEstadoNGC {

	private static Logger log=Logger.getLogger(PersonaNGCImpl.class);
	
	MicroxEstadoDAO microxEstadoDao;
	EstadoDAO estadoDao;
	MicrocurriculoDAO microcurriculoDao;
	
	public void setmicroxEstadoDao(MicroxEstadoDAO microxEstadoDao) {
		this.microxEstadoDao = microxEstadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	@Override
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		TbMicMicroxestado microxEstadoConsulta = null;
		
		if(microxEstado != null){
			try {
				microxEstadoConsulta = microxEstadoDao.obtenerMicroxestado(microxEstado.getNbId());
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo x Estado");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
			
			if(microxEstadoConsulta == null){
				
				try {
					microxEstadoDao.guardarMicroxestado(microxEstado);
				} catch(ExcepcionesDAO expDAO){
					throw expDAO;
				} catch(Exception exp){
					ExcepcionesLogica expLog = new ExcepcionesLogica();
					expLog.setMsjUsuario("Error al invocar el metodo guardar Microcurriculo x Estado");
					expLog.setMsjTecnico(exp.getMessage());
					expLog.setOrigen(exp);
					throw expLog;
				}
				
			} else {
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo guardar, El objeto Microcurriculo x Estado ya existe");
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Microcurriculo x Estado esta vacio");
			throw expLog;
		}
	}

	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microxEstado == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo actualizar, El objeto Microcurriculo x Estado esta vacio");
			throw expLog;
		}
		try {
			int id = microxEstado.getNbId();
			TbMicMicroxestado microxEstadoConsulta = microxEstadoDao.obtenerMicroxestado(id);
		
			if(microxEstadoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo actualizar, El objeto Microcurriculo x Estado no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			microxEstadoDao.actualizarMicroxestado(microxEstado);;
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicMicroxestado obtenerMicroxestado(int id)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Microcurriculo x Estado esta vacio");
			throw expLog;
		}
		TbMicMicroxestado microxEstado = null;
		
		try {
			microxEstado = microxEstadoDao.obtenerMicroxestado(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(microxEstado == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("La Microcurriculo x Estado a actualizar no existe");
			throw expLog;
		}else{
			return microxEstado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicroxestado()
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		try {
			listaMicrosxestado = microxEstadoDao.listarMicroxestado();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Microcurriculos Estado");
			throw expLog;
		}else{
			return listaMicrosxestado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicrosxestado(int idEstado)
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		
		TbMicEstado estado = null;
		
		try {
			estado = estadoDao.obtenerEstado(idEstado);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			listaMicrosxestado = microxEstadoDao.listarMicrosxestado(estado);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculo x Estado");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Microcurriculos Estado");
			throw expLog;
		}else{
			return listaMicrosxestado;
		}
	}
	
	public List<TbMicMicroxestado> listarMicrosxestadoxMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO, ExcepcionesLogica{
List<TbMicMicroxestado> listaMicrosxestado = null;
		
		TbMicMicrocurriculo microcurriculo = null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo x Estado: error");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(microcurriculo != null){
			try {
				listaMicrosxestado = microxEstadoDao.listarMicrosxestadoxMicrocurriculo(microcurriculo);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculo x Estado");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		}else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontro Microcurriculos con estados asociados");
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Microcurriculos Estado");
			throw expLog;
		}else{
			return listaMicrosxestado;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
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

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.HistoricoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.HistoricoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class HistoricoNGCImpl implements HistoricoNGC {

	HistoricoDAO historicoDao;
	
	@Override
	public void guardarHistorico(TbAdmHistorico historico)
			throws ExcepcionesDAO, ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(historico == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Historico esta vacio");
			throw expLog;
		}
		try {
			int id = historico.getNbId();
			TbAdmHistorico historicoConsulta = historicoDao.obtenerHistorico(id);
		
			if(historicoConsulta != null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo guardar, El objeto Historico ya existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Historico");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			historicoDao.guardarHistorico(historico);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void modificarHistorico(TbAdmHistorico historico)
			throws ExcepcionesDAO, ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(historico == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Historico esta vacio");
			throw expLog;
		}
		try {
			int id = historico.getNbId();
			TbAdmHistorico historicoConsulta = historicoDao.obtenerHistorico(id);
		
			if(historicoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("El Historico a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			historicoDao.modificarHistorico(historico);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbAdmHistorico obtenerHistorico(int id) throws ExcepcionesDAO, ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Historico, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmHistorico historico = null;
		
		try {
			historico = historicoDao.obtenerHistorico(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Historico");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(historico == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Historico con Id");
			throw expLog;
		}else{
			return historico;
		}
	}

	@Override
	public List<TbAdmHistorico> listarHistoricos() throws ExcepcionesDAO, ExcepcionesLogica {
		List<TbAdmHistorico> listaHistoricos = null;
		try {
			listaHistoricos = historicoDao.listarHistoricos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Historicos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaHistoricos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Historico");
			throw expLog;
		}else{
			return listaHistoricos;
		}
	}
	
	@Override
	public List<TbAdmHistorico> obtenerHistoricosxMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO, ExcepcionesLogica{
		List<TbAdmHistorico> listaHistoricos = null;
		try {
			listaHistoricos = historicoDao.obtenerHistoricosxMicrocurriculo(microcurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Historicos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		return listaHistoricos;
	}

}

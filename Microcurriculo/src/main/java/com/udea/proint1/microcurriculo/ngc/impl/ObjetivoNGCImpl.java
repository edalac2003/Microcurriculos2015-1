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
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Objetivo, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicObjetivo objetivo = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivo = objetivoDao.obtenerObjetivo(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Objetivo con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return objetivo;
		}
	}

	@Override
	public void guardarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesLogica, ExcepcionesDAO {
		TbMicObjetivo objetivosTMP = null;
		
		if (objetivo != null){
			
			try {
				objetivosTMP = objetivoDao.obtenerObjetivo(objetivo.getNbIdobjetivo());		
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
//			if (objetivosTMP == null){
				try {
					objetivoDao.guardarObjetivo(objetivo);
				} catch(ExcepcionesDAO expDAO){
					throw expDAO;
				} catch(Exception exp){
					ExcepcionesLogica expLog = new ExcepcionesLogica();
					expLog.setMsjUsuario("Error al invocar el metodo guardar Objetivo");
					expLog.setMsjTecnico(exp.getMessage());
					expLog.setOrigen(exp);
					throw expLog;
				}
//			}else {
//				ExcepcionesLogica expLog = new ExcepcionesLogica();
//				expLog.setMsjUsuario("No se pudo guardar, El objeto Objetivo ya existe");
//				throw expLog;
//			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Objetivo esta vacio");
			throw expLog;
		}
	}

/*		
	@Override
	public void guardarObjetivos(List<TbMicObjetivos> listaObjetivo) throws ExcepcionesLogica, ExcepcionesDAO {
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
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo actualizar, El objeto Objetivo esta vacio");
			throw expLog;
		}
		try {
			int id = objetivo.getNbIdobjetivo();
			TbMicObjetivo objetivoConsulta = objetivoDao.obtenerObjetivo(id);
		
			if(objetivoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo actualizar, El objeto Objetivo no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			objetivoDao.modificarObjetivo(objetivo);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicObjetivo> listarObjetivos() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicObjetivo> listaObjetivos = null;
		try {
			listaObjetivos = objetivoDao.listarObjetivos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Objetivos");
			throw expLog;
		}else{
			return listaObjetivos;
		}
	}

//	@Override
//	public int numeroRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
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
	public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicObjetivo> listaObjetivos = null;
		
		TbMicMicrocurriculo microcurriculo = null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			listaObjetivos = objetivoDao.listarObjetivosPorMicrocurriculo(microcurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Objetivos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
	@Override
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicObjetivo> listaObjetivos = null;
		
		try {
			listaObjetivos = objetivoDao.listarObjetivosPorTipo(tipo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Objetivos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
	@Override
	public void eliminarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			objetivoDao.eliminarObjetivo(objetivo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Objetivo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
}

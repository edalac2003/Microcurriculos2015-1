package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivoDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivoxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("unused")
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
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro)	throws ExcepcionesLogica, ExcepcionesDAO {
		TbMicObjetivoxmicro objetivosxMicroTMP = null;
		
//		if(objetivoxMicro != null){
//			try {
//				objetivosxMicroTMP = objetivoxMicroDao.obtenerObjetivoxMicro(objetivoxMicro.getNbId());
//			} catch (ExcepcionesDAO e) {
//				throw new ExcepcionesLogica("Error al intentar obtener el objeto <ObjetivoxMicro>");
//			}
//		}else{
//			ExcepcionesLogica expLog = new ExcepcionesLogica();
//			expLog.setMsjUsuario("No se pudo guardar, El objeto Objetivo x Microcurriculo esta vacio");
//			throw expLog;
//		}
		
		if(objetivoxMicro != null){
			try {
				objetivoxMicroDao.guardarObjetivosxMicro(objetivoxMicro);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Objetivo x Microcurriculo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		}else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Objetivo x microcurriculo esta vacio");
			throw expLog;
		}
	}

	/*@Override
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesLogica, ExcepcionesDAO {
		if (listaObjetivoxMicro != null){
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivoxMicro){
				guardarObjetivosxMicro(objetivoxMicro);				
			}
		}else{
			throw new ExcepcionesLogica("El objeto <Lista ObjetivoxMicrocurriculo no tiene informaci�n v�lida.");
		}
	}*/

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro)throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivoxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Objetivo x Microcurriculo esta vacio");
			throw expLog;
		}
		try {
			int id = objetivoxMicro.getNbId();
			TbMicObjetivoxmicro biblioxUnidadConsulta = objetivoxMicroDao.obtenerObjetivoxMicro(id);
		
			if(biblioxUnidadConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Objetivo x Microcurriculo a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			objetivoxMicroDao.modificarObjetivoxMicro(objetivoxMicro);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Objetivo x Microcurriculo, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicObjetivoxmicro objetivosxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivosxMicro = objetivoxMicroDao.obtenerObjetivoxMicro(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivosxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Objetivo x Microcurriculo con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return objetivosxMicro;
		}
	}
	
	@Override
	public TbMicObjetivoxmicro obtenerObjetivosxMicroxObjetivo(int idObjetivo) throws ExcepcionesLogica, ExcepcionesDAO {
		TbMicObjetivoxmicro objetivoxMicro = null;
		
		try {
			objetivoxMicro = objetivoxMicroDao.obtenerObjetivoxMicro(idObjetivo);
			if (objetivoxMicro != null)
				return objetivoxMicro;
			else
				return null;
			
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
	}

	@Override
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro()
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicObjetivoxmicro> listaObjetivosxMicro = null;
		try {
			listaObjetivosxMicro = objetivoxMicroDao.listarObjetivosxMicro();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Objetivos x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivosxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Objetivos x Microcurriculo");
			throw expLog;
		}else{
			return listaObjetivosxMicro;
		}
	}

	@Override
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicObjetivoxmicro> listaObjetivosxMicro = null;
		
		TbMicMicrocurriculo microcurriculo= null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaObjetivosxMicro = objetivoxMicroDao.obtenerObjetivosxMicroxMicro(microcurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivosxMicro;
	}
	
	@Override
	public void eliminarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			objetivoxMicroDao.eliminarObjetivoxMicro(objetivoxMicro);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Objetivo x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
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

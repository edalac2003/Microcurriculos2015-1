package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.UnidadXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadxMicroNGCImpl  implements UnidadxMicroNGC {
	
	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(UnidadxMicroNGCImpl.class);
	
	UnidadXMicroDAO unidadxMicroDao;
	
	MicrocurriculoDAO microcurriculoDao;
	
	public void setUnidadxMicroDao(UnidadXMicroDAO unidadxMicroDao) {
		this.unidadxMicroDao = unidadxMicroDao;
	}

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro)  throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidadXmicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto unidad x microcurriculo esta vacio");
			throw expLog;
		}
//		try {
//			int id = unidadXmicro.getNbId();
//			TbMicUnidadxmicro unidadXmicroConsulta = unidadxMicroDao.obtenerUnidadXmicro(id);
//		
//			if(unidadXmicroConsulta != null){
//				throw new ExcepcionesLogica("La Unidad x Microcurriculo a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("fall� al invocar el metodo obtenerUnidadXmicro de la clase unidadxMicroDao: "+ e);
//		}
		
		try {
			
			unidadxMicroDao.guardarUnidadXmicro(unidadXmicro);;
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Unidad x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	
	/*@Override
	public void guardarUnidadXmicro(List<TbMicUnidadesxmicro> listaUnidadxMicro) throws ExcepcionesLogica {
		if(listaUnidadxMicro != null){
			for(TbMicUnidadesxmicro uxM : listaUnidadxMicro){
				guardarUnidadXmicro(uxM);
			}
		}else{
			throw new ExcepcionesLogica();
		}		
	}*/

	@Override
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidadXmicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto unidad x microcurriculo esta vacio");
			throw expLog;
		}
		try {
			int id = unidadXmicro.getNbId();
			TbMicUnidadxmicro unidadXmicroConsulta = unidadxMicroDao.obtenerUnidadXmicro(id);
		
			if(unidadXmicroConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La unidad x microcurriculo actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		}catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Unidad x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			unidadxMicroDao.modificarUnidadXmicro(unidadXmicro);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Unidad x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicUnidadxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Unidad x Microcurriculo, no se ha encontrado id de busqueda");
			throw expLog;
		}
		TbMicUnidadxmicro unidadXmicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidadXmicro = unidadxMicroDao.obtenerUnidadXmicro(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Unidad x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidadXmicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró unidad x Microcurriculo con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return unidadXmicro;
		}
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicUnidadxmicro> listaUnidadesxMicro = null;
		
		TbMicMicrocurriculo microcurriculo= null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Unidades x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaUnidadesxMicro = unidadxMicroDao.listarUnidadesXMicroxMicro(microcurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Unidades x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaUnidadesxMicro;
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXmicro()
			throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicUnidadxmicro> listaUnidadesxMicro = null;
		try {
			listaUnidadesxMicro = unidadxMicroDao.listarUnidadesXmicro();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Unidades x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidadesxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de unidades x Microcurriculo");
			throw expLog;
		}else{
			return listaUnidadesxMicro;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = unidadxMicroDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("Se produjeron Errores al Obtener el numero de Registros de la Tabla Unidades x Microcurriculo.");
//		}
//				
//		return registro;
//	}
	
	@Override
	public void eliminarUnidadxmicro(TbMicUnidadxmicro unidadxmicro) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			unidadxMicroDao.eliminarUnidadxmicro(unidadxmicro);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Unidad x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

//import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DependenciaDAO;
import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DependenciaNGCImpl implements DependenciaNGC {
	
	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);
	
	DependenciaDAO dependenciaDao;
	UnidadAcademicaDAO unidadAcademicaDao;

	public void setDependenciaDao(DependenciaDAO dependenciaDao) {
		this.dependenciaDao = dependenciaDao;
	}

	public void setUnidadAcademicaDao(UnidadAcademicaDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public DependenciaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(dependencia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Dependencia esta vacio");
			throw expLog;
		}
//		try {
//			String id = dependencia.getVrIddependencia();
//			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencias(id);
//		
//			if(dependenciaConsulta != null){
//				throw new ExcepcionesLogica("La dependencia a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
//		}
		
		try {
			
			dependenciaDao.guardarDependencia(dependencia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
	
	@Override
	public void guardarListadoDependencia(List<TbAdmDependencia> lista)	throws ExcepcionesLogica, ExcepcionesDAO {
		
		if((lista != null) && (lista.size() > 0)){			
			try {				
				dependenciaDao.guadarListadoDependencia(lista);			
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Listados de Dependencia");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Dependencia esta vacio");
			throw expLog;
		}		
	}

	
	

	@Override
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(dependencia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Dependencia esta vacio");
			throw expLog;
		}
		try {
			String id = dependencia.getVrIddependencia();
			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencias(id);
		
			if(dependenciaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Dependencia a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			dependenciaDao.actualizarDependencias(dependencia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Dependencia, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmDependencia dependencia = null;
		
		try {
			dependencia = dependenciaDao.obtenerDependencias(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(dependencia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Dependencia con Id");
			throw expLog;
		}else{
			return dependencia;
		}
	}
	

	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmDependencia> listaDependencia = null;
		
		if(unidad != null){
			try {
				listaDependencia = dependenciaDao.listarDependenciasPorUnidad(unidad);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo listar Dependencias");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("La Dependencia a buscar no existe");
			throw expLog;
		}		
		return listaDependencia;
	}

	@Override
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.listarDependencias();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Dependencias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Dependencias");
			throw expLog;
		}else{
			return listaDependencias;
		}
	}

	

	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(String unidad) throws ExcepcionesLogica, ExcepcionesDAO {
		if(unidad.equals("")||(unidad.equals(null))){
			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
		}
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.listarDependenciasPorUnidad(unidad);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Dependencias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Dependencias");
			throw expLog;
		}else{
			return listaDependencias;
		}
	}
	
	@Override
	public List<TbAdmDependencia> buscarDepedencias(String buscar) throws ExcepcionesLogica, ExcepcionesDAO{
//		if(buscar.equals("")||(buscar.equals(null))){
//			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
//		}
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.buscarDependencias(buscar);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo buscar Dependencias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Dependencias");
			throw expLog;
		}else{
			return listaDependencias;
		}
	}
	
	
}

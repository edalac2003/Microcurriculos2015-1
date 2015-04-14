package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadAcademicaNGCImpl implements UnidadAcademicaNGC {

	

	private static Logger log=Logger.getLogger(UnidadAcademicaNGCImpl.class);
	
	UnidadAcademicaDAO unidadAcademicaDao;

	public void setUnidadAcademicaDao(UnidadAcademicaDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public UnidadAcademicaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidadAcademica == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto unidad Academica esta vacio");
			throw expLog;
		}

		try {			
			unidadAcademicaDao.guardarUnidad(unidadAcademica);		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Unidad Academica");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
	@Override
	public void guardarListadoUnidad(List<TbAdmUnidadAcademica> lista) throws ExcepcionesLogica, ExcepcionesDAO {
		
		if(lista != null){
			try {			
				unidadAcademicaDao.guardarListadoUnidad(lista);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Unidad Academica");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El listado de Unidad Academica esta vacio.");
			throw expLog;
		}
	}

	@Override
	public void actualizarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidadAcademica == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto unidad Academica esta vacio");
			throw expLog;
		}
		try {
			String id = unidadAcademica.getVrIdunidad();
			TbAdmUnidadAcademica unidadAcademicaConsulta = unidadAcademicaDao.obtenerUnidad(id);
		
			if(unidadAcademicaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La unidad Academica a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Unidad Academica");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			unidadAcademicaDao.modificarUnidad(unidadAcademica);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Unidad Academica");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbAdmUnidadAcademica obtenerUnidadAcademica(String id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Unidad Academica, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmUnidadAcademica unidadAcademica = null;
		
		try {
			unidadAcademica = unidadAcademicaDao.obtenerUnidad(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el obtener modificar Unidad Academica");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en �l.
		 */
		if(unidadAcademica == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró unidad Academica con Id");
			throw expLog;
		}else{
			return unidadAcademica;
		}
	}

	@Override
	public List<TbAdmUnidadAcademica> listarUnidadAcademicas() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmUnidadAcademica> listaUnidadAcademicas = null;
		try {
			listaUnidadAcademicas = unidadAcademicaDao.listarUnidades();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Unidades Academicas");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en �l.
		 */
		if(listaUnidadAcademicas == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de unidades Academicas");
			throw expLog;
		}else{
			return listaUnidadAcademicas;
		}
	}

}

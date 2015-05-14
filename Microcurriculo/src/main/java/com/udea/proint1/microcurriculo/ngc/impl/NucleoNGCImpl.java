package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class NucleoNGCImpl implements NucleoNGC {
	
	NucleoDAO nucleoDao;

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}


	public NucleoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(nucleo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Nucleo esta vacio");
			throw expLog;
		}
		try {
			String id = nucleo.getVrIdnucleo();
			TbAdmNucleo nucleoConsulta = nucleoDao.obtenerNucleo(id);
		
			if(nucleoConsulta != null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo guardar, El objeto Nucleo ya existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			nucleoDao.guardarNucleo(nucleo);
		
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
	public void guardarListadoNucleo(List<TbAdmNucleo> lista) throws ExcepcionesLogica, ExcepcionesDAO {
		
		if (lista != null){
			try {
				nucleoDao.guardarListadoNucleo(lista);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Lista Nucleo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El Listado de Nucleo esta vacio");
			throw expLog;
		}
		
	}

	
	

	@Override
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(nucleo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Nucleo esta vacio");
			throw expLog;
		}
		try {
			String id = nucleo.getVrIdnucleo();
			TbAdmNucleo nucleoConsulta = nucleoDao.obtenerNucleo(id);
		
			if(nucleoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("El Nucleo a actualizar no existe");
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
			
			nucleoDao.actualizarNucleo(nucleo);
		
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
	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Nucleo, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmNucleo nucleo = null;
		
		try {
			nucleo = nucleoDao.obtenerNucleo(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(nucleo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Nucleo con Id");
			throw expLog;
		}else{
			return nucleo;
		}
	}

	@Override
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmNucleo> listaNucleos = null;
		try {
			listaNucleos = nucleoDao.listarNucleos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaNucleos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Nucleos");
			throw expLog;
		}else{
			return listaNucleos;
		}
	}
	
	
	@Override
	public List<TbAdmNucleo> listarNucleosPorDependencia(String dependencia) throws ExcepcionesLogica, ExcepcionesDAO {
		if(dependencia.equals("") || (dependencia.length() < 1)){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo listar Nucleos x dependencia, no se ha encontrado id de consulta");
			throw expLog;
		}
		List<TbAdmNucleo> listaNucleos = null;
		try {
			listaNucleos = nucleoDao.listarNucleoPorDependencia(dependencia+"%");
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Nucleo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaNucleos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Nucleos");
			throw expLog;
		}else{
			return listaNucleos;
		}
	}
	
	
	
	@Override
	public List<TbAdmNucleo> listarNucleosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmNucleo> listaNucleos = null;
		
		if(dependencia != null){
			try {
				listaNucleos = nucleoDao.listarNucleoPorDependencia(dependencia);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo listar Nucleo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudieron listar los nucleos, el objeto de busqueda esta vacio");
			throw expLog;
		}		
		return listaNucleos;
	}

	@Override
	public List<TbAdmNucleo> buscarNucleos(String buscar)throws ExcepcionesLogica, ExcepcionesDAO{
//		if(buscar.equals("")||(buscar.equals(null))){
//			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
//		}
		List<TbAdmNucleo> listaNucleos = null;
		try {
			listaNucleos = nucleoDao.buscarNucleos(buscar);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo buscar Nucleos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaNucleos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Nucleos");
			throw expLog;
		}else{
			return listaNucleos;
		}
	}

}

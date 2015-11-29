package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
//import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BibliografiaNGCImpl implements BibliografiaNGC {
	
	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(BibliografiaNGCImpl.class);
	
	BibliografiaDAO bibliografiaDao;
	
	public void setBibliografiaDao(BibliografiaDAO bibliografiaDao) {
		this.bibliografiaDao = bibliografiaDao;
	}


	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(bibliografia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Bibliografia esta vacio");
			throw expLog;
		}
//		try {
//			int id = bibliografia.getNbIdbibliografia();
//			TbMicBibliografia bibliografiaConsulta = bibliografiaDao.obtenerBibliografia(id);
//		
//			if(bibliografiaConsulta != null){
//				throw new ExcepcionesLogica("La bibliografia a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("fall� al invocar el metodo obtenerBibliografia de la clase bibliografiaDao: "+ e);
//		}
		
		try {
			
			bibliografiaDao.guardarBibliografia(bibliografia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Bibliografia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesLogica, ExcepcionesDAO{
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Bibliografia, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicBibliografia bibliografia = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			bibliografia = bibliografiaDao.obtenerBibliografia(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Bibliografia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(bibliografia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Bibliografia con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return bibliografia;
		}
	}
	
	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(bibliografia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Bibliografia esta vacio");
			throw expLog;
		}
		try {
			int id = bibliografia.getNbIdbibliografia();
			TbMicBibliografia bibliografiaConsulta = bibliografiaDao.obtenerBibliografia(id);
		
			if(bibliografiaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Bibliografia actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Bibliografia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			bibliografiaDao.modificarBibliografia(bibliografia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo modificar Bibliografia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo)
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicBibliografia> listaBibliografias = null;
		try {
			listaBibliografias = bibliografiaDao.listarBibliografias();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Bibliografias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliografias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Bibliografias");
			throw expLog;
		}else{
			return listaBibliografias;
		}
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(char tipo)
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicBibliografia> listaBibliografias = null;
		try {
			listaBibliografias = bibliografiaDao.listarBibliografiaxTipo(tipo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Bibliografias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaBibliografias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Bibliografias");
			throw expLog;
		}else{
			return listaBibliografias;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registro = 0;
//		
//		try {
//			registro = bibliografiaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica();
//		}
//		
//		return registro;
//	}

	@Override
	public void eliminarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			bibliografiaDao.eliminarBiblio(bibliografia);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Bibliografia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}
	
}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dao.PrerrequisitoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PrerrequisitoNGCImpl implements PrerrequisitoNGC {

	private static Logger log=Logger.getLogger(PrerrequisitoNGCImpl.class);	
	
	PrerrequisitoDAO prerrequisitoDao;
	MateriaDAO materiaDao;
	
	public void setPrerrequisitoDao(PrerrequisitoDAO prerrequisitoDao) {
		this.prerrequisitoDao = prerrequisitoDao;
	}

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public PrerrequisitoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no estÃ© vacio
		 */
		if(prerrequisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Prerrequisito esta vacio");
			throw expLog;
		}
//		try {
//			int id = prerrequisito.getNbId();
//			TbAdmPrerrequisito prerrequisitoConsulta = prerrequisitoDao.obtenerPrerrequisito(id);
//		
//			if(prerrequisitoConsulta != null){
//				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("fallÃ³ al invocar el metodo obtenerPrerrequisito de la clase prerrequisitoDao: "+ e);
//		}
		
		try {
			
			prerrequisitoDao.guardarPrerrequisito(prerrequisito);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Prerrequisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no estÃ© vacio
		 */
		if(prerrequisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el prerrequisito esta vacio");
			throw expLog;
		}
		try {
			int id = prerrequisito.getNbId();
			TbAdmPrerrequisito prerrequisitoConsulta = prerrequisitoDao.obtenerPrerrequisito(id);
		
			if(prerrequisitoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("El prerrequisito a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Prerrequisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			prerrequisitoDao.actualizarPrerrequisito(prerrequisito);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Prerrequisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitos() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmPrerrequisito> listaPrerrequisitos = null;
		try {
			listaPrerrequisitos = prerrequisitoDao.listarPrerrequisitos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Prerrequisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		if(listaPrerrequisitos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Prerrequisitos");
			throw expLog;
		}else{
			return listaPrerrequisitos;
		}
	}

	@Override
	public TbAdmPrerrequisito obtenerPrerrequisito(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Prerrequisito, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmPrerrequisito prerrequisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			prerrequisito = prerrequisitoDao.obtenerPrerrequisito(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Prerrequisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		if(prerrequisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Prerrequisito con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return prerrequisito;
		}
	}
	
	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitosxMateria(String id)throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbAdmPrerrequisito> listaPrerrequisitos = null;
		
		TbAdmMateria materia= null;
		
		try {
			materia = materiaDao.obtenerMateria(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Prerrequisito x Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaPrerrequisitos = prerrequisitoDao.listarPrerrequisitosxMateria(materia);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Prerrequisitos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaPrerrequisitos;
	}

}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SemestreNGCImpl implements SemestreNGC {

	private static Logger log=Logger.getLogger(SemestreNGCImpl.class);
	
	SemestreDAO semestreDao;
	
	public void setSemestreDao(SemestreDAO semestreDao) {
		this.semestreDao = semestreDao;
	}

	public SemestreNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(semestre == null){
			throw new ExcepcionesLogica("El objeto semestre está vacio");
		}
		try {
			String id = semestre.getVrIdsemestre();
			TbAdmSemestre semestreConsulta = semestreDao.obtenerSemestre(id);
		
			if(semestreConsulta != null){
				throw new ExcepcionesLogica("El semestre a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSemestre de la clase semestreDao: "+ e);
		}
		
		try {
			
			semestreDao.guardarSemestre(semestre);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarSemestre de la clase semestreDao: "+ e);
		}*/
	}

	@Override
	public void actualizarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(semestre == null){
			throw new ExcepcionesLogica("El objeto semestre está vacio");
		}
		try {
			String id = semestre.getVrIdsemestre();
			TbAdmSemestre semestreConsulta = semestreDao.obtenerSemestre(id);
		
			if(semestreConsulta == null){
				throw new ExcepcionesLogica("El semestre a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSemestre de la clase semestreDao: "+ e);
		}
		
		try {
			
			semestreDao.actualizarSemestre(semestre);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarSemestre de la clase semestreDao: "+ e);
		}*/
		
	}

	@Override
	public TbAdmSemestre obtenerSemestre(String id) throws ExcepcionesLogica, ExcepcionesDAO {
		TbAdmSemestre semestre = null;
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.trim().length() > 0) && (id != null)){
			try {
				semestre = semestreDao.obtenerSemestre(id);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo obtener Semestre");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
			
		} else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Semestre, no se ha encontrado id de consulta");
			throw expLog;
		}
		
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(semestre != null){			
			return semestre;
			
		}else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Semestre con Id");
			throw expLog;
		}
	}

	@Override
	public List<TbAdmSemestre> listarSemestres() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmSemestre> listaSemestres = null;
		try {
			listaSemestres = semestreDao.listarSemestres();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Semestres");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if (listaSemestres != null)
			return listaSemestres;
		else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Semestres");
			throw expLog;
		}
		
	}

}

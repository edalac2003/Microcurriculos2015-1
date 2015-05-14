package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.MateriaxSemestreDAO;
import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateriaxsemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.ngc.MateriaxSemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MateriaxSemestreNGCImpl implements MateriaxSemestreNGC {
	
	MateriaxSemestreDAO materiaxSemestreDao;
	
	SemestreDAO semestreDao;

	public void setMateriaxSemestreDao(MateriaxSemestreDAO materiaxSemestreDao) {
		this.materiaxSemestreDao = materiaxSemestreDao;
	}

	public void setSemestreDao(SemestreDAO semestreDao) {
		this.semestreDao = semestreDao;
	}

	@Override
	public void guardarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre)
			throws ExcepcionesDAO, ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materiaxsemestre == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Materia por Semestre esta vacio");
			throw expLog;
		}
		try {
			int id = materiaxsemestre.getNbId();
			TbAdmMateriaxsemestre materiaxsemestreConsulta = materiaxSemestreDao.obtenerMateriaxsemestre(id);
		
			if(materiaxsemestreConsulta != null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo guardar, El objeto Materia por Semestre ya existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Materia por Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			materiaxSemestreDao.guardarMateriaxSemestre(materiaxsemestre);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Materia por Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void modificarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materiaxsemestre == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Materia por Semestre esta vacio");
			throw expLog;
		}
		try {
			int id = materiaxsemestre.getNbId();
			TbAdmMateriaxsemestre materiaxSemestreConsulta = materiaxSemestreDao.obtenerMateriaxsemestre(id);
		
			if(materiaxSemestreConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("El Materia por Semestre a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Materia por Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			materiaxSemestreDao.modificarMateriaxSemestre(materiaxsemestre);
		
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
	public TbAdmMateriaxsemestre obtenerMateriaxsemestre(int id)
			throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Materia x Semestre, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmMateriaxsemestre materiaxsemestre = null;
		
		try {
			materiaxsemestre = materiaxSemestreDao.obtenerMateriaxsemestre(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Materia por Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(materiaxsemestre == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Materia por Semestre con Id");
			throw expLog;
		}else{
			return materiaxsemestre;
		}
	}

	@Override
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestre()
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmMateriaxsemestre> listaMateriaxsemestres = null;
		try {
			listaMateriaxsemestres = materiaxSemestreDao.listarMateriasxSemestre();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Materias x Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMateriaxsemestres == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Materias x Semestre");
			throw expLog;
		}else{
			return listaMateriaxsemestres;
		}
	}

	@Override
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestrexSemestre(
			String idSemestre) throws ExcepcionesLogica, ExcepcionesDAO {
		TbAdmSemestre semestre = null;
		try {
			semestre = semestreDao.obtenerSemestre(idSemestre);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Materias x Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(semestre == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos de semestre especifico");
			throw expLog;
		}
		
		List<TbAdmMateriaxsemestre> listaMateriaxsemestres = null;
		try {
			listaMateriaxsemestres = materiaxSemestreDao.listarMateriasxSemestrexSemestre(semestre);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Materias x Semestre");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMateriaxsemestres == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Materias por Semestre");
			throw expLog;
		}else{
			return listaMateriaxsemestres;
		}
	}

}

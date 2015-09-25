package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MateriaNGCImpl implements MateriaNGC {
	
	private static Logger log=Logger.getLogger(MateriaNGCImpl.class);
	
	MateriaDAO materiaDao;
	NucleoDAO nucleoDao;

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	
	@Override
	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		
		if(materia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Materia esta vacio");
			throw expLog;
		}
		try {
			String id = materia.getVrIdmateria();
			log.info("Id materia:" + id);
			TbAdmMateria materiasConsulta = materiaDao.obtenerMateria(id);
			if(materiasConsulta != null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No se pudo guardar, La materia ya existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			materiaDao.guardarMateria(materia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Materia esta vacio");
			throw expLog;
		}
		try {
			String id = materia.getVrIdmateria();
			TbAdmMateria materiaConsulta = materiaDao.obtenerMateria(id);
		
			if(materiaConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Materia a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			materiaDao.actualizarMateria(materia);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbAdmMateria obtenerMateria(String id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		TbAdmMateria materias = null;
		
		if("".equals(id) || (id.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Materia, no se ha encontrado id de consulta");
			throw expLog;
		} else {
			try {
				//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
				materias = materiaDao.obtenerMateria(id);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo obtener Materia");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		}
				
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(materias == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontr� Materia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return materias;
		}
	}

	@Override
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmMateria> listaMaterias = null;
		try {
			listaMaterias = materiaDao.listarMaterias();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Materias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMaterias == null){
			throw new ExcepcionesLogica("No se encontraron materias en la tabla TbAdmMaterias");
		}else{
			return listaMaterias;
		}
	}
	
	@Override
	public List<TbAdmMateria> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbAdmMateria> listaMaterias = null;
		
		TbAdmNucleo nucleoConsulta = null;
		
//		try {
//			nucleoConsulta = nucleoDao.obtenerNucleo(nucleo);
//		} catch(ExcepcionesDAO expDAO){
//			throw expDAO;
//		} catch(Exception exp){
//			ExcepcionesLogica expLog = new ExcepcionesLogica();
//			expLog.setMsjUsuario("Error al invocar el metodo obtener Materia");
//			expLog.setMsjTecnico(exp.getMessage());
//			expLog.setOrigen(exp);
//			throw expLog;
//		}
		
		try {
			listaMaterias = materiaDao.listarMateriasPorNucleo(nucleo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Materias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
			return listaMaterias;
	}
	
	
	
	@Override
	public List<TbAdmMateria> listarMateriasxNucleo(TbAdmNucleo nucleo)	throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmMateria> listaMaterias = null;
		
		if (nucleo != null){
			try {
				listaMaterias = materiaDao.listarMateriasPorNucleo(nucleo);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo listar Materias");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Materias");
			throw expLog;
		}
		
		return listaMaterias;
	}

	@Override
	public List<TbAdmMateria> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbAdmMateria> listaMaterias = null;
		
		if(semestre == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se ingreso Id de semestre valido");
			throw expLog;
		}
		
		try{
			listaMaterias = materiaDao.listarMateriasPorSemestre(semestre);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Materias");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		return listaMaterias;
	}
	
	@Override
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesLogica, ExcepcionesDAO{
		if(buscar.equals("")||(buscar.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontro Id de busqueda para materias");
			throw expLog;
		}
		List<TbAdmMateria> listaMaterias = null;
		try {
			listaMaterias = materiaDao.buscarMaterias(buscar);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo buscar Materia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMaterias == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Materias");
			throw expLog;
		}else{
			return listaMaterias;
		}
	}
		
}

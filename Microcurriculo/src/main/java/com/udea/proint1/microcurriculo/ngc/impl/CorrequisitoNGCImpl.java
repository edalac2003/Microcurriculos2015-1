package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CorrequisitoDAO;
import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitoNGCImpl implements CorrequisitoNGC {
	
	private static Logger log=Logger.getLogger(CorrequisitoNGCImpl.class);	

	CorrequisitoDAO correquisitoDao;
	MateriaDAO materiaDao;
	
	public void setCorrequisitoDao(CorrequisitoDAO correquisitoDao) {
		this.correquisitoDao = correquisitoDao;
	}

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public CorrequisitoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Correquisito esta vacio");
			throw expLog;
		}
//		try {
//			int id = correquisito.getNbId();
//			TbAdmCorrequisito correquisitoConsulta = correquisitoDao.obtenerCorrequisitos(id);
//		
//			if(correquisitoConsulta != null){
//				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerCorrequisitos de la clase correquisitoDao: "+ e);
//		}
		
		try {
			
			correquisitoDao.guardarCorrequisito(correquisito);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Correquisito esta vacio");
			throw expLog;
		}
		try {
			int id = correquisito.getNbId();
			TbAdmCorrequisito correquisitoConsulta = correquisitoDao.obtenerCorrequisitos(id);
		
			if(correquisitoConsulta == null){
				throw new ExcepcionesLogica("El correquisito a actualizar no existe");
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			correquisitoDao.actualizarCorrequisito(correquisito);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbAdmCorrequisito> listarCorrequisitos() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmCorrequisito> listaCorrequisitos = null;
		try {
			listaCorrequisitos = correquisitoDao.listarCorrequisitos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaCorrequisitos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Correquisitos");
			throw expLog;
		}else{
			return listaCorrequisitos;
		}
	}

	@Override
	public TbAdmCorrequisito obtenerCorrequisito(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Correquisito, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbAdmCorrequisito correquisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			correquisito = correquisitoDao.obtenerCorrequisitos(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(correquisito == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Correquisito con Id");
			throw expLog;
		}else{
			//si no esta vacio retorna la ciudad
			return correquisito;
		}
	}
	
	@Override
	public List<TbAdmCorrequisito> listarCorrequisitosxMateria(String id) throws ExcepcionesLogica, ExcepcionesDAO{
		
		List<TbAdmCorrequisito> listaCorrequisitos = null;
		
		TbAdmMateria materia= null;
		
		try {
			materia = materiaDao.obtenerMateria(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Correquisito");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(materia == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Correquisitos");
			throw expLog;
		}
		
		try {
			listaCorrequisitos = correquisitoDao.listarCorrequisitosxMateria(materia);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Correquisitos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaCorrequisitos;
	}

}

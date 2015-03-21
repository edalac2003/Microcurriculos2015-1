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
	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			log.info("Id materia:" + id);
			TbAdmMateria materiasConsulta = materiaDao.obtenerMateria(id);
			if(materiasConsulta != null){
				throw new ExcepcionesLogica("La materia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenermaterias de la clase materiaDao: "+ e);
		}
		
		try {
			
			materiaDao.guardarMateria(materia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMateria de la clase materiaDao: "+ e);
		}
	}

	@Override
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			TbAdmMateria materiaConsulta = materiaDao.obtenerMateria(id);
		
			if(materiaConsulta == null){
				throw new ExcepcionesLogica("El materias a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMaterias de la clase materiaDao: "+ e);
		}
		
		try {
			
			materiaDao.actualizarMateria(materia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public TbAdmMateria obtenerMateria(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		TbAdmMateria materias = null;
		
		if("".equals(id) || (id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado un ID de Materia Valido.");
		} else {
			try {
				//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
				materias = materiaDao.obtenerMateria(id);
			} catch (ExcepcionesDAO e) {
				log.error("falló al invocar el metodo obtenerMaterias de la clase materiaDao: "+ e);
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
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesLogica {
		List<TbAdmMateria> listaMaterias = null;
		try {
			listaMaterias = materiaDao.listarMaterias();
		} catch (ExcepcionesDAO e) {
			log.error("Fall� al invocar el metodo listarMaterias de la clase materiaDao: "+ e);
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
	public List<TbAdmMateria> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica{
		List<TbAdmMateria> listaMaterias = null;
		
		TbAdmNucleo nucleoConsulta = null;
		
		try {
			nucleoConsulta = nucleoDao.obtenerNucleo(nucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase NucleoDao: "+ e);
		}
		
		try {
			listaMaterias = materiaDao.listarMateriasPorNucleo(nucleoConsulta);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMateriasPorNucleo de la clase materiaDao: "+ e);
		}
		
			return listaMaterias;
	}
	
	
	
	@Override
	public List<TbAdmMateria> listarMateriasxNucleo(TbAdmNucleo nucleo)	throws ExcepcionesLogica {
		List<TbAdmMateria> listaMaterias = null;
		
		if (nucleo != null){
			try {
				listaMaterias = materiaDao.listarMateriasPorNucleo(nucleo);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica(e);
			}
		} else {
			throw new ExcepcionesLogica("El objeto <Tb_Adm_Nucleo> est� Vacio.");
		}
		
		return listaMaterias;
	}

	@Override
	public List<TbAdmMateria> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica{
		List<TbAdmMateria> listaMaterias = null;
		
		if(semestre == 0){
			throw new ExcepcionesLogica("No se ingreso un semestre");
		}
		
		try{
			listaMaterias = materiaDao.listarMateriasPorSemestre(semestre);
		}catch (ExcepcionesDAO e){
			log.error("Falló al invocar el metodo listarMateriasPorSemestre de la clase materiaDao: "+ e);
		}
		return listaMaterias;
	}
	
	@Override
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesLogica{
		if(buscar.equals("")||(buscar.equals(null))){
			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
		}
		List<TbAdmMateria> listaMaterias = null;
		try {
			listaMaterias = materiaDao.buscarMaterias(buscar);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo buscarMaterias de la clase materiaDao: "+ e);
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
		
}

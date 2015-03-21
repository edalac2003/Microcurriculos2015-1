package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicrocurriculoNGCImpl implements MicrocurriculoNGC {

	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);

	MicrocurriculoDAO microcurriculoDao;
	MateriaDAO materiaDao;
	NucleoDAO nucleoDao;
	PersonaDAO personaDao;
	
	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	public void setMateriaDao(MateriaDAO materiaDao) {
		this.materiaDao = materiaDao;
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	
	@Override
	public TbMicMicrocurriculo obtenerMicrocurriculos(String idMicrocurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!("".equals(idMicrocurriculo)) && (idMicrocurriculo.trim().length() > 0) ){
			try {
				microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("NGC : Ocurri� un error al intentar obtener el microcurriculo.");
			}			
		}else{
			throw new ExcepcionesLogica("La informaci�n de IdMicrocurriculo no es v�lida o est� vacia.");
		}
		
		return microcurriculo;
	}

	
	@Override
	public void guardarMicrocurriculos(TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto Microcurriculo no est� Vacio.
		 */
		System.out.println("INGRESO AL GUARDAR MICROCURRICULO EN LA PARTE DE NEGOCIO.");
		
		if(microcurriculo != null){
			try {
				TbMicMicrocurriculo microTMP = microcurriculoDao.obtenerMicrocurriculo(microcurriculo.getVrIdmicrocurriculo().toString());
				if (microTMP == null){
					microcurriculoDao.guardarMicrocurriculo(microcurriculo);
				}else{
					throw new ExcepcionesLogica("El Microcurriculo que desea guardar ya se encuentra en la Base de Datos.");
				}
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}			
		}else{
			throw new ExcepcionesLogica("No es posible guardar. El objeto Microcurriculo no contiene informaci�n v�lida.");
		}
	}
	

	@Override
	public void actualizarMicrocurriculos(TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
//		if(microcurriculo == null){
//			throw new ExcepcionesLogica("El objeto microcurriculo está vacio");
//		}
//		try {
//			String id = microcurriculo.getVrIdmicrocurriculo();
//			TbMicMicrocurriculos microcurriculoConsulta = microcurriculoDao.obtenerMicrocurriculo(id);
//		
//			if(microcurriculoConsulta == null){
//				throw new ExcepcionesLogica("El microcurriculo a actualizar no existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculoDao: "+ e);
//		}
//		
//		try {
//			
//			microcurriculoDao.modificarMicrocurriculo(microcurriculo);
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo modificarMicrocurriculo de la clase microcurriculoDao: "+ e);
//		}
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculos() throws ExcepcionesLogica {
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculos de la clase microcurriculoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrocurriculos == null){
			throw new ExcepcionesLogica("No se encontraron microcurriculos en la tabla TbMicMicrocurriculos");
		}else{
			return listaMicrocurriculos;
		}
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
			
		if(idSemestre.equals("")||(idSemestre.equals(null))){
			throw new ExcepcionesLogica("No se envio un id de semestre a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorSemestre(idSemestre);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorSemestre de la clase microcurriculoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		TbAdmNucleo nucleo= null;
		
		if(idNucleo.equals("")||(idNucleo.equals(null))){
			throw new ExcepcionesLogica("No se envio un id de nucleo a consultar"); 
		}
		
		try {
			nucleo = nucleoDao.obtenerNucleo(idNucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
		
		if(nucleo == null){
			throw new ExcepcionesLogica("NO existe nucleo a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorNucleo(nucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorNucleo de la clase microcurriculoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica{
		List<TbMicMicrocurriculo> listaTodosMicrocurriculos = new ArrayList<TbMicMicrocurriculo>();
		List<TbMicMicrocurriculo> listaMicrocurriculo = null;
		
		List<TbAdmMateria> materias= null;
		
		try {
			materias = materiaDao.buscarMaterias(idMateria);
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerMateria de la clase materiaDao: "+ e);
		}
		
		if(materias != null){
			for(TbAdmMateria materia:materias){
				try {
					listaMicrocurriculo = microcurriculoDao.listarMicrocurriculosPorMateria(materia);
					listaTodosMicrocurriculos.addAll(listaMicrocurriculo);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica("Se presentaron problemas "+e);
				}
			}
		} else {
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaTodosMicrocurriculos;
	}
	

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		TbAdmPersona responsable= null;
		
		try {
			responsable = personaDao.obtenerPersona(idResponsable);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		if(responsable == null){
			throw new ExcepcionesLogica("NO existe responsable a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorResponsable(responsable);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorResponsable de la clase microcurriculoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}

}

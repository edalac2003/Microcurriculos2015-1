package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
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
	public TbMicMicrocurriculo obtenerMicrocurriculos(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!("".equals(idMicrocurriculo)) && (idMicrocurriculo.trim().length() > 0) ){
			try {
				microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo obtener Microcurriculo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}			
		}else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("La información de IdMicrocurriculo no es válida o está vacia");
			throw expLog;
		}
		
		return microcurriculo;
	}

	
	@Override
	public void guardarMicrocurriculos(TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto Microcurriculo no esté Vacio.
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
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Microcurriculo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}			
		}else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No es posible guardar. El objeto Microcurriculo no contiene información válida");
			throw expLog;
		}
	}
	

	@Override
	public void actualizarMicrocurriculos(TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto id no estÃ© vacio
		 */
		if(microcurriculo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No es posible actualizar. El objeto Microcurriculo no contiene información válida");
			throw expLog;
		}
		try {
			String id = microcurriculo.getVrIdmicrocurriculo();
			TbMicMicrocurriculo microcurriculoConsulta = microcurriculoDao.obtenerMicrocurriculo(id);
		
			if(microcurriculoConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("No es posible actualizar. El Microcurriculo no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			microcurriculoDao.modificarMicrocurriculo(microcurriculo);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculos() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculos();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		if(listaMicrocurriculos == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Microcurriculos");
			throw expLog;
		}else{
			return listaMicrocurriculos;
		}
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
			
		if(idSemestre.equals("")||(idSemestre.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Microcurriculo, no se ha encontrado id de consulta");
			throw expLog;
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorSemestre(idSemestre);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		TbAdmNucleo nucleo= null;
		
		if(idNucleo.equals("")||(idNucleo.equals(null))){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo buscar Microcurriculo, no se ha encontrado id de consulta");
			throw expLog;
		}
		
		try {
			nucleo = nucleoDao.obtenerNucleo(idNucleo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(nucleo == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No existe Nucleo a Consultar");
			throw expLog; 
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorNucleo(nucleo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaTodosMicrocurriculos = new ArrayList<TbMicMicrocurriculo>();
		List<TbMicMicrocurriculo> listaMicrocurriculo = null;
		
		List<TbAdmMateria> materias= null;
		
		try {
			materias = materiaDao.buscarMaterias(idMateria);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(materias != null){
			for(TbAdmMateria materia:materias){
				try {
					listaMicrocurriculo = microcurriculoDao.listarMicrocurriculosPorMateria(materia);
					listaTodosMicrocurriculos.addAll(listaMicrocurriculo);
				} catch(ExcepcionesDAO expDAO){
					throw expDAO;
				} catch(Exception exp){
					ExcepcionesLogica expLog = new ExcepcionesLogica();
					expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
					expLog.setMsjTecnico(exp.getMessage());
					expLog.setOrigen(exp);
					throw expLog;
				}
			}
		} else {
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No existe Materia a Consultar");
			throw expLog;
		}
		
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaTodosMicrocurriculos;
	}
	
	/*@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		TbAdmMateria materia= null;
		
		try {
			materia = materiaDao.obtenerMateria(idMateria);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiaDao: "+ e);
		}
		
		if(materia != null){
			try {
				listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorMateria(materia);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Se presentaron problemas "+e);
			}			
		} else {
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
//		try {
//			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorMateria(idMateria);
//		} catch (ExcepcionesDAO e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 
		return listaMicrocurriculos;
	}*/
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		TbAdmPersona responsable= null;
		
		try {
			responsable = personaDao.obtenerPersona(idResponsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Persona Responsable");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(responsable == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No existe responsable a consultar");
			throw expLog;
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorResponsable(responsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosxResponsablexUnidad(String idResponsable, String unidad) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		List<TbMicMicrocurriculo> listaMicrocurriculosFiltrada = new ArrayList<TbMicMicrocurriculo>();
		
		TbAdmPersona responsable= null;
		
		try {
			responsable = personaDao.obtenerPersona(idResponsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Persona Responsable");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(responsable == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No existe responsable a consultar");
			throw expLog;
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorResponsable(responsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo micro: listaMicrocurriculos){
				if(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad().equals(unidad)){
					listaMicrocurriculosFiltrada.add(micro);
				}
			}
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaMicrocurriculosFiltrada;
	}
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosxResponsablexDependencia(String idResponsable, String dependencia) throws ExcepcionesLogica, ExcepcionesDAO{
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		List<TbMicMicrocurriculo> listaMicrocurriculosFiltrada = new ArrayList<TbMicMicrocurriculo>();
		
		TbAdmPersona responsable= null;
		
		try {
			responsable = personaDao.obtenerPersona(idResponsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Persona Responsable");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if(responsable == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No existe responsable a consultar");
			throw expLog;
		}
		
		try {
			listaMicrocurriculos = microcurriculoDao.listarMicrocurriculosPorResponsable(responsable);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo micro: listaMicrocurriculos){
				if(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia().equals(dependencia)){
					listaMicrocurriculosFiltrada.add(micro);
				}
			}
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en Ã©l.
		 */
		return listaMicrocurriculosFiltrada;
	}
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO, ExcepcionesLogica{
		List<String> materias = new ArrayList<String>();
		try {
			materias = materiaDao.listarIdMateriasxDependencia(dependencia.getVrIddependencia());
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos por dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		List<TbMicMicrocurriculo> microcurriculosEncontrados = new ArrayList<TbMicMicrocurriculo>();
		List<TbMicMicrocurriculo> microcurriculosEnviar = new ArrayList<TbMicMicrocurriculo>();
		try {
			if(materias != null){
				for(String materia: materias){
					microcurriculosEncontrados = microcurriculoDao.listarMicrocurriculosPorMateria(materia);
					for(TbMicMicrocurriculo microcurriculo: microcurriculosEncontrados){
						microcurriculosEnviar.add(microcurriculo);
					}
				}
			}
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Microcurriculos por dependencia");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		return microcurriculosEnviar;
	}
}

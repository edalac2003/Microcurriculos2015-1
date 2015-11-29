package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
//import com.udea.proint1.microcurriculo.dao.RolDAO;
//import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
//import com.udea.proint1.microcurriculo.dao.TipoPersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
//import com.udea.proint1.microcurriculo.dto.TbAdmRol;
//import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
//import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PersonaNGCImpl implements PersonaNGC {
	
	private static Logger log=Logger.getLogger(PersonaNGCImpl.class);
	
	PersonaDAO personaDao;
//	RolDAO rolDao;
//	RolxUsuarioDAO rolxUsuarioDAO;
	CiudadDAO ciudadDao;
	//TipoIdentificacionDAO tipoIdentificacionDao;

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	public void setCiudadDao(CiudadDAO ciudadDao) {
		this.ciudadDao = ciudadDao;
	}

	/*public void setTipoIdentificacionDao(TipoIdentificacionDAO tipoIdentificacionDao) {
		this.tipoIdentificacionDao = tipoIdentificacionDao;
	}*/

	public PersonaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesLogica {
		
		TbAdmPersona personaConsulta = null;
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if (persona != null){
			try {
				personaConsulta = personaDao.obtenerPersona(persona.getVrIdpersona());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica(e);
			}
		}
		
		if (personaConsulta == null){
			try {
				personaDao.guardarPersona(persona);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica(e);
			}
		}
		
		
	}

	@Override
	public void actualizarPersona(TbAdmPersona persona) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(persona == null){
			throw new ExcepcionesLogica("El objeto persona está vacio");
		}
		try {
			String id = persona.getVrIdpersona();
			TbAdmPersona personaConsulta = personaDao.obtenerPersona(id);
		
			if(personaConsulta == null){
				throw new ExcepcionesLogica("La persona a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		try {
			
			personaDao.modificarPersona(persona);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPersona de la clase personaDao: "+ e);
		}
	}

	@Override
	public TbAdmPersona obtenerPersona(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de persona,está vacia");
		}
		TbAdmPersona persona = null;
		
		try {
			persona = personaDao.obtenerPersona(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(persona == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró persona con el id "+ id);
		}else{
			return persona;
		}
	}

	@Override
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesLogica {
		List<TbAdmPersona> listaPersonas = null;
		try {
			listaPersonas = personaDao.listarPersonas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPersonas de la clase personaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaPersonas == null){
			throw new ExcepcionesLogica("No se encontraron personas en la tabla personaDao");
		}else{
			return listaPersonas;
		}
	}
	
//	@Override
//	public List<TbAdmPersona> obtenerDocentes() throws ExcepcionesLogica{
//		List<TbAdmRolxUsuario> listaRolesxUsuario = null;
//		
//		TbAdmRol rol = null;
//		
//		try {
//			rol = rolDao.obtenerRol(4);
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtener rol de la clase tipoPersonaDao: "+ e);
//		}
//		
//		try {
//			listaRolesxUsuario = rolxUsuarioDAO.obtenerRolxUsuarioxRol(rol);
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo listarPersonas de tipo docente de la clase personaDao: "+ e);
//		}
//		
//		/*
//		 * Confirmamos si el objeto retornado tiene elementos en él.
//		 */
//		if(listaRolesxUsuario == null){
//			throw new ExcepcionesLogica("No se encontraron personas de tipo docente en la tabla personaDao");
//		}else{
//			return listaRolesxUsuario;
//		}
//		return null;
//	}

	@Override
	public boolean existePersona(String idPersona) throws ExcepcionesLogica {
		Boolean hallado = false;
		TbAdmPersona consultaPersona = null;
		
		if(idPersona.trim().length() > 0){
			try {
				consultaPersona = personaDao.obtenerPersona(idPersona);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Problemas al Consultar Persona por ID. "+e);
			}
			
			if (consultaPersona != null)
				hallado = true;
			
		}else
			hallado = false;	
		
		return hallado;
	}
}

package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.AuditoriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmAuditoria;
import com.udea.proint1.microcurriculo.ngc.AuditoriaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AuditoriaNGCImpl implements AuditoriaNGC {

	private static Logger log=Logger.getLogger(AuditoriaNGCImpl.class);

	AuditoriaDAO auditoriaDao;
	
	public void setAuditoriaDao(AuditoriaDAO auditoriaDao) {
		this.auditoriaDao = auditoriaDao;
	}

	@Override
	public TbAdmAuditoria obtenerAuditoria(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de auditoria, está vacia");
		}
		TbAdmAuditoria auditoria = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			auditoria = auditoriaDao.obtenerAuditoria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAuditoria de la clase auditoriaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(auditoria == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró auditoria con el id "+ id);
		}else{
			return auditoria;
		}
	}

	@Override
	public void guardarAuditoria(TbAdmAuditoria auditoria)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(auditoria == null){
			throw new ExcepcionesLogica("El objeto auditoria está vacio");
		}
		try {
			int id = auditoria.getNbIdauditoria();
			TbAdmAuditoria auditoriaConsulta = auditoriaDao.obtenerAuditoria(id);
		
			if(auditoriaConsulta != null){
				throw new ExcepcionesLogica("La auditoria a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAuditoria de la clase auditoriaDao: "+ e);
		}
		
		try {
			
			auditoriaDao.guardarAuditoria(auditoria);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarAuditoria de la clase auditoriaDao: "+ e);
		}
	}

	@Override
	public void actualizarAuditoria(TbAdmAuditoria auditoria)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(auditoria == null){
			throw new ExcepcionesLogica("El objeto auditoria está vacio");
		}
		try {
			int id = auditoria.getNbIdauditoria();
			TbAdmAuditoria auditoriaConsulta = auditoriaDao.obtenerAuditoria(id);
		
			if(auditoriaConsulta == null){
				throw new ExcepcionesLogica("La auditoria a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAuditoria de la clase auditoriaDao: "+ e);
		}
		
		try {
			
			auditoriaDao.actualizarAuditoria(auditoria);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAuditoria de la clase auditoriaDao: "+ e);
		}
	}

	@Override
	public List<TbAdmAuditoria> listarAuditoria() throws ExcepcionesLogica {
		List<TbAdmAuditoria> listaAuditoria = null;
		try {
			listaAuditoria = auditoriaDao.listarAuditoria();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarAuditoria de la clase auditoriaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaAuditoria == null){
			throw new ExcepcionesLogica("No se encontraron Auditoria en la tabla TbAdmAuditoria");
		}else{
			return listaAuditoria;
		}
	}

}

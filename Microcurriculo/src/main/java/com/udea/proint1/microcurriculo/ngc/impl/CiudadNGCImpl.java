package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadDAO;
import com.udea.proint1.microcurriculo.dao.DepartamentoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.ngc.CiudadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CiudadNGCImpl implements CiudadNGC {

	private static Logger log = Logger.getLogger(CiudadNGCImpl.class);
	
	CiudadDAO ciudadDao;
	DepartamentoDAO departamentoDao;

	public void setCiudadDao(CiudadDAO ciudadDao) {
		this.ciudadDao = ciudadDao;
	}

	public void setDepartamentoDao(DepartamentoDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

	public CiudadNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmCiudad obtenerCiudad(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad,está vacia");
		}
		TbAdmCiudad ciudad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			ciudad = ciudadDao.obtenerCiudad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCiudad de la clase ciudadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(ciudad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró ciudad con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return ciudad;
		}
	}

	@Override
	public List<TbAdmCiudad> listarCiudades() throws ExcepcionesLogica {
		List<TbAdmCiudad> listaCiudades = null;
		try {
			listaCiudades = ciudadDao.listarCiudades();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCiudades de la clase ciudadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaCiudades == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron ciudades en la tabla TbAdmCiudades");
		}else{
			//si no esta vacio retorna las ciudadades
			return listaCiudades;
		}
	}

	@Override
	public List<TbAdmCiudad> listarCiudadesxDepartamento(TbAdmDepartamento idDepartamento) throws ExcepcionesLogica {
		List<TbAdmCiudad> listaCiudades = null;
		
		try {
			listaCiudades = ciudadDao.listarCiudadesxDepartamento(idDepartamento);
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica(e);
		}
		
		return listaCiudades;
	}

	
	
	

}

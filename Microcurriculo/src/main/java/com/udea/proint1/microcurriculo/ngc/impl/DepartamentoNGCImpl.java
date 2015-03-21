package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DepartamentoDAO;
import com.udea.proint1.microcurriculo.dao.PaisDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.ngc.DepartamentoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DepartamentoNGCImpl implements DepartamentoNGC {
	
	private static Logger log=Logger.getLogger(DepartamentoNGCImpl.class);
	
	DepartamentoDAO departamentoDao;
	PaisDAO paisDao;

	public void setDepartamentoDao(DepartamentoDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}

	public DepartamentoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmDepartamento> listarDepartamentos() throws ExcepcionesLogica {
		List<TbAdmDepartamento> listaDepartamentos = null;
		try {
			listaDepartamentos = departamentoDao.listarDepartamentos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDepartamentos de la clase departamentoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDepartamentos == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron departamentos en la tabla TbAdmDepartamentos");
		}else{
			//si no esta vacio retorna los departamentos
			return listaDepartamentos;
		}
	}
	
	@Override
	public List<TbAdmDepartamento> listarDepartamentosxPais(TbAdmPais idPais) throws ExcepcionesLogica {
		List<TbAdmDepartamento> listaDepartamentos = null;
		
		if(idPais != null){
			try {
				listaDepartamentos = departamentoDao.listarDepartamentosxPais(idPais);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica(e);
			}
		} 
//		else
//			throw new ExcepcionesLogica("No Seleccion� ningun Pais." + e);
		
		return listaDepartamentos;
	}

	
	@Override
	public TbAdmDepartamento obtenerDepartamentos(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de departamento,está vacia");
		}
		TbAdmDepartamento departamento = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la Departamento con dicho id
			departamento = departamentoDao.obtenerDepartamento(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDepartamento de la clase departamentoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(departamento == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró departamento con el id "+ id);
		}else{
			//si no esta vacio retorna la Departamento
			return departamento;
		}
	}
	
	@Override
	public void modificarDepartamentos(TbAdmDepartamento departamento) throws ExcepcionesLogica{
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(departamento == null){
			throw new ExcepcionesLogica("El objeto departamento está vacio");
		}
		try {
			int id = departamento.getNbIddepartamento();
			TbAdmDepartamento departamentoConsulta = departamentoDao.obtenerDepartamento(id);
		
			if(departamentoConsulta == null){
				throw new ExcepcionesLogica("El departamento a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDepartamento de la clase departamentoDao: "+ e);
		}
		
		try {
			
			departamentoDao.modificarDepartamentos(departamento);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarDepartamentos de la clase departamentoDao: "+ e);
		}
	}

}

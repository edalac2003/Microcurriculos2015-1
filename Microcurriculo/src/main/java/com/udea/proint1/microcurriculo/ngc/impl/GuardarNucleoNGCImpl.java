package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.GuardarNucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.GuardarNucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class GuardarNucleoNGCImpl implements GuardarNucleoNGC {

	

	GuardarNucleoDAO guardarNucleoDao;
	
	public void setGuardarNucleoDao(GuardarNucleoDAO guardarNucleoDao) {
		this.guardarNucleoDao = guardarNucleoDao;
	}
	
	@Override
	public void guardarNucleos(List<TbAdmUnidadAcademica> listaUnidades,
			List<TbAdmDependencia> listaDependencias,
			List<TbAdmNucleo> listaNucleos) throws ExcepcionesLogica,
			ExcepcionesDAO {
		
		if ((listaUnidades == null) && (listaDependencias == null) && (listaNucleos == null)){
			
		}else if ((listaUnidades != null) || (listaDependencias != null) || (listaNucleos != null)){
			System.out.println("El tamaño de Unidades : "+listaUnidades.size());
			System.out.println("El tamaño de Dependencias : "+listaDependencias.size());
			System.out.println("El tamaño de Nucleos : "+listaNucleos.size());
			
			try{
				guardarNucleoDao.guardarNucleos(listaUnidades, listaDependencias, listaNucleos);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al intentar obtener información de Nucleos");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		}
		
		
		
	}
	

}

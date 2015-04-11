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
			List<TbAdmNucleo> listaNucleos) throws ExcepcionesLogica {
		
		try {
			guardarNucleoDao.guardarNucleos(listaUnidades, listaDependencias, listaNucleos);
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

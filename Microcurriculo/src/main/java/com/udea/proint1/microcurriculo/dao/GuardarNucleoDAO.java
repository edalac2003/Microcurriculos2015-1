package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface GuardarNucleoDAO {
	
	public void guardarNucleos(List<TbAdmUnidadAcademica> listaUnidades, List<TbAdmDependencia> listaDependencias, 
							   List<TbAdmNucleo> listaNucleos) throws ExcepcionesDAO;
	
	
}

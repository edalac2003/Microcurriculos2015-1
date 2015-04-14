package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface GuardarNucleoNGC {

	public void guardarNucleos(List<TbAdmUnidadAcademica> listaUnidades, List<TbAdmDependencia> listaDependencias, 
			   List<TbAdmNucleo> listaNucleos) throws ExcepcionesLogica, ExcepcionesDAO;
}

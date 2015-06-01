package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DocentexDependenciaNGC {
	
	public void guardarDocentexDependencia(TbAdmDocentexDependencia docentexDependencia) throws ExcepcionesLogica;
	
	public void actualizarDocentexDependencia(TbAdmDocentexDependencia docentexDependencia) throws ExcepcionesLogica;

	public List<TbAdmDocentexDependencia> listarDocentesxDependencia() throws ExcepcionesLogica;
	
	public List<TbAdmDocentexDependencia> listarDocentesxDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;
	
	public TbAdmDocentexDependencia obtenerDocentexDependencia(int id) throws ExcepcionesLogica;
	
	public List<TbAdmDocentexDependencia> listarDependenciasxDocente(TbAdmPersona docente) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public List<TbAdmDocentexDependencia> listarDependenciasxDocentexUnidad(TbAdmPersona docente, TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO, ExcepcionesLogica;
	
}

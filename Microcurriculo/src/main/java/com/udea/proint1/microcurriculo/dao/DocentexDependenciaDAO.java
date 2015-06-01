package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DocentexDependenciaDAO {

	public void guardarDocentesxDependencia(TbAdmDocentexDependencia docentesxDependencia) throws ExcepcionesDAO;
	
	public TbAdmDocentexDependencia obtenerDocentesxDependencia(int id) throws ExcepcionesDAO;
	
	public List<TbAdmDocentexDependencia> listarDocentesxDependencia() throws ExcepcionesDAO;
	
	public List<TbAdmDocentexDependencia> listaDocentesxDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO;
	
	public void actualizarDocentesxDependencia(TbAdmDocentexDependencia docentesxDependencia) throws ExcepcionesDAO;
	
	public List<TbAdmDocentexDependencia> listarDependenciasxDocente(TbAdmPersona docente) throws ExcepcionesDAO;
}

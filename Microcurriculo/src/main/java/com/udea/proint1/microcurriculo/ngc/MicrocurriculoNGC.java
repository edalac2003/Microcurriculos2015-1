package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicrocurriculoNGC {
	
	public TbMicMicrocurriculo obtenerMicrocurriculos (String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarMicrocurriculos (TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
    
	public void actualizarMicrocurriculos (TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicMicrocurriculo> listarMicrocurriculos () throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica, ExcepcionesDAO;

	public List<TbMicMicrocurriculo> listarMicrocurriculosxResponsablexUnidad(String idResponsable, String unidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosxResponsablexDependencia(String idResponsable, String dependencia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO, ExcepcionesLogica;
}

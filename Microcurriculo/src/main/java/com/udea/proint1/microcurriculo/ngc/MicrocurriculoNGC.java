package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicrocurriculoNGC {
	
	public TbMicMicrocurriculo obtenerMicrocurriculos (String idMicrocurriculo) throws ExcepcionesLogica;
	
	public void guardarMicrocurriculos (TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica;
    
	public void actualizarMicrocurriculos (TbMicMicrocurriculo microcurriculo) throws ExcepcionesLogica;
    
    public List<TbMicMicrocurriculo> listarMicrocurriculos () throws ExcepcionesLogica;
    
    public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica;

}

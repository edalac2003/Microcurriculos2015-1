package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SubtemaNGC {
	
	public TbMicSubtema obtenerSubtemas(int idSubtema) throws ExcepcionesLogica;
	
	public void guardarSubtemas (TbMicSubtema subtema) throws ExcepcionesLogica;
	
    public void actualizarSubtemas (TbMicSubtema subtema) throws ExcepcionesLogica;
    
    public List<TbMicSubtema> listarSubtemas () throws ExcepcionesLogica;
    
//    public int contarRegistros() throws ExcepcionesLogica;
    
    public List<TbMicSubtema> listarSubtemasxTema(int idTema) throws ExcepcionesLogica;

}

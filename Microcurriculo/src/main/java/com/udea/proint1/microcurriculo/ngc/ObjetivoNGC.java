package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivoNGC {
	
	public TbMicObjetivo obtenerObjetivo(int id) throws ExcepcionesLogica;
	
	public void guardarObjetivo (TbMicObjetivo objetivo) throws ExcepcionesLogica;
	
    public void actualizarObjetivos (TbMicObjetivo objetivo) throws ExcepcionesLogica;
    
    public List<TbMicObjetivo> listarObjetivos () throws ExcepcionesLogica;
    
//    public int numeroRegistros() throws ExcepcionesLogica;
    
    public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica;
    
}

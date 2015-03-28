package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivoNGC {
	
	public TbMicObjetivo obtenerObjetivo(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarObjetivo (TbMicObjetivo objetivo) throws ExcepcionesLogica, ExcepcionesDAO;
	
    public void actualizarObjetivos (TbMicObjetivo objetivo) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicObjetivo> listarObjetivos () throws ExcepcionesLogica, ExcepcionesDAO;
    
//    public int numeroRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesLogica, ExcepcionesDAO;
    
}

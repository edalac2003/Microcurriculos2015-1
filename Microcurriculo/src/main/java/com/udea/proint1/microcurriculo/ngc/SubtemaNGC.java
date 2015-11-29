package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SubtemaNGC {
	
	public TbMicSubtema obtenerSubtemas(int idSubtema) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarSubtemas (TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO;
	
    public void actualizarSubtemas (TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicSubtema> listarSubtemas () throws ExcepcionesLogica, ExcepcionesDAO;
    
//    public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicSubtema> listarSubtemasxTema(int idTema) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public void eliminarSubtema(TbMicSubtema subtema) throws ExcepcionesLogica, ExcepcionesDAO;

}

package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemaNGC {
	
	public TbMicTema obtenerTemas(int idTema) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarTemas (TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO;
	
    public void actualizarTema (TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicTema> listarTemas () throws ExcepcionesLogica, ExcepcionesDAO;
    
//    public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public void eliminarTema(TbMicTema tema) throws ExcepcionesLogica, ExcepcionesDAO;

}

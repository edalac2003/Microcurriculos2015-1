package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemaNGC {
	
	public TbMicTema obtenerTemas(int idTema) throws ExcepcionesLogica;
	
	public void guardarTemas (TbMicTema tema) throws ExcepcionesLogica;
	
    public void actualizarTema (TbMicTema tema) throws ExcepcionesLogica;
    
    public List<TbMicTema> listarTemas () throws ExcepcionesLogica;
    
//    public int contarRegistros() throws ExcepcionesLogica;
    
    public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesLogica;

}

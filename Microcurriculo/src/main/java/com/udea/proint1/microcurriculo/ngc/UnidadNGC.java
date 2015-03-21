package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadNGC {

	public void guardarUnidades (TbMicUnidad unidad) throws ExcepcionesLogica;
	
    public void actualizarUnidades (TbMicUnidad unidad) throws ExcepcionesLogica;
    
    public TbMicUnidad obtenerUnidades(int idUnidad) throws ExcepcionesLogica;
    
    public List<TbMicUnidad> listarUnidades() throws ExcepcionesLogica;
    
//    public int contarRegistros() throws ExcepcionesLogica;
}

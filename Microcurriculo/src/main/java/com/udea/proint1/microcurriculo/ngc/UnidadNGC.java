package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadNGC {

	public void guardarUnidades (TbMicUnidad unidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
    public void actualizarUnidades (TbMicUnidad unidad) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public TbMicUnidad obtenerUnidades(int idUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicUnidad> listarUnidades() throws ExcepcionesLogica, ExcepcionesDAO;
    
//    public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
    
    public void eliminarUnidad(TbMicUnidad unidad) throws ExcepcionesLogica, ExcepcionesDAO;
}

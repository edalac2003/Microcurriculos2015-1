package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObservacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObservacionNGC {

	public TbMicObservacion obtenerObservacion (int id) throws ExcepcionesLogica;
	
	public void guardarObservacion (TbMicObservacion observacion) throws ExcepcionesLogica;
	
    public void actualizarObservacion (TbMicObservacion observacion) throws ExcepcionesLogica;
    
    public List<TbMicObservacion> listarObservacion () throws ExcepcionesLogica;
    
//    public int contarRegistros() throws ExcepcionesLogica;
	
}

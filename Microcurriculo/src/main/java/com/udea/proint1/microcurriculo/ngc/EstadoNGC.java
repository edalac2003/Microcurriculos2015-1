package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EstadoNGC {
	
	public TbMicEstado obtenerEstados (int idEstado) throws ExcepcionesLogica;
	
	public void guardarEstados (TbMicEstado estado) throws ExcepcionesLogica;
	
    public void actualizarEstados (TbMicEstado estado) throws ExcepcionesLogica;
    
    public List<TbMicEstado> listarEstados () throws ExcepcionesLogica;

    public List<TbMicEstado> obtenerEstadoxNombre(String nombre) throws ExcepcionesLogica;
}

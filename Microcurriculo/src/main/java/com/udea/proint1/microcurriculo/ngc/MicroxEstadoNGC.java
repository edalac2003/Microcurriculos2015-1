package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxEstadoNGC {
	
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica;
	
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica;
	
	public TbMicMicroxestado obtenerMicroxestado(int id) throws ExcepcionesLogica;
	
	public List<TbMicMicroxestado> listarMicroxestado() throws ExcepcionesLogica;
	
	public List<TbMicMicroxestado> listarMicrosxestado(int idEstado) throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;

}

package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxEstadoNGC {
	
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicMicroxestado obtenerMicroxestado(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicroxestado() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicrosxestado(int idEstado) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicrosxestadoxMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO, ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;

}

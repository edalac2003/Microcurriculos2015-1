package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MicroxEstadoDAO {
	
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesDAO;
	
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesDAO;
	
	public TbMicMicroxestado obtenerMicroxestado(int id) throws ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicroxestado() throws ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicrosxestado(TbMicEstado estado) throws ExcepcionesDAO;
	
	public List<TbMicMicroxestado> listarMicrosxestadoxMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
}

package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface EstadoDAO {
	
	public void guardarEstado(TbMicEstado estado) throws ExcepcionesDAO; 
	
	public TbMicEstado obtenerEstado(int idEstado) throws ExcepcionesDAO;
	
	public List<TbMicEstado> obtenerEstadoxNombre(String nombre) throws ExcepcionesDAO;
	
	public List<TbMicEstado> listarEstados() throws ExcepcionesDAO;
	
	public void actualizarEstado(TbMicEstado estado) throws ExcepcionesDAO;
}

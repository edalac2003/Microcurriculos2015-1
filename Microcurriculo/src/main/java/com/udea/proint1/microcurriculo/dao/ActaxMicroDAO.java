package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicActaxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ActaxMicroDAO {
	
	public void guardarActaxMicro(TbMicActaxmicro actaxMicro) throws ExcepcionesDAO;
	
	public TbMicActaxmicro obtenerActaxMicro(int id) throws ExcepcionesDAO;
	
	public List<TbMicActaxmicro> listarActaxMicro() throws ExcepcionesDAO;
	
	public void actualizarActaxMicro(TbMicActaxmicro actaxMicro) throws ExcepcionesDAO;
	
}

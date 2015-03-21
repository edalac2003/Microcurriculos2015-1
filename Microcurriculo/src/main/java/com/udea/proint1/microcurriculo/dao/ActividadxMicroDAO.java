package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicActividadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ActividadxMicroDAO {
	
	public void guardarActividadxMicro(TbMicActividadxmicro actividadxMicro) throws ExcepcionesDAO;
	
	public TbMicActividadxmicro obtenerActividadxMicro(int id) throws ExcepcionesDAO;
	
	public List<TbMicActividadxmicro> listarActividadxMicro() throws ExcepcionesDAO;
	
	public void actualizarActividadxMicro(TbMicActividadxmicro actividadxMicro) throws ExcepcionesDAO;
	
}

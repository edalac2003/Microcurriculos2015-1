package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmObservacionxtabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObservacionxTablaDAO {

	public void guardarObservacionxTabla(TbAdmObservacionxtabla observacionxTabla) throws ExcepcionesDAO;
	
	public TbAdmObservacionxtabla obtenerObservacionxTabla(int id) throws ExcepcionesDAO;
	
	public List<TbAdmObservacionxtabla> listarObservacionxTabla() throws ExcepcionesDAO;
	
	public void actualizarObservacionxTabla(TbAdmObservacionxtabla observacionxTabla) throws ExcepcionesDAO;
	
}

package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;;

public interface HistoricoNGC {
	
	public void guardarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public void modificarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public TbAdmHistorico obtenerHistorico(int id) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public List<TbAdmHistorico> listarHistoricos() throws ExcepcionesDAO, ExcepcionesLogica;
	
	public List<TbAdmHistorico> obtenerHistoricosxMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO, ExcepcionesLogica;

}

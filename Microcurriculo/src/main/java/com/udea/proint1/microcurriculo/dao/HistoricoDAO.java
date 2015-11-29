package com.udea.proint1.microcurriculo.dao;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbAdmArea;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface HistoricoDAO {
	
	public void guardarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO;
	
	public void modificarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO;
	
	public TbAdmHistorico obtenerHistorico(int id) throws ExcepcionesDAO;
	
	public List<TbAdmHistorico> listarHistoricos() throws ExcepcionesDAO;
	
	public List<TbAdmHistorico> obtenerHistoricosxMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;

}

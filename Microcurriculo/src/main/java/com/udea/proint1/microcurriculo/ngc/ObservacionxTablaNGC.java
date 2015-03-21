package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmObservacionxtabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObservacionxTablaNGC {

	public TbAdmObservacionxtabla obtenerObservacionxTabla (int id) throws ExcepcionesLogica;
	
	public void guardarObservacionxTabla (TbAdmObservacionxtabla observacionxtabla) throws ExcepcionesLogica;
	
    public void actualizarObservacionxTabla (TbAdmObservacionxtabla observacionxtabla) throws ExcepcionesLogica;
    
    public List<TbAdmObservacionxtabla> listarObservacionxTabla () throws ExcepcionesLogica;
	
}

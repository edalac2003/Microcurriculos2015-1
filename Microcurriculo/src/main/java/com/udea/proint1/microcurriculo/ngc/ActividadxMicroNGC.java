package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicActividadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ActividadxMicroNGC {

	public TbMicActividadxmicro obtenerActividadxmicro (int id) throws ExcepcionesLogica;
	
	public void guardarActividadxmicro (TbMicActividadxmicro actividadxmicro) throws ExcepcionesLogica;
	
    public void actualizarActividadxmicro (TbMicActividadxmicro actividadxmicro) throws ExcepcionesLogica;
    
    public List<TbMicActividadxmicro> listarActividadxmicro () throws ExcepcionesLogica;
	
}

package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemaxUnidadNGC {
	
	public TbMicTemaxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarTemasxUnidad (TbMicTemaxunidad temasxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
    public void actualizarTemaxUnidad (TbMicTemaxunidad temasxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicTemaxunidad> listarTemasxUnidad () throws ExcepcionesLogica, ExcepcionesDAO;
    
//    public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
    
    public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(int idUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
    
    public void eliminarTemaxUnidad(TbMicTemaxunidad temaxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;

}

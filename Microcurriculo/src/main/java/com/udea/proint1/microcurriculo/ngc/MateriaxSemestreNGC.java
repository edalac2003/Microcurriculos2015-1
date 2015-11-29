package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateriaxsemestre;
//import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriaxSemestreNGC {
	
	public void guardarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public void modificarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public TbAdmMateriaxsemestre obtenerMateriaxsemestre(int id) throws ExcepcionesDAO, ExcepcionesLogica;
	
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestre() throws ExcepcionesDAO, ExcepcionesLogica;
	
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestrexSemestre(String semestre) throws ExcepcionesDAO, ExcepcionesLogica;

}

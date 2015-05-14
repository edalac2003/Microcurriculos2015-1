package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateriaxsemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriaxSemestreDAO {
	
	public void guardarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO;
	
	public void modificarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO;
	
	public TbAdmMateriaxsemestre obtenerMateriaxsemestre(int id) throws ExcepcionesDAO;
	
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestre() throws ExcepcionesDAO;
	
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestrexSemestre(TbAdmSemestre semestre) throws ExcepcionesDAO;
	
}

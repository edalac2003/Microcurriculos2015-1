package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SubtemaxTemaDAO;
import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemaxTemaNGCImpl implements SubtemaxTemaNGC {
	
	private static Logger log=Logger.getLogger(SubtemaxTemaNGCImpl.class);

	SubtemaxTemaDAO subtemaxTemaDao;
	TemaDAO temaDao;
	
	public void setSubtemaxTemaDao(SubtemaxTemaDAO subtemaxTemaDao) {
		this.subtemaxTemaDao = subtemaxTemaDao;
	}

	public void setTemaDao(TemaDAO temaDao) {
		this.temaDao = temaDao;
	}

	@Override
	public void guardar(TbMicSubtemaxtema subtemaxTema)	throws ExcepcionesLogica, ExcepcionesDAO {
		
		if (subtemaxTema != null){
			try {
				subtemaxTemaDao.guardar(subtemaxTema);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al invocar el metodo guardar Subtema");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		} else{
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Subtema x Tema esta vacio");
			throw expLog;
		}

	}

	
	@Override
	public void modificar(TbMicSubtemaxtema subtemaxTema)
			throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema)
			throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema)
			throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema()
			throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(int idTema)
			throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicSubtemaxtema> listaSubtemasxtema = null;
		
		TbMicTema tema= null;
		
		try {
			tema = temaDao.obtenerTema(idTema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo buscar Subtemas x Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaSubtemasxtema = subtemaxTemaDao.listarSubtemaxTema_Tema(tema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Subtemas x Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaSubtemasxtema;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
//		int registro = 0;
//		
//		try {
//			registro = subtemaxTemaDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Se presentaron errores al Obtener el numero de registros de la tabla <SubtemaxTema>" + e.getMessage());
//		}
//		
//		return registro;
//	}
	
	@Override
	public void eliminarSubtemaxtema(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			subtemaxTemaDao.eliminarSubtemaxTema(subtemaxTema);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Subtema x Tema");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}

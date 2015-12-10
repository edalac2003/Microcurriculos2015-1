package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class EventosPanelDuplicarMicro extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(EventosPanelDuplicarMicro.class);
	
	Combobox cmbMicrocurriculo;
	Combobox cmbSemestre;
	
	MicrocurriculoNGC microcurriculoNGC;
	SemestreNGC semestreNGC;
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}
	
	public void onSelect$cmbMicrocurriculo(){
		String idMicro = cmbMicrocurriculo.getValue().toString();
		
		if(!idMicro.equals("")&&(!idMicro.equals("[Seleccione]"))){
			recargarSemestres(idMicro);
			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
		}else{
			Executions.getCurrent().getSession().removeAttribute("idMicro");
			cargarSemestres();
		}
	}
	
	private void cargarSemestres(){
		try {
			List<TbAdmSemestre> listaSemestre = semestreNGC.listarSemestres();
			cmbSemestre.getItems().clear();
			if (listaSemestre != null){
				cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
				for (TbAdmSemestre semestre : listaSemestre){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre.appendChild(item);
				}
				cmbSemestre.setValue("[Seleccione]");
			} else
				Messagebox.show("No se Encontraron Registros de Semestres");
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	public void recargarSemestres(String idMicrocurriculo){
		TbMicMicrocurriculo microcurriculo = null;
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria();
		
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		List<TbAdmSemestre> semestres = null;
		try {
			semestres = semestreNGC.listarSemestres();
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		cmbSemestre.getItems().clear();
		cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
		
		if(semestres != null){
			for(TbAdmSemestre semestre: semestres){
				boolean semestreOcupado = false;
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microRecorer: listaMicrocurriculos){
						if(idMateria.equals(microRecorer.getTbAdmMateria().getVrIdmateria())&&(semestre.getVrIdsemestre().equals(microRecorer.getTbAdmSemestre().getVrIdsemestre()))){
							semestreOcupado = true;
						}
					}
				}
				if(!semestreOcupado){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre.appendChild(item);
				}
			}
		}
		cmbSemestre.setValue("[Seleccione]");
	}
	
	public void onSelect$cmbSemestre(){
		String idSemestre = cmbSemestre.getValue().toString();
		
		if(!idSemestre.equals("")&&(!idSemestre.equals("[Seleccione]"))){
			Executions.getCurrent().getSession().setAttribute("semestre", idSemestre);
		}else{
			Executions.getCurrent().getSession().removeAttribute("semestre");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
	}
}

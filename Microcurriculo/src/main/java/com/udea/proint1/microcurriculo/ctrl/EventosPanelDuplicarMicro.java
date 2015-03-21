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
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EventosPanelDuplicarMicro extends GenericForwardComposer {

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
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarSemestres(String idMicrocurriculo){
		TbMicMicrocurriculo microcurriculo = null;
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria();
		
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		List<TbAdmSemestre> semestres = null;
		try {
			semestres = semestreNGC.listarSemestres();
		} catch (ExcepcionesLogica e) {
			logger.error(e);
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

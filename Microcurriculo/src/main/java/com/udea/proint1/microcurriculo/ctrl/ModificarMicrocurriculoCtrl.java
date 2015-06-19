package com.udea.proint1.microcurriculo.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;

public class ModificarMicrocurriculoCtrl extends GenericForwardComposer{
	
	TbMicMicrocurriculo microcurriculo = null;
	TbAdmMateria materia = null;
	
	Label lblIdMicrocurriculo;
	Label lblNombreDocente;
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreNucleo;
	Label lblNombreMateria;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	Label lblCampoFormacion;
	Label lblCorrequisitos;
	Label lblPrerrequisitos;
	Label lblProgramasVinculados;
	Label lblResumenMicro;
	Label lblPropositoMicro;
	Label lblJustificacionMicro;
	Label lblObjetivoGeneral;
	Label lblUsuarioLogin;
	Label lblFechaActual;
	
	
	Combobox cmbEstado;
	Combobox cmbMateria;
	
	
	private void mostrarInformación(){
		microcurriculo = (TbMicMicrocurriculo)Executions.getCurrent().getSession().getAttribute("microcurriculo");
		materia = microcurriculo.getTbAdmMateria();
		
		lblIdMicrocurriculo.setValue(microcurriculo.getVrIdmicrocurriculo());
		
		mostrarInformaciónMateria(materia);
	}
	
	private void mostrarInformaciónMateria(TbAdmMateria materia){
		/*Información de Materias */
		cmbMateria.setValue(materia.getVrIdmateria());
		lblCreditosMateria.setValue(String.valueOf(materia.getNbCreditos()));
		lblHtMateria.setValue(String.valueOf(materia.getNbHt()));
		lblHpMateria.setValue(String.valueOf(materia.getNbHp()));
		lblHtpMateria.setValue(String.valueOf(materia.getNbHtp()));
		lblHoraClaseSemestral.setValue(String.valueOf((materia.getNbHp()+materia.getNbHt()+materia.getNbHtp())*16));
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		mostrarInformación();
		
		
		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuarioLogin")){
//			extraerInformacion();
//			permisos();
		}else{
			Executions.getCurrent().sendRedirect("/index.zul");
		}
	}

}

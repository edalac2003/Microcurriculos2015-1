package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class ListadoMicroxDocenteCtrl extends GenericForwardComposer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Listbox listaMicrocurriculo;
	
	List<TbMicMicrocurriculo> listadoMicrocurriculo;
	
	
	MicrocurriculoNGC microcurriculoNGC;
	MateriaNGC materiaNGC;
	
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}


	
	
	public void listarMicrocurriculos(){
		TbAdmPersona persona = new TbAdmPersona();
		persona.setVrIdpersona("92532121");
		persona.setVrApellidos("ACOSTA BRAVO");
		persona.setVrNombres("EDWIN ALFREDO");
		try {
			listadoMicrocurriculo = microcurriculoNGC.listarMicrocurriculosPorResponsable("92532121");
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ((listadoMicrocurriculo != null)){
			listaMicrocurriculo.getItems().clear();
			
			for(TbMicMicrocurriculo micro : listadoMicrocurriculo){
//				final Listitem listaItem = new Listitem();				
//				Listcell celdaID = new Listcell(micro.getVrIdmicrocurriculo());
//				Listcell celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrAlias());
//				Listcell celdaMateria = new Listcell(micro.getTbAdmMateria().getVrAlias());
//				Listcell celdaEstado = new Listcell(micro.getTbMicEstado().getVrDescripcion());
//				
//				listaItem.appendChild(celdaID);
//				listaItem.appendChild(celdaNucleo);
//				listaItem.appendChild(celdaID);
//				listaItem.appendChild(celdaEstado);
//				
//				listaMicrocurriculo.appendChild(listaItem);
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		
		super.doAfterCompose(comp);
		
		listarMicrocurriculos();
	}
}

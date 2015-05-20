package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class ListadoMicroxDocenteCtrl extends GenericForwardComposer{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Objetos de la Vista
	 */
	Listbox listaMicrocurriculo;
	Label lblFechaActual;
	Label lblNombreDocente;
	Label lblUsuarioLogin;
	
	/*
	 * Variables locales
	 */
	List<TbMicMicrocurriculo> listadoMicrocurriculo = null;
	private static Date fechaActual = new Date();
	String userName;
	String nombrePersona;
	String apellidoPersona;
	
	
	/*
	 * Clases Relacionadas
	 */
	MicrocurriculoNGC microcurriculoNGC;
	MateriaNGC materiaNGC;
	
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	
	
	private void cargarDatosEncabezado(){
		lblFechaActual.setValue(fechaActual.toString());
		userName = Executions.getCurrent().getSession().getAttribute("userName").toString();
		nombrePersona = Executions.getCurrent().getSession().getAttribute("nombrePersona").toString();
		apellidoPersona = Executions.getCurrent().getSession().getAttribute("apellidoPersona").toString();
		
		lblNombreDocente.setValue(nombrePersona+" "+apellidoPersona);
		lblUsuarioLogin.setValue(userName);
	}
	
	private void listarMicrocurriculos(){		
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
				final Listitem listaItem = new Listitem();
				listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						mostrarMicrocurriculo(listadoMicrocurriculo.get(listaMicrocurriculo.getSelectedIndex()));
					}
				});
				Listcell celdaNucleo = null;
				Listcell celdaMateria = null;
				Listcell celdaID = new Listcell(micro.getVrIdmicrocurriculo());
				if (micro.getTbAdmMateria().getTbAdmNucleo().getVrAlias() != null)
					celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrAlias());
				else
					celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
				
				if(micro.getTbAdmMateria().getVrAlias() != null)
					celdaMateria = new Listcell(micro.getTbAdmMateria().getVrAlias());
				else
					celdaMateria = new Listcell(micro.getTbAdmMateria().getVrNombre());
				
				Listcell celdaEstado = new Listcell(micro.getTbMicEstado().getVrDescripcion());				
				listaItem.appendChild(celdaID);
				listaItem.appendChild(celdaNucleo);
				listaItem.appendChild(celdaMateria);
				listaItem.appendChild(celdaEstado);				
				listaMicrocurriculo.appendChild(listaItem);
			}
		}
	}
	
	
	private static void mostrarMicrocurriculo(TbMicMicrocurriculo microcurriculo){
		Executions.getCurrent().setAttribute("micro", microcurriculo);
		Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarDatosEncabezado();
		listarMicrocurriculos();
	}
}

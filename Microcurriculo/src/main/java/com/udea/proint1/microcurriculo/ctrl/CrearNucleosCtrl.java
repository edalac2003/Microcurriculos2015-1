package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.DocentexDependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarNucleoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class CrearNucleosCtrl extends GenericForwardComposer {
	
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CrearNucleosCtrl.class);
	private static String modUsuario = "SYSTEM";
	private static Date modFecha = new Date();
	
	
	Tabbox tabOpciones;
	
	Label lblUsuarioLogin;
	Label lblFechaActual;
	
	Listbox listaUnidadAcademica;
	Listbox listaNuevasUnidades;
	Listbox listaDependenciaAcademica;
	Listbox listaNuevasDependencias;
	Listbox listaNucleoAcademico;
	Listbox listaNuevosNucleos;
	Listbox listaAreaAcademica;
	Listbox listaNuevasAreas;
	
	Textbox txtNombreUnidadAcademica;
	Textbox txtAliasUnidadAcademica;
	Textbox txtNuevoNombreUnidadAcademica;
	Textbox txtNuevoAliasUnidadAcademica;
	Textbox txtNombreDependenciaAcademica;
	Textbox txtNuevoNombreDependenciaAcademica;
	Textbox txtNuevoAliasDependenciaAcademica;
	Textbox txtAliasDependenciaAcademica;
	
	Textbox txtNombreNucleo;
	Textbox txtNuevoNucleoAcademico;
	Textbox txtAliasNucleo;
	Textbox txtNuevoAliasNucleo;
	
	Textbox txtNombreAreaAcademica;
	Textbox txtNuevoAreaAcademica;
	Textbox txtAliasAreaAcademica;
	Textbox txtNuevoAliasAreaAcademica;
	
//	Textbox txtBuscarUnidad;
	Textbox txtIdUnidadAcademica;
	Textbox txtIdDependencia;
	Textbox txtUnidadAcademica;
	Textbox txtDependencia;
	
	
	Textbox txtNucleo;
	
//	Textbox txtNuevoAreaAcademica;
		
	
	Textbox txtBuscarDependencia;
	Textbox txtBuscarNucleo;
	Textbox txtPreIdDependencia;
	Textbox txtPreIdNucleo;
	Textbox txtIdNucleo;
	Textbox txtPreIdArea;
	Textbox txtIdArea;
	
	Button btnCambiarNombreUnidad;
	Button btnAdicionarNombreUnidad;
	Button btnCambiarNombreDependencia;
	Button btnAdicionarNombreDependencia;
	Button btnBuscarDependencia;
	Button btnCambiarNombreNucleo;
	Button btnAdicionarNombreNucleo;
	Button btnCambiarNombreArea;
	Button btnAdicionarNombreArea;
	
	
	Combobox cmbUnidadAcademica;
	Combobox cmbUnidadAcademica2;
	Combobox cmbUnidadAcademica3;
	Combobox cmbUnidadAcademica4;
	Combobox cmbUnidadAcademica5;
	Combobox cmbUnidadAcademica6;
	Combobox cmbDependencia;
	Combobox cmbDependencia2;
	Combobox cmbDependencia3;
	Combobox cmbDependencia4;
	Combobox cmbNucleo;
	Combobox cmbNucleo2;
	Combobox cmbResponsableUnidad;
	Combobox cmbResponsableDependencia;
	Combobox cmbResponsableNucleo;
	Combobox cmbResponsableArea;
	
	
	Menuitem opcionGuardarNucleo;
	
		
	private static List<TbAdmUnidadAcademica> listadoUnidadAcademica;
	private static List<TbAdmDependencia> listadoDependencia;
	private static List<TbAdmNucleo> listadoNucleo;
	private static List<TbAdmUnidadAcademica> listadoNuevoUnidadAcademica;
	private static List<TbAdmDependencia> listadoNuevoDependencia;
	private static List<TbAdmNucleo> listadoNuevoNucleo;
	private static List<TbAdmUnidadAcademica> listaTotalUnidades;
	private static List<TbAdmDependencia> listaTotalDependencias;
	private static List<TbAdmNucleo> listaTotalNucleos;
	@SuppressWarnings("unused")
	private static List<TbAdmDocentexDependencia> listadoResponsables;
	private static List<TbAdmPersona> listadoPersonas;

	TbAdmUnidadAcademica unidadAcademica;
	TbAdmDependencia dependenciaAcademica;
	TbAdmNucleo nucleoAcademico;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	GuardarNucleoNGC guardarNucleoNGC;
	PersonaNGC personaNGC;
	DocentexDependenciaNGC docentexDependenciaNGC;
	
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	public void setGuardarNucleoNGC(GuardarNucleoNGC guardarNucleoNGC) {
		this.guardarNucleoNGC = guardarNucleoNGC;
	}

	public void setDocentexDependenciaNGC(DocentexDependenciaNGC docentexDependenciaNGC) {
		this.docentexDependenciaNGC = docentexDependenciaNGC;
	}
	
	private List<TbAdmUnidadAcademica> empaquetarUnidades(List<TbAdmUnidadAcademica> lista1, List<TbAdmUnidadAcademica> lista2){
		List<TbAdmUnidadAcademica> lista = null;
		if((lista1 != null && (lista1.size() >0)) || (lista2 != null && (lista2.size() > 0))){
			lista = new ArrayList<TbAdmUnidadAcademica>();
			if (lista1 != null){
				for (TbAdmUnidadAcademica unidad : lista1)
					lista.add(unidad);
			}
			
			if ((lista2 != null) && (lista2.size() >0)){
				for (TbAdmUnidadAcademica unidad : lista2)
					lista.add(unidad);
			}
		}
		
		return lista;
	}
	
	
	private List<TbAdmDependencia> empaquetarDependencias(List<TbAdmDependencia> lista1, List<TbAdmDependencia> lista2){
		List<TbAdmDependencia> lista = null;
		if ((lista1 != null && (lista1.size() > 0)) || (lista2 != null && (lista2.size() > 0))){
			lista = new ArrayList<TbAdmDependencia>();
			if (lista1 != null){
				for(TbAdmDependencia dependencia : lista1)
					lista.add(dependencia);
			}
			
			if ((lista2 != null) && (lista2.size() > 0)){
				for(TbAdmDependencia dependencia : lista2)
					lista.add(dependencia);
			}
		}		
		return lista;
	}
	
	
	
	private List<TbAdmNucleo> empaquetarNucleos(List<TbAdmNucleo> lista1, List<TbAdmNucleo> lista2){
		List<TbAdmNucleo> lista = null;
		
		if((lista1 != null) || (lista2 != null)){
			lista = new ArrayList<TbAdmNucleo>();
			if (lista1 != null){
				for (TbAdmNucleo nucleo : lista1)
					lista.add(nucleo);
			}
			
			if (lista2 != null){
				for (TbAdmNucleo nucleo : lista2)
					lista.add(nucleo);
			}
		}
		
		return lista;
	}
	private void limpiarCombos(){
		listaUnidadAcademica.getItems().clear();
		cmbUnidadAcademica.getItems().clear();
		cmbUnidadAcademica2.getItems().clear();
		cmbUnidadAcademica3.getItems().clear();
		cmbUnidadAcademica4.getItems().clear();
		cmbUnidadAcademica5.getItems().clear();
		cmbUnidadAcademica6.getItems().clear();
		cmbResponsableUnidad.getItems().clear();
		cmbResponsableDependencia.getItems().clear();
		cmbResponsableNucleo.getItems().clear();
		cmbResponsableArea.getItems().clear();
	}
	
	private void cargarListaUnidades(){
//		final Listitem item = new Listitem();
		try {
			listadoUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			e.printStackTrace();
		}
		
		limpiarCombos();
		
		if(listadoUnidadAcademica != null){
			for(TbAdmUnidadAcademica unidad : listadoUnidadAcademica){
				listaUnidadAcademica.appendItem(unidad.getVrIdunidad()+" - "+unidad.getVrNombre(), unidad.getVrIdunidad());
				cmbUnidadAcademica.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica2.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica3.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica4.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica5.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica6.appendItem(unidad.getVrNombre());
			}
		}		
	}
	
	private void recargarListaUnidadAcademica(int llamado){		
		listaUnidadAcademica.getItems().clear();
		cmbUnidadAcademica.getItems().clear();
		cmbUnidadAcademica2.getItems().clear();
		cmbUnidadAcademica3.getItems().clear();
		cmbUnidadAcademica4.getItems().clear();
		cmbUnidadAcademica5.getItems().clear();
		cmbUnidadAcademica6.getItems().clear();
		
		if (llamado == 0){
			try {
				listadoUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();
			} catch (ExcepcionesLogica e) {
				e.printStackTrace();
			} catch (ExcepcionesDAO e) {
				e.printStackTrace();
			}
		}
		
		
		if(listadoUnidadAcademica != null){
			for(TbAdmUnidadAcademica unidad : listadoUnidadAcademica){
				listaUnidadAcademica.appendItem(unidad.getVrIdunidad()+" - "+unidad.getVrNombre(), unidad.getVrIdunidad());
				cmbUnidadAcademica.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica2.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica3.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica4.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica5.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica6.appendItem(unidad.getVrNombre());
			}
		}
	}
	
	private void recargarListaDependencia(int llamado){
		listaDependenciaAcademica.getItems().clear();
		
		if (llamado == 0){
			try {
				listadoDependencia = dependenciaNGC.listarDependencias();
			} catch (ExcepcionesLogica e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionesDAO e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(listadoDependencia != null){
			for (TbAdmDependencia item : listadoDependencia){
				listaDependenciaAcademica.appendItem(item.getVrIddependencia()+" - "+item.getVrNombre(), item.getVrIddependencia());
			}
		}
	}
	
	private void cargarDependencias(int llamado){
		if (llamado == 0){
			try {
				listadoDependencia = dependenciaNGC.listarDependencias();
			} catch (ExcepcionesLogica e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionesDAO e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		listaDependenciaAcademica.getItems().clear();
		cmbDependencia.getItems().clear();
		cmbDependencia2.getItems().clear();
		cmbDependencia3.getItems().clear();
		cmbDependencia4.getItems().clear();
		if (listadoDependencia != null){
			for(TbAdmDependencia item : listadoDependencia){
				listaDependenciaAcademica.appendItem(item.getVrIddependencia()+" - "+item.getVrNombre(), item.getVrIddependencia());
				cmbDependencia.appendItem(item.getVrNombre());
				cmbDependencia2.appendItem(item.getVrNombre());
				cmbDependencia3.appendItem(item.getVrNombre());
				cmbDependencia4.appendItem(item.getVrNombre());
			}
		}
	}
	
	
	private void cargarListaDependenciasPorUnidad(TbAdmUnidadAcademica unidad, int token){
		try {
			listadoDependencia = dependenciaNGC.listarDependenciasPorUnidad(unidad);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
			
		if(listadoDependencia != null){	
			//Se limpian los combos o listas dependiendo de quien haga el llamado
			
			switch (token) {
			case 1:
				listaDependenciaAcademica.getItems().clear();
				break;
			case 2:
				cmbDependencia.getItems().clear();
				cmbDependencia.setText("");
				break;
			case 3:
				cmbDependencia2.getItems().clear();
				cmbDependencia2.setText("");
				break;
			case 4:
				cmbDependencia3.getItems().clear();
				cmbDependencia3.setText("");
				break;
			case 5:
				cmbDependencia4.getItems().clear();
				cmbDependencia4.setText("");
				break;
			default:
				break;
			}
			
			for(TbAdmDependencia dependencia : listadoDependencia){
				switch (token) {
				case 1:					
					listaDependenciaAcademica.appendItem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre(), dependencia.getVrIddependencia());
					break;
				case 2:					
					cmbDependencia.appendItem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
					break;					
				case 3:
					cmbDependencia2.appendItem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
					break;
				case 4:
					cmbDependencia3.appendItem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
					break;
				case 5:
					cmbDependencia4.appendItem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
					break;
				default:
					break;
				}				
			}
		}
	}
	
	
	private void cargarNucleos(){
		try {
			listadoNucleo = nucleoNGC.listarNucleos();
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaNucleoAcademico.getItems().clear();
//		cmbNucleo.getItems().clear();
//		cmbNucleo2.getItems().clear();
//		cmbNucleo.setText("");
//		cmbNucleo2.setText("");
		
		if (listadoNucleo != null){
			for (TbAdmNucleo item : listadoNucleo){
				listaNucleoAcademico.appendItem(item.getVrIdnucleo()+" - "+item.getVrNombre(), item.getVrIdnucleo());
//				cmbNucleo.appendItem(item.getVrNombre());
//				cmbNucleo2.appendItem(item.getVrNombre());
			}
		}		
	}
	
	
	private void cargarNucleoPorDependencia(TbAdmDependencia dependencia, int token){
		try {
			listadoNucleo = nucleoNGC.listarNucleosPorDependencia(dependencia);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (token) {
		case 1:
			listaNucleoAcademico.getItems().clear();
			break;
		case 2:
			cmbNucleo.getItems().clear();
			break;
		case 3:
			cmbNucleo2.getItems().clear();
			break;
		default:
			break;
		}		
		
		if (listadoNucleo != null){
			for(TbAdmNucleo item : listadoNucleo){				
				switch (token) {
				case 1:
					listaNucleoAcademico.appendItem(item.getVrIdnucleo() + " - " + item.getVrNombre(), item.getVrIdnucleo());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
					break;
				case 2:
					cmbNucleo.appendItem(item.getVrIdnucleo()+ " - "+ item.getVrNombre());
					break;
				case 3:
					cmbNucleo2.appendItem(item.getVrIdnucleo()+ " - "+ item.getVrNombre());
					break;
				default:
					break;
				}
				
			}
		}		
	}
	

	
	private void recargarListaNucleo(int llamado){		
		if (llamado == 0){
			try {
				listadoNucleo = nucleoNGC.listarNucleos();
			} catch (ExcepcionesLogica e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionesDAO e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if( (listadoNucleo != null) && (listadoNucleo.size() > 0)){
			listaNucleoAcademico.getItems().clear();
			for(TbAdmNucleo item : listadoNucleo){
				listaNucleoAcademico.appendItem(item.getVrIdnucleo()+" - "+item.getVrNombre(), item.getVrIdnucleo());
			}
		}
	}

	private void copiarNombreUnidadAcademica(TbAdmUnidadAcademica unidad){
		txtNuevoNombreUnidadAcademica.setText(unidad.getVrNombre());
		txtNuevoAliasUnidadAcademica.setText(unidad.getVrAlias());
	}
	
	private void copiarDependenciaAcademica(TbAdmDependencia dependencia){
		txtUnidadAcademica.setText(dependencia.getTbAdmUnidadAcademica().getVrNombre());
		txtNuevoNombreDependenciaAcademica.setText(dependencia.getVrNombre());		
		txtNuevoAliasDependenciaAcademica.setText(dependencia.getVrAlias());
	}
	
	private void copiarNucleoAcademico(TbAdmNucleo nucleo){
		txtDependencia.setText(nucleo.getTbAdmDependencia().getVrNombre());
		txtNuevoNucleoAcademico.setText(nucleo.getVrNombre());
	}
	
	private void eliminaListItem(Listitem item){
		item.detach();
		txtNombreUnidadAcademica.focus();
	}
	
	private void adicionarUnidad(String id, String unidad, String alias, TbAdmPersona responsable){		
		final Listitem item = new Listitem();
		if (listadoNuevoUnidadAcademica == null){
			listadoNuevoUnidadAcademica = new ArrayList<TbAdmUnidadAcademica>();
			
		}
		if (!id.isEmpty() && (!existeIDUnidad(id))){			
			if ((!unidad.isEmpty()) && (!existeUnidad(unidad))){				
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						eliminaListItem(item);
					}
				});
				unidadAcademica = new TbAdmUnidadAcademica(id, unidad, responsable, alias, modUsuario, modFecha);			
				listadoNuevoUnidadAcademica.add(unidadAcademica);
				
				Listcell celda = new Listcell(id+" - "+unidad+" - "+alias);
				item.appendChild(celda);
				listaNuevasUnidades.appendChild(item);
				txtIdUnidadAcademica.setText("");
				txtAliasAreaAcademica.setText("");
				txtNombreUnidadAcademica.setText("");
				txtNombreUnidadAcademica.focus();				
			}else{
				Messagebox.show("El Nombre de la Unidad Academica ya Existe en uno de los Listados o el Contenido está Vacio.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
				txtNombreDependenciaAcademica.focus();
			}							
		}	else {
				Messagebox.show("El Código de la Unidad Academica ya Existe en uno de los Listados o el Contenido está Vacio.  \nPor favor verifique el Código.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			
			txtIdDependencia.focus();
		}			
	}
	
	private void adicionarDependencia(String dependencia, TbAdmUnidadAcademica unidad){
		String codigo = txtPreIdDependencia.getText().trim().toUpperCase() +txtIdDependencia.getText().trim().toUpperCase();
				
		if ((!codigo.isEmpty()) && (!existeIdDependencia(codigo))){
			if ((!dependencia.isEmpty()) && (!existeDependencia(dependencia))){
				final Listitem item = new Listitem();
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						eliminaListItem(item);
					}
				});
				
				if(listadoNuevoDependencia == null){
					listadoNuevoDependencia = new ArrayList<TbAdmDependencia>();
				}
					
				dependenciaAcademica = new TbAdmDependencia(codigo,unidad,dependencia,modUsuario,modFecha);
				listadoNuevoDependencia.add(dependenciaAcademica);
				Listcell celda = new Listcell(codigo +" - "+dependencia);
				item.appendChild(celda);
				listaNuevasDependencias.appendChild(item);
				txtIdDependencia.setText("");
				txtNombreDependenciaAcademica.setText("");
				txtAliasDependenciaAcademica.setText("");
				txtIdDependencia.focus();
			} else {
				Messagebox.show("El Nombre de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			}
		} else {			
			Messagebox.show("El Codigo de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre..",
					"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}
	
	private void adicionarNucleo(String nucleo, TbAdmDependencia dependencia){
		String codigo = txtPreIdNucleo.getText().trim().toUpperCase()+txtIdNucleo.getText().trim().toUpperCase();
			
		if((!codigo.isEmpty()) && (!existeIdNucleo(codigo))){
			if((!nucleo.isEmpty()) && (!existeNucleo(nucleo))){
				final Listitem item = new Listitem();
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						eliminaListItem(item);
					}
				});
				
				if (listadoNuevoNucleo == null){
					listadoNuevoNucleo = new ArrayList<TbAdmNucleo>();
				}
				
				nucleoAcademico = new TbAdmNucleo(codigo, dependencia, nucleo, modUsuario, modFecha);
				nucleoAcademico.setVrAlias(txtAliasNucleo.getText().toUpperCase());
				listadoNuevoNucleo.add(nucleoAcademico);
				
				Listcell celda = new Listcell(codigo +" - "+nucleo);
				item.appendChild(celda);				
				listaNuevosNucleos.appendChild(item);
				txtIdNucleo.setText("");
				txtNombreNucleo.setText("");
				txtAliasNucleo.setText("");
				txtIdNucleo.focus();
			} else {
				Messagebox.show("El Nombre del Nucleo Academico ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			}
		} else {
			Messagebox.show("El Codigo del Nucleo Academico ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
					"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
		}		
	}
	
	
	private void cambiarNombreUnidad(String unidad){		
		if(listaUnidadAcademica.getSelectedIndex() >=0){
//			!existeUnidad(unidad) && 
			if(((unidad.length() > 0))){
				unidadAcademica.setVrNombre(txtNuevoNombreUnidadAcademica.getText().toUpperCase());
				unidadAcademica.setVrAlias(txtNuevoAliasUnidadAcademica.getText().toUpperCase());
				listadoUnidadAcademica.set(listaUnidadAcademica.getSelectedIndex(), unidadAcademica);
				recargarListaUnidadAcademica(1);
				txtNuevoNombreUnidadAcademica.setText("");
				txtNuevoAliasUnidadAcademica.setText("");
			}else{
				Messagebox.show("El Nombre de la Unidad Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			}	
		} else{
			Messagebox.show("Para cambiar el nombre de una Unidad Académica, primero debe seleccionar un elemento de la Lista.\n Operación Anulada.",
					"SIN SELECCION",Messagebox.OK,Messagebox.ON_ABORT);
		}							
	}
	
	
	private void cambiarNombreDependencia(String dependencia){
		if(listaDependenciaAcademica.getSelectedIndex() >= 0){
			if ((!existeDependencia(dependencia)) && (!dependencia.isEmpty())){
//				dependenciaAcademica.setVrNombre(txtNuevoNombreDependenciaAcademica.getText().toUpperCase());
				dependenciaAcademica.setVrNombre(dependencia.trim().toUpperCase());
				listadoDependencia.set(listaDependenciaAcademica.getSelectedIndex(), dependenciaAcademica);
				recargarListaDependencia(1);
				txtNuevoNombreDependenciaAcademica.setText("");
				txtUnidadAcademica.setText("");
				txtBuscarDependencia.focus();
			} else{
				Messagebox.show("El Nombre de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			}
	
		}else {
			Messagebox.show("Para cambiar el nombre de una Dependencia Académica, primero debe seleccionar un elemento de la Lista.\n Operación Anulada.",
					"SIN SELECCION",Messagebox.OK,Messagebox.ON_ABORT);
		}
	}
	
	public void cambiarNombreNucleo(String nucleo){
		if (listaNucleoAcademico.getSelectedIndex() >= 0){
			if (!nucleo.isEmpty()){
				nucleoAcademico.setVrNombre(nucleo.trim().toUpperCase());
				nucleoAcademico.setVrAlias(txtNuevoAliasNucleo.getText().toUpperCase().trim());
				listadoNucleo.set(listaNucleoAcademico.getSelectedIndex(), nucleoAcademico);
				recargarListaNucleo(1);
				txtNuevoNucleoAcademico.setText("");
				txtDependencia.setText("");
				txtBuscarNucleo.focus();
			} else {
				Messagebox.show("El Nombre del Nucleo Académico ya Existe en uno de los Listados.  \nPor favor verifique el nombre.",
						"REGISTRO EXISTENTE",Messagebox.OK,Messagebox.EXCLAMATION);
			}
		} else {
			Messagebox.show("Para cambiar el nombre de un Nucleo Académico, primero debe seleccionar un elemento de la Lista.\n Operación Anulada.",
					"SIN SELECCION",Messagebox.OK,Messagebox.EXCLAMATION);
		}
		
	}
	
	
	private boolean existeUnidad(String unidad){
		boolean estado = false;
		
		estado = buscarNombreUnidadAcademica(listadoUnidadAcademica, unidad);		
		if (!estado){
			estado = buscarNombreUnidadAcademica(listadoNuevoUnidadAcademica, unidad);
		}
		
		return estado;
	}
	
	
	private boolean existeIDUnidad(String id){
		boolean estado = false;
		
		if(listadoUnidadAcademica.size() >0&& (listadoUnidadAcademica != null)){
			estado = buscarIDUnidadAcademica(listadoUnidadAcademica, id);
		}
				
		if (!estado){
			if (listadoNuevoUnidadAcademica.size() >0 && (listadoNuevoUnidadAcademica != null))
				estado = buscarIDUnidadAcademica(listadoNuevoUnidadAcademica, id);
		}
		
		return estado;
	}
	

	
	private boolean existeDependencia(String dependencia){
		boolean estado = false;
		
		estado = buscarNombreDependencia(listadoDependencia, dependencia);
		if (!estado){
			estado = buscarNombreDependencia(listadoNuevoDependencia, dependencia);
		}
		
		return estado;
	}
	
	private boolean existeIdDependencia(String id){
		boolean estado = false;
		estado = buscarIdDependencia(listadoDependencia, id);
		if(!estado) {
			estado = buscarIdDependencia(listadoNuevoDependencia, id);
		}
		return estado;
	}
	
	
	private boolean buscarNombreDependencia(List<TbAdmDependencia> lista, String nombre){
		boolean  estado = false;
		if ((lista != null) && (lista.size()>0)){
			for(TbAdmDependencia item : lista){
				if (nombre.equals(item.getVrNombre())){
					estado=true;
					break;
				}
			}
		}
		return estado;
	}
	
	
	private boolean existeNucleo(String nucleo){
		boolean estado = false;
		
		estado = buscarNombreNucleo(listadoNucleo, nucleo);
		if (!estado){
			estado = buscarNombreNucleo(listadoNuevoNucleo, nucleo);
		}
		
		return estado;
	}
	
	private boolean existeIdNucleo(String id){
		boolean estado = false;
		estado = buscarIdNucleo(listadoNucleo, id);
		if(!estado) {
			estado = buscarIdNucleo(listadoNuevoNucleo, id);
		}
		return estado;
	}
	
	
	private boolean buscarNombreNucleo(List<TbAdmNucleo> lista, String nombre){
		boolean  estado = false;
		if ((lista != null) && (lista.size()>0)){
			for(TbAdmNucleo item : lista){
				if (nombre.equals(item.getVrNombre())){
					estado=true;
					break;
				}
			}
		}
		return estado;
	}
	
	
	private boolean buscarNombreUnidadAcademica(List<TbAdmUnidadAcademica> lista, String unidad){
		boolean estado = false;
		if((lista != null) && (lista.size() > 0)){
			for(TbAdmUnidadAcademica item : lista){
				if(unidad.equals(item.getVrNombre())){
					estado=true;
					break;
				}
			}
		}
		return estado;	
	}
	
	private boolean buscarIDUnidadAcademica(List<TbAdmUnidadAcademica> lista, String id){
		boolean estado = false;
		for(TbAdmUnidadAcademica unidad : lista){
			if(id.equals(unidad.getVrIdunidad())){
				estado=true;
				break;
			}				
		}		
		return estado;	
	}
	
	private boolean buscarIdDependencia(List<TbAdmDependencia> lista, String id){
		boolean estado = false;
		if((lista != null) && (lista.size() > 0)){
			for (TbAdmDependencia item : lista){
				if(id.equals(item.getVrIddependencia())){
					estado=true;
					break;
				}
			}
		}		
		return estado;
	}
	
	private boolean buscarIdNucleo(List<TbAdmNucleo> lista, String id){
		boolean estado = false;
		if ((lista != null) && (lista.size() > 0)){
			for (TbAdmNucleo item : lista){
				if(id.equals(item.getVrIdnucleo())){
					estado=true;
					break;
				}
			}
		}
		
		return estado;
	}
	
	private void cargarListadoResponsables(){
//		try {
//			listadoResponsables = docentexDependenciaNGC.listarDocentesxDependencia();
//		} catch (ExcepcionesLogica e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			listadoPersonas = personaNGC.listarPersonas();
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (listadoPersonas != null){
			for (TbAdmPersona docente : listadoPersonas){
				String nombresDocente = docente.getVrNombres()+" "+docente.getVrApellidos();
				cmbResponsableUnidad.appendItem(nombresDocente);
				cmbResponsableDependencia.appendItem(nombresDocente);
				cmbResponsableNucleo.appendItem(nombresDocente);
				cmbResponsableArea.appendItem(nombresDocente);
			}
		}
	}
	
	private void guardarRegistros(){
		listaTotalUnidades = empaquetarUnidades(listadoUnidadAcademica, listadoNuevoUnidadAcademica);
		listaTotalDependencias = empaquetarDependencias(listadoDependencia, listadoNuevoDependencia);
		listaTotalNucleos = empaquetarNucleos(listadoNucleo, listadoNuevoNucleo);
		
		if(((listaTotalUnidades != null) &&(listaTotalUnidades.size()>0)) || ((listaTotalDependencias != null) && (listaTotalDependencias.size() > 0)) 
				|| ((listaTotalNucleos != null) && (listaTotalNucleos.size() > 0))){
			if((listaTotalUnidades != null) && (listaTotalUnidades.size() > 0)){
				try {
					unidadAcademicaNGC.guardarListadoUnidad(listaTotalUnidades);
				} catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("",exp.getMessage(), Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				listaNuevasUnidades.getItems().clear();
				listadoNuevoUnidadAcademica = null;
				listadoUnidadAcademica = null;
				recargarListaUnidadAcademica(0);
			} 
			
			if ((listaTotalDependencias != null) && (listaTotalDependencias.size() > 0)){
				try {
					dependenciaNGC.guardarListadoDependencia(listaTotalDependencias);
				} catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("",exp.getMessage(), Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				listaNuevasDependencias.getItems().clear();
				listadoNuevoDependencia = null;
				listadoDependencia = null;
				recargarListaDependencia(0);				
			}
			
			if ((listaTotalNucleos != null) && (listaTotalNucleos.size() > 0)){
				try {
					nucleoNGC.guardarListadoNucleo(listaTotalNucleos);
				} catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("",exp.getMessage(), Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				listaNuevosNucleos.getItems().clear();
				listadoNuevoNucleo = null;
				listadoNucleo = null;
				recargarListaNucleo(0);				
			}			
			Messagebox.show("Registros Guardados Satisfactoriamente.", "ALMACENADO",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}
	
	//EVENTOS DE OBJETOS
	
//	public void onOK$txtNombreUnidadAcademica(){
//		String id = txtIdUnidadAcademica.getText().toUpperCase();
//		String nombreUnidad = txtNombreUnidadAcademica.getText().toUpperCase();
//		adicionarUnidad(id,nombreUnidad);
//	}		
	
	public void onOK$txtIdUnidadAcademica(){
		if(!txtIdUnidadAcademica.getText().isEmpty()){
			txtNombreUnidadAcademica.focus();
		}
	}
	
	public void onSelect$listaUnidadAcademica(){
		unidadAcademica = listadoUnidadAcademica.get(listaUnidadAcademica.getSelectedIndex());
		copiarNombreUnidadAcademica(unidadAcademica);
	}	
	
	public void onSelect$listaDependenciaAcademica(){
		dependenciaAcademica = listadoDependencia.get(listaDependenciaAcademica.getSelectedIndex());
		copiarDependenciaAcademica(dependenciaAcademica);
	}
	
	public void onSelect$listaNucleoAcademico(){
		nucleoAcademico = listadoNucleo.get(listaNucleoAcademico.getSelectedIndex());
		copiarNucleoAcademico(nucleoAcademico);
	}
	
	public void onOK$txtNuevoNombreUnidadAcademica(){
		cambiarNombreUnidad(txtNuevoNombreUnidadAcademica.getText().toUpperCase().trim());
	}
	
	public void onOK$txtNuevoNombreDependenciaAcademica(){
		cambiarNombreDependencia(txtNuevoNombreDependenciaAcademica.getText().trim().toUpperCase());
	}
	
	public void onOK$txtNuevoNucleoAcademico(){
		cambiarNombreNucleo(txtNuevoNucleoAcademico.getText().trim().toUpperCase());
	}
	
	public void onClick$btnCambiarNombreUnidad(){
		cambiarNombreUnidad(txtNuevoNombreUnidadAcademica.getText().toUpperCase().trim());
	}
	
	public void onClick$btnCambiarNombreDependencia(){
		cambiarNombreDependencia(txtNuevoNombreDependenciaAcademica.getText().trim().toUpperCase());
	}
	
	public void onClick$btnCambiarNombreNucleo(){
		cambiarNombreNucleo(txtNuevoNucleoAcademico.getText().toUpperCase().trim());
	}
	
	public void onSelect$cmbDependencia(){
		dependenciaAcademica = listadoDependencia.get(cmbDependencia.getSelectedIndex());
		cargarNucleoPorDependencia(dependenciaAcademica, 1);
	}
	
	public void onSelect$cmbDependencia4(){
		dependenciaAcademica = listadoDependencia.get(cmbDependencia4.getSelectedIndex());
		cargarNucleoPorDependencia(dependenciaAcademica, 3);
	}
	
	public void onSelect$cmbUnidadAcademica2(){	
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex());
		txtPreIdDependencia.setText(unidadAcademica.getVrIdunidad());
	}
	
	public void onSelect$cmbUnidadAcademica3(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica3.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 2);
//		dependenciaAcademica = listadoDependencia.get(cmbDependencia.getSelectedIndex());
//		cargarNucleoPorDependencia(dependenciaAcademica, 2);
	}
	
	public void onSelect$cmbUnidadAcademica4(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica4.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 3);
	}
	
	public void onSelect$cmbUnidadAcademica5(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica5.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 4);
	}
	
	public void onSelect$cmbUnidadAcademica6(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica6.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 5);
	}
	
	public void onSelect$cmbNucleo(){
		
	}
	
	public void onSelect$cmbNucleo2(){
		nucleoAcademico = listadoNucleo.get(cmbNucleo2.getSelectedIndex());
		txtPreIdArea.setText(nucleoAcademico.getVrIdnucleo());
	}

	public void onOK$cmbNucleo(){
		
	}
	
	public void onOK$cmbNucleo2(){
		nucleoAcademico = listadoNucleo.get(cmbNucleo2.getSelectedIndex());
		txtPreIdArea.setText(nucleoAcademico.getVrIdnucleo());
		txtIdArea.focus();
	}
	
	public void onOK$cmbUnidadAcademica2(){
		txtIdDependencia.focus();
	}
	
	public void onOK$txtIdNucleo(){
		txtNombreNucleo.focus();
	}
	
	
	public void onOK$cmbUnidadAcademica3(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica3.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 2);
		cmbDependencia.focus();
	}
	
	public void onSelect$cmbDependencia2(){
		dependenciaAcademica = listadoDependencia.get(cmbDependencia2.getSelectedIndex());
		String id = dependenciaAcademica.getVrIddependencia();
		txtPreIdNucleo.setText(id);
	}
	
	public void onOK$cmbDependencia2(){
		txtIdNucleo.focus();
	}
	
	public void onOK$txtIdDependencia(){
		if(!txtIdDependencia.getText().trim().isEmpty()){
			txtNombreDependenciaAcademica.focus();
		}		
	}
	
	public void onOK$txtNombreNucleo(){
		String nucleo = txtNombreNucleo.getText().trim().toUpperCase();		
		
		if(!nucleo.isEmpty()){
			if(cmbDependencia2.getSelectedIndex() >= 0){
				dependenciaAcademica = listadoDependencia.get(cmbDependencia2.getSelectedIndex());
				adicionarNucleo(nucleo, dependenciaAcademica);
				txtIdNucleo.focus();
			}
		}
	}
	
	public void onOK$txtNombreDependenciaAcademica(){
		String dependencia = txtNombreDependenciaAcademica.getText().trim().toUpperCase();		
		
		if(!dependencia.isEmpty()){
			txtAliasDependenciaAcademica.focus();			
		}
	}
	
	public void onOK$txtAliasDependenciaAcademica(){
		
		if(cmbUnidadAcademica2.getSelectedIndex() >= 0){
			unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex());
			adicionarDependencia(txtNombreDependenciaAcademica.getText().trim().toUpperCase(), unidadAcademica);
		}
	}
	
	public void onClick$btnAdicionarNombreUnidad(){
		String id = txtIdUnidadAcademica.getText().toUpperCase();
		String nombreUnidad = txtNombreUnidadAcademica.getText().toUpperCase();
		String alias = txtAliasUnidadAcademica.getText().toUpperCase();
		TbAdmPersona responsable = null;
		if (cmbResponsableUnidad.getSelectedIndex() >= 0)
			responsable = listadoPersonas.get(cmbResponsableUnidad.getSelectedIndex());
			
		adicionarUnidad(id,nombreUnidad,alias,responsable);
	}
	
	public void onClick$btnAdicionarNombreDependencia(){
		String dependencia = txtNombreDependenciaAcademica.getText().trim().toUpperCase();		
		
		if(!dependencia.isEmpty()){
			if(cmbUnidadAcademica2.getSelectedIndex() >= 0){
				unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex());
				adicionarDependencia(dependencia, unidadAcademica);
			}
		}
	}
	
	public void onClick$btnAdicionarNombreNucleo(){
		String nucleo = txtNombreNucleo.getText().trim().toUpperCase();		
		
		if(!nucleo.isEmpty()){
			if(cmbDependencia2.getSelectedIndex() >= 0){
				dependenciaAcademica = listadoDependencia.get(cmbDependencia2.getSelectedIndex());
				adicionarNucleo(nucleo, dependenciaAcademica);
			}
		}
	}
	
//	public void onOK$txtAliasNucleo(){
//		String nucleo = txtNombreNucleo.getText().trim().toUpperCase();		
//		
//		if(!nucleo.isEmpty()){
//			if(cmbDependencia2.getSelectedIndex() >= 0){
//				dependenciaAcademica = listadoDependencia.get(cmbDependencia2.getSelectedIndex());
//				adicionarNucleo(nucleo, dependenciaAcademica);
//			}
//		}
//	}
	
	
	public void onClick$btnBuscarDependencia(){
		if(cmbUnidadAcademica.getSelectedIndex() >= 0){
			unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex());
			cargarListaDependenciasPorUnidad(unidadAcademica, 1);
		}		
	}
	
	public void onSelect$cmbUnidadAcademica(){
		if(cmbUnidadAcademica.getSelectedIndex() >= 0){
			unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex());
			cargarListaDependenciasPorUnidad(unidadAcademica, 1);
		}
	}
	
	
	
	public void onClick$opcionGuardarNucleo(){
		guardarRegistros();
	}
	
	public void onSelect$tabOpciones(){
		Tabpanel tabpanels = (Tabpanel)tabOpciones.getSelectedPanel();
		int indice = tabpanels.getIndex();
				
		switch (indice) {
		case 0:
			cargarListaUnidades();
//			txtBuscarUnidad.focus();
			break;
		case 1:
			if(cmbUnidadAcademica.getSelectedIndex() >= 0){
				
			} else {
				cargarDependencias(0);
			}
			cmbUnidadAcademica.focus();
			break;
		case 2:
			if((cmbUnidadAcademica4.getSelectedIndex() >= 0) || (cmbDependencia2.getSelectedIndex() >= 0)){
				if(cmbUnidadAcademica4.getSelectedIndex() >= 0){
					if (cmbDependencia.getSelectedIndex() >= 0){
						dependenciaAcademica = listadoDependencia.get(cmbDependencia.getSelectedIndex());
						cargarNucleoPorDependencia(dependenciaAcademica, 1);
					}
				} else if (cmbDependencia.getSelectedIndex() >= 0){
					
				}
			} else {
				cargarNucleos();
			}
			cmbUnidadAcademica4.focus();
			break;
		case 3:
			if((cmbUnidadAcademica6.getSelectedIndex() >= 0) || (cmbDependencia4.getSelectedIndex() >= 0)){
				if(cmbUnidadAcademica6.getSelectedIndex() >= 0){
					if (cmbDependencia4.getSelectedIndex() >= 0){
						dependenciaAcademica = listadoDependencia.get(cmbDependencia4.getSelectedIndex());
						cargarNucleoPorDependencia(dependenciaAcademica, 2);
					}
				} else if (cmbDependencia.getSelectedIndex() >= 0){
					unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica6.getSelectedIndex());
					cargarListaDependenciasPorUnidad(unidadAcademica, 5);
				}
			} else {
				cargarNucleos();
			}
			cmbUnidadAcademica6.focus();
			break;
		default:
			break;
		}
	}
	
	private void extraerInformacion(){
		TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuario");
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblFechaActual.setValue(s4);
		TbAdmPersona docenteSession = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		String userName = docenteSession.getVrNombres()+" "+docenteSession.getVrApellidos();
		lblUsuarioLogin.setValue(userName);
		
//		int rol = rolxUsuario.getTbAdmRol().getNbId();
	}
	
//	private void permisos(){
//		
//		switch (rol) {
//			case 1:
//				break;
//			case 2:
//				Executions.getCurrent().sendRedirect("./_ambientes/_admin/inicioAdmin.zul");
//				break;
//			case 3:
//				verificarDependencias(docenteSession);
//				listarMicrocurriculos();
//				cargarDatosEncabezadoCoordinador();
//				contenidoInicioDocente.setVisible(true);
//				break;
//			case 4:
//				verificarDependencias(docenteSession);
//				listarMicrocurriculos();
//				cargarDatosEncabezadoDocente();
//				contenidoInicioDocente.setVisible(true);
//				break;
//			case 7:
//				verificarDependencias(docenteSession);
//				listarMicrocurriculos();
//				cargarDatosEncabezadoComite();
//				contenidoInicioDocente.setVisible(true);
//				break;
//			default:
//				Executions.getCurrent().sendRedirect("/index.zul");
//				break;
//		}
//	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuario")){
			extraerInformacion();
//			permisos();
			if("formaCrearNucleo".equals(comp.getParent().getId().toString())){
				cargarListaUnidades();
				cargarListadoResponsables();
			}	
		}else{
			Executions.getCurrent().sendRedirect("/index.zul");
		}
		
			
	}
}

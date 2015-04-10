package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class CrearNucleosCtrl extends GenericForwardComposer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	private static String modUsuario = "SYSTEM";
	private static Date modFecha = new Date();
	private static Date fechaEstimada = null;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	Tabbox tabOpciones;
	
	Listbox listaUnidadAcademica;
	Listbox listaNuevasUnidades;
	Listbox listaDependenciaAcademica;
	Listbox listaNuevasDependencias;
	Listbox listaNucleoAcademico;
	Listbox listaNuevosNucleos;
	
	Textbox txtNombreUnidadAcademica;
	Textbox txtNuevoNombreUnidadAcademica;
	Textbox txtBuscarUnidad;
	Textbox txtIdUnidadAcademica;
	Textbox txtIdDependencia;
	Textbox txtUnidadAcademica;
	Textbox txtDependencia;
	Textbox txtNombreNucleo;
	Textbox txtNuevoNucleoAcademico;
		
	Textbox txtNombreDependenciaAcademica;
	Textbox txtNuevoNombreDependenciaAcademica;
	Textbox txtBuscarDependencia;
	Textbox txtBuscarNucleo;
	Textbox txtPreIdDependencia;
	Textbox txtPreIdNucleo;
	Textbox txtIdNucleo;
	
	Button btnCambiarNombreUnidad;
	Button btnAdicionarNombreUnidad;
	Button btnCambiarNombreDependencia;
	Button btnAdicionarNombreDependencia;
	Button btnBuscarDependencia;
	Button btnCambiarNombreNucleo;
	Button btnAdicionarNombreNucleo;
	
	
	Combobox cmbUnidadAcademica;
	Combobox cmbUnidadAcademica2;
	Combobox cmbUnidadAcademica3;
	Combobox cmbUnidadAcademica4;
	Combobox cmbDependencia;
	Combobox cmbDependencia2;
	
	
		
	List<TbAdmUnidadAcademica> listadoUnidadAcademica;
	List<TbAdmDependencia> listadoDependencia;
	List<TbAdmNucleo> listadoNucleo;
	List<TbAdmUnidadAcademica> listadoNuevoUnidadAcademica = new ArrayList<TbAdmUnidadAcademica>();;
	List<TbAdmDependencia> listadoNuevoDependencia = new ArrayList<TbAdmDependencia>();
	List<TbAdmNucleo> listadoNuevoNucleo = new ArrayList<TbAdmNucleo>();

	TbAdmUnidadAcademica unidadAcademica;
	TbAdmDependencia dependenciaAcademica;
	TbAdmNucleo nucleoAcademico;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	
	private void cargarListaUnidades(){
		try {
			listadoUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			e.printStackTrace();
		}
		
		listaUnidadAcademica.getItems().clear();
		cmbUnidadAcademica.getItems().clear();
		cmbUnidadAcademica2.getItems().clear();
		cmbUnidadAcademica3.getItems().clear();
		cmbUnidadAcademica4.getItems().clear();
		
		if(listadoUnidadAcademica != null){
			for(TbAdmUnidadAcademica unidad : listadoUnidadAcademica){
				listaUnidadAcademica.appendItem(unidad.getVrIdunidad()+" - "+unidad.getVrNombre(), unidad.getVrIdunidad());
				cmbUnidadAcademica.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica2.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica3.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica4.appendItem(unidad.getVrNombre());
			}
		}else {
			System.out.println("La lista de Unidades Academicas está vacia.");
		}		
	}
	
	private void recargarListaUnidadAcademica(){		
		listaUnidadAcademica.getItems().clear();
		cmbUnidadAcademica.getItems().clear();
		cmbUnidadAcademica2.getItems().clear();
		cmbUnidadAcademica3.getItems().clear();
		cmbUnidadAcademica4.getItems().clear();
		
		if(listadoUnidadAcademica != null){
			for(TbAdmUnidadAcademica unidad : listadoUnidadAcademica){
				listaUnidadAcademica.appendItem(unidad.getVrIdunidad()+" - "+unidad.getVrNombre(), unidad.getVrIdunidad());
				cmbUnidadAcademica.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica2.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica3.appendItem(unidad.getVrNombre());
				cmbUnidadAcademica4.appendItem(unidad.getVrNombre());
			}
		}
	}
	
	private void recargarListaDependencia(){
		listaDependenciaAcademica.getItems().clear();
		if(listadoDependencia != null){
			for (TbAdmDependencia item : listadoDependencia){
				listaDependenciaAcademica.appendItem(item.getVrIddependencia()+" - "+item.getVrNombre(), item.getVrIddependencia());
			}
		}
	}
	
	private void cargarDependencias(){
		try {
			listadoDependencia = dependenciaNGC.listarDependencias();
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaDependenciaAcademica.getItems().clear();
		cmbDependencia.getItems().clear();
		cmbDependencia2.getItems().clear();
		
		if (listadoDependencia != null){
			for(TbAdmDependencia item : listadoDependencia){
				listaDependenciaAcademica.appendItem(item.getVrIddependencia()+" - "+item.getVrNombre(), item.getVrIddependencia());
				cmbDependencia.appendItem(item.getVrNombre());
				cmbDependencia2.appendItem(item.getVrNombre());
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
			listaDependenciaAcademica.getItems().clear();
			cmbDependencia.getItems().clear();
			cmbDependencia2.getItems().clear();
			
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
		
		if (listadoNucleo != null){
			for (TbAdmNucleo item : listadoNucleo){
				listaNucleoAcademico.appendItem(item.getVrIdnucleo()+" - "+item.getVrNombre(), item.getVrIdnucleo());
			}
		}		
	}
	
	
	private void cargarNucleoPorDependencia(TbAdmDependencia dependencia){
		try {
			listadoNucleo = nucleoNGC.listarNucleosPorDependencia(dependencia);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaNucleoAcademico.getItems().clear();
		
		if (listadoNucleo != null){
			for(TbAdmNucleo item : listadoNucleo){
				listaNucleoAcademico.appendItem(item.getVrIdnucleo() + " - " + item.getVrNombre(), item.getVrIdnucleo());
			}
		}		
	}
	
	private void recargarListaNucleo(){
		if(listadoNucleo.size() > 0){
			for(TbAdmNucleo item : listadoNucleo){
				listaNucleoAcademico.appendItem(item.getVrIdnucleo()+" - "+item.getVrNombre(), item.getVrIdnucleo());
			}
		}
	}

	private void copiarNombreUnidadAcademica(TbAdmUnidadAcademica unidad){
		txtNuevoNombreUnidadAcademica.setText(unidad.getVrNombre());
	}
	
	private void copiarDependenciaAcademica(TbAdmDependencia dependencia){
		txtUnidadAcademica.setText(dependencia.getTbAdmUnidadAcademica().getVrNombre());
		txtNuevoNombreDependenciaAcademica.setText(dependencia.getVrNombre());
		
	}
	
	private void eliminaListItem(Listitem item, String cadena){
		item.detach();
		System.out.println(item.getParent());
		txtNombreUnidadAcademica.focus();
	}
	
	private void adicionarUnidad(String id, String unidad){		
		final Listitem item = new Listitem();
		if (!id.isEmpty() && (!existeIDUnidad(id))){	
			if ((!unidad.isEmpty()) && (!existeUnidad(unidad))){				
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						eliminaListItem(item, "");
					}
				});
				
				unidadAcademica = new TbAdmUnidadAcademica(id,unidad,modUsuario,modFecha);
				listadoNuevoUnidadAcademica.add(unidadAcademica);
				Listcell celda = new Listcell(id+" - "+unidad);
				item.appendChild(celda);
				listaNuevasUnidades.appendChild(item);
				txtNombreUnidadAcademica.setText("");
				txtNombreUnidadAcademica.focus();				
			}else{
				Messagebox.show("El Nombre de la Unidad Academica ya Existe en uno de los Listados o el Contenido está Vacio.  \nPor favor verifique el nombre.");
				txtNombreDependenciaAcademica.focus();
			}							
		}	else {
			Messagebox.show("El Código de la Unidad Academica ya Existe en uno de los Listados o el Contenido está Vacio.  \nPor favor verifique el Código.");
			txtIdDependencia.focus();
		}
			
	}
	
	private void adicionarDependencia(String dependencia, TbAdmUnidadAcademica unidad){
		final Listitem item = new Listitem();
		String codigo = txtPreIdDependencia.getText().trim().toUpperCase() +txtIdDependencia.getText().trim().toUpperCase();
		
		item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(item, "");
			}
		});
		
		if ((!codigo.isEmpty()) && (!existeIdDependencia(codigo))){
			if ((!dependencia.isEmpty()) && (!existeDependencia(dependencia))){
				dependenciaAcademica = new TbAdmDependencia(codigo,dependencia,modUsuario,modFecha,unidad);
				listadoNuevoDependencia.add(dependenciaAcademica);
				listaNuevasDependencias.appendItem(codigo +" - "+dependencia, dependencia);
				txtIdDependencia.setText("");
				txtNombreDependenciaAcademica.setText("");
				txtIdDependencia.focus();
			} else {
				Messagebox.show("El Nombre de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
			}
		} else {
			Messagebox.show("El Codigo de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
		}
	}
	
	private void adicionarNucleo(String nucleo, TbAdmDependencia dependencia){
		final Listitem item = new Listitem();
		String codigo = txtPreIdNucleo.getText().trim().toUpperCase()+txtIdNucleo.getText().trim().toUpperCase();
		item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(item, "");
			}
		});
		
		if((!codigo.isEmpty()) && (!existeIdNucleo(codigo))){
			if((!nucleo.isEmpty()) && (!existeNucleo(nucleo))){
				nucleoAcademico = new TbAdmNucleo(codigo, dependencia, nucleo, modUsuario, modFecha);
				listadoNuevoNucleo.add(nucleoAcademico);
				listaNuevosNucleos.appendItem(codigo, codigo);
				txtIdNucleo.setText("");
				txtNombreNucleo.setText("");
				txtIdNucleo.focus();
			} else {
				Messagebox.show("El Nombre del Nucleo Academico ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
			}
		} else {
			Messagebox.show("El Codigo del Nucleo Academico ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
		}
		
		
		
	}
	
	
	private void cambiarNombreUnidad(String unidad){		
		if(listaUnidadAcademica.getSelectedIndex() >=0){
			if((!existeUnidad(unidad) && (unidad.length()>0))){
				unidadAcademica.setVrNombre(txtNuevoNombreUnidadAcademica.getText().toUpperCase());
				listadoUnidadAcademica.set(listaUnidadAcademica.getSelectedIndex(), unidadAcademica);
				recargarListaUnidadAcademica();
				txtNuevoNombreUnidadAcademica.setText("");
				txtBuscarUnidad.focus();
			}else{
				Messagebox.show("El Nombre de la Unidad Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
			}	
		} else{
			Messagebox.show("Para cambiar el nombre de una Unidad Académica, primero debe seleccionar un elemento de la Lista.\n Operación Anulada.","Sin Elemento",Messagebox.OK,Messagebox.ON_ABORT);
		}							
	}
	
	
	private void cambiarNombreDependencia(String dependencia){
		if(listaDependenciaAcademica.getSelectedIndex() >= 0){
			if ((!existeDependencia(dependencia)) && (!dependencia.isEmpty())){
				dependenciaAcademica.setVrNombre(txtNuevoNombreDependenciaAcademica.getText().toUpperCase());
				listadoDependencia.set(listaDependenciaAcademica.getSelectedIndex(), dependenciaAcademica);
				recargarListaDependencia();
				txtNuevoNombreDependenciaAcademica.setText("");
				txtUnidadAcademica.setText("");
				txtBuscarDependencia.focus();
			} else{
				Messagebox.show("El Nombre de la Dependencia Academica ya Existe en uno de los Listados.  \nPor favor verifique el nombre.");
			}
	
		}else {
			Messagebox.show("Para cambiar el nombre de una Dependencia Académica, primero debe seleccionar un elemento de la Lista.\n Operación Anulada.","Sin Elemento",Messagebox.OK,Messagebox.ON_ABORT);
		}
	}
	
	//DEBO HACER EL METODO CAMBIAR NOMBRE.... RECUERDALO.
	
	
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
		
		estado = buscarIDUnidadAcademica(listadoUnidadAcademica, id);		
		if (!estado){
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
		for (TbAdmDependencia item : lista){
			if(id.equals(item.getVrIddependencia())){
				estado=true;
				break;
			}
		}
		return estado;
	}
	
	private boolean buscarIdNucleo(List<TbAdmNucleo> lista, String id){
		boolean estado = false;
		for (TbAdmNucleo item : lista){
			if(id.equals(item.getVrIdnucleo())){
				estado=true;
				break;
			}
		}
		return estado;
	}
	
	//EVENTOS DE OBJETOS
	
	public void onOK$txtNombreUnidadAcademica(){
		String id = txtIdUnidadAcademica.getText().toUpperCase();
		String nombreUnidad = txtNombreUnidadAcademica.getText().toUpperCase();
		adicionarUnidad(id,nombreUnidad);
	}		
	
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
	
	public void onOK$txtNuevoNombreUnidadAcademica(){
		cambiarNombreUnidad(txtNuevoNombreUnidadAcademica.getText().toUpperCase().trim());
	}
	
	public void onOK$txtNuevoNombreDependenciaAcademica(){
		cambiarNombreDependencia(txtNuevoNombreDependenciaAcademica.getText().trim().toUpperCase());
	}
	
	public void onClick$btnCambiarNombreUnidad(){
		cambiarNombreUnidad(txtNuevoNombreUnidadAcademica.getText().toUpperCase().trim());
	}
	
	public void onClick$btnCambiarNombreDependencia(){
		cambiarNombreDependencia(txtNuevoNombreDependenciaAcademica.getText().trim().toUpperCase());
	}
	
	public void onSelect$cmbDependencia(){
		dependenciaAcademica = listadoDependencia.get(cmbDependencia.getSelectedIndex());
//		String id = dependenciaAcademica.getVrIddependencia();
		cargarNucleoPorDependencia(dependenciaAcademica);
	}
	
	public void onSelect$cmbUnidadAcademica2(){	
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex());
		txtPreIdDependencia.setText(unidadAcademica.getVrIdunidad());
	}
	
	public void onSelect$cmbUnidadAcademica3(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica3.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 2);		
	}
	
	public void onSelect$cmbUnidadAcademica4(){
		unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica4.getSelectedIndex());
		cargarListaDependenciasPorUnidad(unidadAcademica, 3);
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
			if(cmbUnidadAcademica2.getSelectedIndex() >= 0){
				unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex());
				adicionarDependencia(dependencia, unidadAcademica);
			}
		}
	}
	
	public void onClick$btnAdicionarNombreUnidad(){
		String id = txtIdUnidadAcademica.getText().toUpperCase();
		String nombreUnidad = txtNombreUnidadAcademica.getText().toUpperCase();
		adicionarUnidad(id,nombreUnidad);
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
	
	
	public void onClick$btnBuscarDependencia(){
		if(cmbUnidadAcademica.getSelectedIndex() >= 0){
			unidadAcademica = listadoUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex());
			cargarListaDependenciasPorUnidad(unidadAcademica, 1);
		}
		
	}
	
	
	
	public void onSelect$tabOpciones(){
		Tabpanel tabpanels = (Tabpanel)tabOpciones.getSelectedPanel();
		int indice = tabpanels.getIndex();
		TbAdmDependencia tmpDependencia;
		String id = "";
		
		switch (indice) {
		case 0:
			cargarListaUnidades();
			txtBuscarUnidad.focus();
			break;
		case 1:
			if(cmbUnidadAcademica.getSelectedIndex() >= 0){
				
			} else {
				cargarDependencias();
			}
			cmbUnidadAcademica.focus();
			break;
		case 2:
			if((cmbUnidadAcademica4.getSelectedIndex() >= 0) || (cmbDependencia2.getSelectedIndex() >= 0)){
				if(cmbUnidadAcademica4.getSelectedIndex() >= 0){
					if (cmbDependencia.getSelectedIndex() >= 0){
						dependenciaAcademica = listadoDependencia.get(cmbDependencia.getSelectedIndex());
						cargarNucleoPorDependencia(dependenciaAcademica);
					}
				} else if (cmbDependencia.getSelectedIndex() >= 0){
					
				}
			} else {
				cargarNucleos();
			}
			cmbUnidadAcademica4.focus();
			break;
		default:
			break;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		cargarListaUnidades();
	}
}

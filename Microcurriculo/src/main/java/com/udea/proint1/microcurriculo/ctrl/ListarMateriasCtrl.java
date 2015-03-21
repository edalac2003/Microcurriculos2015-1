package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ListarMateriasCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMateriasCtrl.class);
	
	Button btnBuscar;
	
	Listbox listaMaterias;
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbMateria;
	
	Textbox txtMateria;
	
	Toolbarbutton tool_new;
	
	Button btnBuscarMaterias;
	
	MateriaNGCImpl materiaNGC;
	NucleoNGCImpl nucleoNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	
	public void setMateriaNGC(MateriaNGCImpl materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setNucleoNGC(NucleoNGCImpl nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
//	public void onClick$btnBuscarMaterias(Event event){
//		//Messagebox.show("Entro al Evento Click de BUscar");
//		limpiarLista(listaMaterias);
//		if (!"".equals(cmbCriterioBusqueda.getValue()) && (cmbCriterioBusqueda.getValue() != null)){
//			if ((!"".equals(cmbValorBusqueda.getValue())) && (cmbValorBusqueda.getValue() != null)){
//				List<TbAdmMateria> listaMaterias = null;
//				try {
//					listaMaterias = materiasNGC.listarMateriasxNucleo(cmbValorBusqueda.getValue().toString());
//					if (listaMaterias != null){
//						for(TbAdmMateria materia : listaMaterias){
//							llenarListaMaterias(materia);
//						}						
//					} else 
//						Messagebox.show("No se encontraron registros coincidentes con el criterio de Busqueda");
//				} catch (WrongValueException e) {
//					e.printStackTrace();
//				} catch (ExcepcionesLogica e) {
//					e.printStackTrace();
//				}				
//			} else
//				Messagebox.show("Se Requiere informaci�n en el Campo <Valor a Buscar>");
//		}else
//			Messagebox.show("Se Requiere informaci�n en el Campo <Criterio de Busqueda>");
//	}
//	
//	public void llenarListaMaterias(TbAdmMateria materia){
//		Listitem listaItem = new Listitem();
//		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
//			@Override
//			public void onEvent(Event arg0) throws Exception {		
//				consultarMaterias();
//			}
//		});
//		System.out.println("Codigo : " + materia.getVrIdmateria());
//		Listcell celda1 = new Listcell(materia.getVrIdmateria());
//		Listcell celda2 = new Listcell(materia.getVrNombre());
//		Listcell celda3 = new Listcell(materia.getTbAdmNucleo().getVrNombre());
//		Listcell celda4 = new Listcell(Integer.toString(materia.getNbSemestre()));
//		Listcell celda5 = new Listcell(Integer.toString(materia.getNbHt()));
//		Listcell celda6 = new Listcell(Integer.toString(materia.getNbHp()));
//		Listcell celda7 = new Listcell(Integer.toString(materia.getNbHtp()));
//		Listcell celda8 = new Listcell(null);
//		listaItem.appendChild(celda1);
//		listaItem.appendChild(celda2);
//		listaItem.appendChild(celda3);
//		listaItem.appendChild(celda4);
//		listaItem.appendChild(celda5);
//		listaItem.appendChild(celda6);
//		listaItem.appendChild(celda7);
//		listaItem.appendChild(celda8);
//		listaMaterias.appendChild(listaItem);
//	}
//	
//	public void consultarMaterias(){
//		
//	}
//	
//	public void limpiarLista(Listbox lista){
//		lista.getItems().clear();
//		/*if (lista.getItemCount()>0){
//			Messagebox.show(Integer.toString(lista.getItemCount()));
//			for (int i=lista.getItemCount();i==0;i++){
//				lista.removeItemAt(i);
//			}	
//		}*/
//		
//	}

	List<TbAdmMateria> materiasEncontradas = new ArrayList<TbAdmMateria>();
	List<TbAdmMateria> materiasFiltradas = new ArrayList<TbAdmMateria>();

	public void cargarUnidadesAcademicas(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadesAca = unidadAcademicaNGC.listarUnidadAcademicas();
			cmbUnidadAcademica.getItems().clear();
			
			if(listaUnidadesAca != null){
				for(TbAdmUnidadAcademica unidad: listaUnidadesAca){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
					cmbUnidadAcademica.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron unidades academicas");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarDependencias(){
		try {
			List<TbAdmDependencia> listaDepartamentos = dependenciaNGC.listarDependencias();
			cmbDependencia.getItems().clear();
			
			if(listaDepartamentos != null){
				for(TbAdmDependencia departamento: listaDepartamentos){
					Comboitem item = new Comboitem(departamento.getVrIddependencia());
					item.setDescription(departamento.getVrNombre());
					cmbDependencia.appendChild(item);
					cmbDependencia.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
			}
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);	
				}
				cmbNucleo.setValue("[Seleccione]");
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	private void cargarMaterias(){
		try {
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMaterias();
			cmbMateria.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMateria materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbMateria.appendChild(item);	
				}
				cmbMateria.setValue("[Seleccione]");
			}else{
				Messagebox.show("No se hallaron materias");
			}
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbUnidadAcademica(){
		String id = cmbUnidadAcademica.getValue().toString();
		
		recargarNucleos(id);
		recargarNucleos(id);
		recargarMaterias(id);
		
	}
	
	public void onSelect$cmbDependencia(){
		String id = cmbDependencia.getValue().toString();
		recargarNucleos(id);
		recargarMaterias(id);
	}
	
	public void onSelect$cmbNucleo(){
		String id = cmbNucleo.getValue().toString();
		recargarMaterias(id);
	}
	
	public void recargarDependencia(String buscaDepartamentos){
		try {
			buscaDepartamentos = buscaDepartamentos + "%";
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.buscarDepedencias(buscaDepartamentos);
			cmbDependencia.getItems().clear();
			
			if(listaDependencias != null){
				for(TbAdmDependencia dependencia: listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
			}
			cmbDependencia.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarNucleos(String buscaNucleos){
		try {
			buscaNucleos = buscaNucleos+"%";
			List<TbAdmNucleo> listaNucleos = nucleoNGC.buscarNucleos(buscaNucleos);
			cmbNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
			cmbNucleo.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarMaterias(String buscaMaterias){
		try {
			buscaMaterias = buscaMaterias+"%";
			List<TbAdmMateria> listaMaterias = materiaNGC.buscarMaterias(buscaMaterias);
			cmbMateria.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMateria materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbMateria.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
			cmbMateria.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onClick$btnBuscar(){
		if(!"[Seleccione]".equals(cmbMateria.getValue().toString())&&(!"".equals(cmbMateria.getValue().toString()))){
			String busca = cmbMateria.getValue().toString();
			busca = busca + "%";
			consultarMaterias(busca);
		}else{
			if(!"[Seleccione]".equals(cmbNucleo.getValue().toString())&&(!"".equals(cmbNucleo.getValue().toString()))){
				String busca = cmbNucleo.getValue().toString();
				busca = busca + "%";
				consultarMaterias(busca);
			}else{
				if(!"[Seleccione]".equals(cmbDependencia.getValue().toString())&&(!"".equals(cmbDependencia.getValue().toString()))){
					String busca = cmbDependencia.getValue().toString();
					busca = busca + "%";
					consultarMaterias(busca);
				}else{
					if(!"[Seleccione]".equals(cmbUnidadAcademica.getValue().toString())&&(!"".equals(cmbUnidadAcademica.getValue().toString()))){
						String busca = cmbUnidadAcademica.getValue().toString();
						busca = busca + "%";
						consultarMaterias(busca);
					}else{
						consultarMaterias("%");
					}
				}
			}
		}
		filtrarMaterias();
		listarMaterias();
	}
	
	public void consultarMaterias(String MateriaBuscar){
		try{
			
			materiasEncontradas = materiaNGC.buscarMaterias(MateriaBuscar);
			listaMaterias.getItems().clear();
			
		}catch(ExcepcionesLogica e){
			e.printStackTrace();
		}
	}
	
	public void listarMaterias(){
		if(materiasFiltradas != null){
			for(TbAdmMateria materia: materiasFiltradas){
				Listitem listaItem = new Listitem();
				
				Listcell celda1 = new Listcell(materia.getVrIdmateria());
				listaItem.appendChild(celda1);
				Listcell celda2 = new Listcell(materia.getVrNombre());
				listaItem.appendChild(celda2);
				Listcell celda3 = new Listcell(materia.getTbAdmNucleo().getVrNombre());
				listaItem.appendChild(celda3);
				Listcell celda4 = new Listcell(Integer.toString(materia.getNbSemestre()));
				listaItem.appendChild(celda4);
				Listcell celda5 = new Listcell(Integer.toString(materia.getNbHt()));
				listaItem.appendChild(celda5);
				Listcell celda6 = new Listcell(Integer.toString(materia.getNbHp()));
				listaItem.appendChild(celda6);
				Listcell celda7 = new Listcell(Integer.toString(materia.getNbHtp()));
				listaItem.appendChild(celda7);
				listaMaterias.appendChild(listaItem);
			}
		}
	}
	
	public void filtrarMaterias(){
		if(materiasEncontradas != null){
			String filtro = txtMateria.getValue().toLowerCase();
			materiasFiltradas.clear();
			for(TbAdmMateria materia: materiasEncontradas){
				if(materia.getVrNombre().toLowerCase().contains(filtro)){
					materiasFiltradas.add(materia);
				}
			}
		}
	}
	
	public void onClick$tool_new(){
		materiasEncontradas.clear();
		materiasFiltradas.clear();
		listaMaterias.getItems().clear();
		cmbUnidadAcademica.setValue("[Seleccione]");
		cmbDependencia.setValue("[Seleccione]");
		cmbNucleo.setValue("[Seleccione]");
		cmbMateria.setValue("[Seleccione]");
		txtMateria.setConstraint("");
		txtMateria.setValue("");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		cargarUnidadesAcademicas();
		cargarDependencias();
		cargarNucleos();
		cargarMaterias();
	}
}

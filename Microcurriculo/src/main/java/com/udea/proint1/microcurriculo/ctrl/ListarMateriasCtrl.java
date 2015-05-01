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

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
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
	
	/**
	 * Listados para manejar las consultas
	 */

	public static List<TbAdmUnidadAcademica> listaUnidadAcademica;
	public static List<TbAdmDependencia> listaDependencias;
	public static List<TbAdmNucleo> listaNucleos;
	public static List<TbAdmMateria> listaMaterias2;
	public static List<TbAdmMateria> listaMaterias3;
	public static List<TbAdmPersona> listaDocentes;
	public static List<TbAdmSemestre> listaSemestre;
	public static List<TbMicEstado> listaEstados;
	public static List<TbMicMicrocurriculo> listaMicrocurriculos;
	public static List<TbAdmCorrequisito> listaTodosCorrequisitos;
	public static List<TbAdmPrerrequisito> listaTodosPrerrequisitos;
	
	MateriaNGCImpl materiaNGC;
	NucleoNGCImpl nucleoNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	
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
	
	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	List<TbAdmMateria> materiasEncontradas = new ArrayList<TbAdmMateria>();
	List<TbAdmMateria> materiasFiltradas = new ArrayList<TbAdmMateria>();

	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
	 */
	public void cargarUnidadesAcademicas(){
		try {
			listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
				}
				cmbUnidadAcademica.setValue("[Seleccione]");
			}
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
	
	/**
	 * Solicita de la capa del negocio todas las dependencias existentes y las ubica en el combobox cmbDependencia
	 * Si existe el combobox cmbDependencia2 se procede a llenar dicho elemento tambien
	 */
	private void cargarDependencias(String unidad){
		if(!"".equals(unidad)){
			try {
				unidad = unidad + "%";
				listaDependencias = dependenciaNGC.buscarDepedencias(unidad);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}else{
			try {
				listaDependencias = dependenciaNGC.listarDependencias();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}
		
		cmbDependencia.getItems().clear();
		if (listaDependencias != null){
			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDependencia dependencia : listaDependencias){
				Comboitem item = new Comboitem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
				cmbDependencia.appendChild(item);
			}
			cmbDependencia.setValue("[Seleccione]");
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas los nucleos existentes y las ubica en el combobox cmbNucleo
	 * Si existe el combobox cmbNucleo2 se procede a llenar dicho elemento tambien
	 */
	private void cargarNucleos(String dependencia){
		if(!"".equals(dependencia)){
			try {
				dependencia = dependencia + "%";
				listaNucleos = nucleoNGC.buscarNucleos(dependencia);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}else{
			try {
				listaNucleos = nucleoNGC.listarNucleos();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}
		
		cmbNucleo.getItems().clear();
		if (listaNucleos != null){
			cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmNucleo nucleo : listaNucleos){
				Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+nucleo.getVrNombre());
				cmbNucleo.appendChild(item);
			}
			cmbNucleo.setValue("[Seleccione]");
		}
			
	}
	
	/**
	 * Solicita de la capa del negocio todas las materias existentes y las ubica en el combobox cmbMateria
	 * Si existe el combobox cmbMateria2 se procede a llenar dicho elemento tambien
	 */
	public void cargarMaterias(String nucleo){
		if (!nucleo.equals("") && (nucleo.length() > 1)){
			try {
				nucleo = nucleo + "%";
				listaMaterias2 = materiaNGC.buscarMaterias(nucleo);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		} else {
			try {
				listaMaterias2 = materiaNGC.listarMaterias();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}
				
		cmbMateria.getItems().clear();
		if(listaMaterias2 != null){
			cmbMateria.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmMateria materia : listaMaterias2){
				Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
				cmbMateria.appendChild(item);
			}
			cmbMateria.setValue("[Seleccione]");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica(){
		if(cmbUnidadAcademica.getSelectedIndex() != 0){
			TbAdmUnidadAcademica unidad = listaUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
			cargarDependencias(unidad.getVrIdunidad());
			cargarNucleos(unidad.getVrIdunidad());
			cargarMaterias(unidad.getVrIdunidad());
		}else{
			cargarDependencias("");
			cargarNucleos("");
			cargarMaterias("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia(){
		if(cmbDependencia.getSelectedIndex() != 0){
			TbAdmDependencia dependencia = listaDependencias.get(cmbDependencia.getSelectedIndex()-1); 
			cargarNucleos(dependencia.getVrIddependencia());
			cargarMaterias(dependencia.getVrIddependencia());
		}else{
			cargarNucleos("");
			cargarMaterias("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo(){
		if(cmbNucleo.getSelectedIndex() != 0){
			TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
			cargarMaterias(nucleo.getVrIdnucleo());
		}else{
			cargarMaterias("");
		}
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
	
	public void onClick$btnBuscar(){
		verificarFiltro();
	}
	
	public void onOK$txtMateria(){
		verificarFiltro();
	}
	
	public void onOK$cmbMateria(){
		txtMateria.focus();
	}
	
	public void onOK$cmbNucleo(){
		cmbMateria.focus();
	}
	
	public void onOK$cmbDependencia(){
		cmbNucleo.focus();
	}
	
	public void onOK$cmbUnidadAcademica(){
		cmbDependencia.focus();
	}
	
	public void verificarFiltro(){
		if(!"[Seleccione]".equals(cmbMateria.getValue().toString())&&(!"".equals(cmbMateria.getValue().toString()))){
			TbAdmMateria materia = listaMaterias2.get(cmbMateria.getSelectedIndex()-1);
			String busca = materia.getVrIdmateria();
			busca = busca + "%";
			consultarMaterias(busca);
		}else{
			if(!"[Seleccione]".equals(cmbNucleo.getValue().toString())&&(!"".equals(cmbNucleo.getValue().toString()))){
				TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
				String busca = nucleo.getVrIdnucleo();
				busca = busca + "%";
				consultarMaterias(busca);
			}else{
				if(!"[Seleccione]".equals(cmbDependencia.getValue().toString())&&(!"".equals(cmbDependencia.getValue().toString()))){
					TbAdmDependencia dependencia = listaDependencias.get(cmbDependencia.getSelectedIndex()-1);
					String busca = dependencia.getVrIddependencia();
					busca = busca + "%";
					consultarMaterias(busca);
				}else{
					if(!"[Seleccione]".equals(cmbUnidadAcademica.getValue().toString())&&(!"".equals(cmbUnidadAcademica.getValue().toString()))){
						TbAdmUnidadAcademica unidad = listaUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
						String busca = unidad.getVrIdunidad();
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
				Listcell celda5 = new Listcell(Integer.toString(materia.getNbCreditos()));
				listaItem.appendChild(celda5);
				Listcell celda6 = new Listcell(Integer.toString(materia.getNbHt()));
				listaItem.appendChild(celda6);
				Listcell celda7 = new Listcell(Integer.toString(materia.getNbHp()));
				listaItem.appendChild(celda7);
				Listcell celda8= new Listcell(Integer.toString(materia.getNbHtp()));
				listaItem.appendChild(celda8);
				
				/**
				 * si la lista de correquisitos está vacía, entonces los trae todos
				 */
				
				if(listaTodosCorrequisitos == null){
					try {
						listaTodosCorrequisitos = correquisitoNGC.listarCorrequisitos();
					}catch(ExcepcionesDAO expDAO){
						Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expDAO.getMsjTecnico());
					}catch(ExcepcionesLogica expNgs){
						Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expNgs.getMsjTecnico());
					}catch(Exception exp){
//						Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(exp);
					}
				}
				
				/**
				 * busca en la lista de correquisitos cuales pertenecen a la materia y los concatena a un String
				 * para ser mostrado en el listado al usuario
				 */
				
				String correquisitoMostrar = "";
				if(listaTodosCorrequisitos != null){
					for(TbAdmCorrequisito correquisito: listaTodosCorrequisitos){
						if(correquisito.getTbAdmMateriasByVrMateria().getVrIdmateria().equals(materia.getVrIdmateria()))
							correquisitoMostrar = correquisitoMostrar + correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+"\n";
					}
				}
				
				Listcell celda9= new Listcell(correquisitoMostrar);
				listaItem.appendChild(celda9);
				
				/**
				 * si la lista de prerrequisitos está vacía, entonces los trae todos
				 */
				
				if(listaTodosPrerrequisitos == null){
					try {
						listaTodosPrerrequisitos = prerrequisitoNGC.listarPrerrequisitos();
					}catch(ExcepcionesDAO expDAO){
						Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expDAO.getMsjTecnico());
					}catch(ExcepcionesLogica expNgs){
						Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expNgs.getMsjTecnico());
					}catch(Exception exp){
//						Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(exp);
					}	
				}
				
				/**
				 * busca en la lista de prerrequisitos cuales pertenecen a la materia y los concatena a un String
				 * para ser mostrado en el listado al usuario
				 */
				
				String prerrequisitoMostrar = "";
				if(listaTodosPrerrequisitos != null){
					for(TbAdmPrerrequisito prerrequisito: listaTodosPrerrequisitos){
						if(prerrequisito.getTbAdmMateriasByVrMateria().getVrIdmateria().equals(materia.getVrIdmateria()))
							prerrequisitoMostrar = prerrequisitoMostrar + prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+"\n";
					}
				}
				
				Listcell celda10= new Listcell(prerrequisitoMostrar);
				listaItem.appendChild(celda10);
				
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
		cargarDependencias("");
		cargarNucleos("");
		cargarMaterias("");
	}
}

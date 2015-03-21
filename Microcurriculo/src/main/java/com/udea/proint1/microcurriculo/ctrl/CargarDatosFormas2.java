package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Gestiona la carga de datos a las vistas: listado, duplicado y consulta de microcurriculos.
 * @author Elmer Urrea & Edwin Acosta
 *
 */
public class CargarDatosFormas2 extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CargarDatosFormas2.class);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
	Combobox cmbUnidadAcademica2;
	Combobox cmbDependencia2;
	Combobox cmbNucleo2;
	Combobox cmbMateria2;
	Combobox cmbMicrocurriculo2;
	Combobox cmbDocente;
	Combobox cmbEstado;
	
	Label lblEncabezadoMicro;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	PaisNGC paisNGC;
	EstadoNGC estadoNGC;
	
	/**
	 * Metodo set para inyeccion de dependencia spring para unidades academicas en la capa del negocio
	 * @param unidadAcademicaNGC objeto instaciado de capa de negocio
	 */
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para dependencias en la capa del negocio
	 * @param dependenciaNGC objeto instaciado de capa de negocio
	 */
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para nucleos en la capa del negocio
	 * @param nucleoNGC objeto instaciado de capa de negocio
	 */
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para materias en la capa del negocio
	 * @param materiaNGC objeto instaciado de capa de negocio
	 */
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para semestres en la capa del negocio
	 * @param semestreNGC objeto instaciado de capa de negocio
	 */
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para persona en la capa del negocio
	 * @param personaNGC objeto instaciado de capa de negocio
	 */
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para microcurriculos en la capa del negocio
	 * @param microcurriculoNGC objeto instaciado de capa de negocio
	 */
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para paises en la capa del negocio
	 * @param paisNGC objeto instaciado de capa de negocio
	 */
	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para estados en la capa del negocio
	 * @param estadoNGC objeto instaciado de capa de negocio
	 */
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}
	
	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
	 */
	private void cargarUnidades(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
				if(cmbUnidadAcademica2 != null){
					cmbUnidadAcademica2.appendChild(new Comboitem("[Seleccione]"));
				}
				System.out.println();
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
					if(cmbUnidadAcademica2 != null){
						cmbUnidadAcademica2.appendChild(item);
					}
				}
				cmbUnidadAcademica.setValue("[Seleccione]");
				if(cmbUnidadAcademica2 != null){
					cmbUnidadAcademica2.setValue("[Seleccione]");
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron problemas al Obtener los registros de la tabla <Tb_Adm_UnidadAcademica>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas las dependencias existentes y las ubica en el combobox cmbDependencia
	 * Si existe el combobox cmbDependencia2 se procede a llenar dicho elemento tambien
	 */
	private void cargarDependencias(){
		try {
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependencias();
			if (listaDependencias != null){
				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
				if(cmbDependencia2 != null){
					cmbDependencia2.appendChild(new Comboitem("[Seleccione]"));
				}
				for(TbAdmDependencia dependencia : listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
					if(cmbDependencia2 != null){
						cmbDependencia2.appendChild(item);
					}
				}
				cmbDependencia.setValue("[Seleccione]");
				if(cmbDependencia2 != null){
					cmbDependencia2.setValue("[Seleccione]");
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas los nucleos existentes y las ubica en el combobox cmbNucleo
	 * Si existe el combobox cmbNucleo2 se procede a llenar dicho elemento tambien
	 */
	private void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			listaNucleos = nucleoNGC.listarNucleos();
			if (listaNucleos != null){
				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
				if(cmbNucleo2 != null){
					cmbNucleo2.appendChild(new Comboitem("[Seleccione]"));
				}
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
					if(cmbNucleo2 != null){
						cmbNucleo2.appendChild(item);
					}
				}
				cmbNucleo.setValue("[Seleccione]");
				if(cmbNucleo2 != null){
					cmbNucleo2.setValue("[Seleccione]");
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas las materias existentes y las ubica en el combobox cmbMateria
	 * Si existe el combobox cmbMateria2 se procede a llenar dicho elemento tambien
	 */
	public void cargarMaterias(){
		try {
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMaterias();
			cmbMateria.getItems().clear();
			
			if(listaMaterias != null){
				cmbMateria.appendChild(new Comboitem("[Seleccione]"));
				if(cmbMateria2 != null){
					cmbMateria2.appendChild(new Comboitem("[Seleccione]"));
				}
				for(TbAdmMateria materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbMateria.appendChild(item);
					if(cmbMateria2 != null){
						cmbMateria2.appendChild(item);
					}
				}
				cmbMateria.setValue("[Seleccione]");
				if(cmbMateria2 != null){
					cmbMateria2.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron materias");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("error al invocar metodo listarMaterias de la clase MateriaNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los semestres existentes y los ubica en el combobox cmbSemestre
	 */
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
			logger.error("error al invocar metodo listarSemestres de la clase SemestreNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los estados existentes y los ubica en el combobox cmbEstado
	 */
	public void cargarEstados(){
		try {
			List<TbMicEstado> listaEstados = estadoNGC.listarEstados();
			cmbEstado.getItems().clear();
			if(listaEstados != null){
				cmbEstado.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicEstado estado: listaEstados){
					Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
					item.setDescription(estado.getVrDescripcion());
					cmbEstado.appendChild(item);
				}
				cmbEstado.setValue("[Seleccione]");
			}else{
				//Messagebox.show("No se hallaron estados");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("error al invocar metodo listarEstados de la clase EstadoNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.obtenerDocentes();
			cmbDocente.getItems().clear();
			if (listaDocentes != null){
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					item.setDescription(docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
		} catch (ExcepcionesLogica e) {
			logger.error("error al invocar metodo obtenerDocentes de la clase PersonaNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo
	 */
	private void cargarMicrocurriculos(){
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error("error al invocar metodo listarMicrocurriculos de la clase MicrocurriculoNGC: "+e);
		}
		
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
				if(microcurriculo.getTbMicEstado().getNbIdestado()==6){
					Comboitem item2 = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
					cmbMicrocurriculo.appendChild(item2);
				}
			}
		}
		cmbMicrocurriculo.setValue("[Seleccione]");
	}
	
	/**
	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo
	 */
	private void cargarMicrocurriculos2(){
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error("error al invocar metodo listarMicrocurriculos de la clase MicrocurriculoNGC: "+e);
		}
		
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
				Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
				cmbMicrocurriculo2.appendChild(item);
			}
		}
		cmbMicrocurriculo2.setValue("[Seleccione]");
	}
	
	/**
	 * Hace la busqueda de las dependencias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param unidad contiene indicio de id para busquedas de dependencias que coincidan
	 */
	private void recargarDependencias(String unidad){
		if(!cmbDependencia.getValue().toString().equals("[Seleccione]")){
			try {		
				List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependenciasPorUnidad(unidad);
				cmbDependencia.getItems().clear();
				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
				if (listaDependencias != null){
					for(TbAdmDependencia dependencia : listaDependencias){
						Comboitem item = new Comboitem(dependencia.getVrIddependencia());
						item.setDescription(dependencia.getVrNombre());
						cmbDependencia.appendChild(item);
					}
				}
				cmbDependencia.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de las dependencias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param unidad contiene indicio de id para busquedas de dependencias que coincidan
	 */
	private void recargarDependencias2(String unidad){
		if(!cmbDependencia2.getValue().toString().equals("[Seleccione]")){
			try {		
				List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependenciasPorUnidad(unidad);
				cmbDependencia2.getItems().clear();
				cmbDependencia2.appendChild(new Comboitem("[Seleccione]"));
				if (listaDependencias != null){
					for(TbAdmDependencia dependencia : listaDependencias){
						Comboitem item = new Comboitem(dependencia.getVrIddependencia());
						item.setDescription(dependencia.getVrNombre());
						cmbDependencia2.appendChild(item);
					}
				}
				cmbDependencia2.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de los nucleos existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param dependencia contiene indicio de id para busquedas de nucleos que coincidan
	 */
	private void recargarNucleos(String dependencia){
		if(!cmbNucleo.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleosPorDependencia(dependencia);
				cmbNucleo.getItems().clear();
				if (listaNucleos != null){
					cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
					for(TbAdmNucleo nucleo : listaNucleos){
						Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
						item.setDescription(nucleo.getVrNombre());
						cmbNucleo.appendChild(item);
					}
				}
				cmbNucleo.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de los nucleos existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param dependencia contiene indicio de id para busquedas de nucleos que coincidan
	 */
	private void recargarNucleos2(String dependencia){
		if(!cmbNucleo2.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleosPorDependencia(dependencia);
				cmbNucleo2.getItems().clear();
				if (listaNucleos != null){
					cmbNucleo2.appendChild(new Comboitem("[Seleccione]"));
					for(TbAdmNucleo nucleo : listaNucleos){
						Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
						item.setDescription(nucleo.getVrNombre());
						cmbNucleo2.appendChild(item);
					}
				}
				cmbNucleo2.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de las materias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param nucleo contiene indicio de id para busquedas de materias que coincidan
	 */
	private void recargarMaterias(String nucleo){
		if(!cmbMateria.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmMateria> listaMateria = materiaNGC.listarMateriasxNucleo(nucleo);
				if (listaMateria != null){
					cmbMateria.getItems().clear();
					for(TbAdmMateria materia : listaMateria){
						Comboitem item = new Comboitem(materia.getVrIdmateria());
						item.setDescription(materia.getVrNombre());
						cmbMateria.appendChild(item);
					}
				}
				cmbMateria.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Materia>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de las materias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param nucleo contiene indicio de id para busquedas de materias que coincidan
	 */
	private void recargarMaterias2(String nucleo){
		if(!cmbMateria2.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmMateria> listaMateria = materiaNGC.listarMateriasxNucleo(nucleo);
				if (listaMateria != null){
					cmbMateria2.getItems().clear();
					for(TbAdmMateria materia : listaMateria){
						Comboitem item = new Comboitem(materia.getVrIdmateria());
						item.setDescription(materia.getVrNombre());
						cmbMateria2.appendChild(item);
					}
				}
				cmbMateria2.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Materia>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de los microcurriculos existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param buscaMicrocurriculos contiene indicio de id para busquedas de microcurriculos que coincidan
	 */
	public void recargarMicrocurriculos(String buscaMicrocurriculos){
		if(cmbMicrocurriculo != null){
			try {
				buscaMicrocurriculos = buscaMicrocurriculos + "%";
				List<TbMicMicrocurriculo> listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicrocurriculos);
				cmbMicrocurriculo.getItems().clear();
				
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
						if(microcurriculo.getTbMicEstado().getNbIdestado()==6){
							Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
							cmbMicrocurriculo.appendChild(item);
						}
					}
				}else{
					Messagebox.show("No se hallaron microcurriculos");
				}
			} catch (ExcepcionesLogica e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Hace la busqueda de los microcurriculos existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param buscaMicrocurriculos contiene indicio de id para busquedas de microcurriculos que coincidan
	 */
	public void recargarMicrocurriculos2(String buscaMicrocurriculos){
		if(cmbMicrocurriculo2 != null){
			try {
				buscaMicrocurriculos = buscaMicrocurriculos + "%";
				List<TbMicMicrocurriculo> listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicrocurriculos);
				cmbMicrocurriculo2.getItems().clear();
				
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
						Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
						cmbMicrocurriculo2.appendChild(item);
					}
				}else{
					Messagebox.show("No se hallaron microcurriculos");
				}
			} catch (ExcepcionesLogica e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica(){
		recargarDependencias(cmbUnidadAcademica.getValue());
		recargarNucleos(cmbUnidadAcademica.getValue());
		recargarMaterias(cmbUnidadAcademica.getValue());
		recargarMicrocurriculos(cmbUnidadAcademica.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica2(){
		recargarDependencias2(cmbUnidadAcademica2.getValue());
		recargarNucleos2(cmbUnidadAcademica2.getValue());
		recargarMaterias2(cmbUnidadAcademica2.getValue());
		recargarMicrocurriculos2(cmbUnidadAcademica2.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia(){
		recargarNucleos(cmbDependencia.getValue());
		recargarMaterias(cmbDependencia.getValue());
		recargarMicrocurriculos(cmbDependencia.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia2(){
		recargarNucleos2(cmbDependencia2.getValue());
		recargarMaterias2(cmbDependencia2.getValue());
		recargarMicrocurriculos2(cmbDependencia2.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo(){
		recargarMaterias(cmbNucleo.getValue());
		recargarMicrocurriculos(cmbNucleo.getValue());
		
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo2(){
		recargarMaterias2(cmbNucleo2.getValue());
		recargarMicrocurriculos2(cmbNucleo2.getValue());
		
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMateria este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbMateria(){
		recargarMicrocurriculos(cmbMateria.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMateria2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbMateria2(){
		recargarMicrocurriculos2(cmbMateria2.getValue());
	}
	/**
	 * Ante el evento seleccion en el combobox cmbMicrocurriculo2 el metodo procede a guardar en la sesion el
	 * microcurriculo seleccionado
	 */
	public void onSelect$cmbMicrocurriculo2(){
		String idMicro = cmbMicrocurriculo2.getValue().toString();
		
		if(!idMicro.equals("")&&(!idMicro.equals("[Seleccione]"))){
			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
		}else{
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
	}
	
	/**
	 * Se inicializan todos los combobox
	 */
	private void inicializarFormaListado(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if (comp.getParent().getId().equals("formaListarMicro")){
			inicializarFormaListado();
			cargarMaterias();
			cargarUnidades();
			cargarDependencias();
			cargarNucleos();
			cargarSemestres();
			cargarDocentes();
		} else if(comp.getParent().getId().equals("panelDuplicarMicro")){
			cargarMaterias();
			cargarUnidades();
			cargarDependencias();
			cargarNucleos();
			cargarMicrocurriculos();
			cargarSemestres();
		} else if(comp.getParent().getId().equals("blyConsultarMicro")){
			cargarMaterias();
			cargarUnidades();
			cargarDependencias();
			cargarNucleos();
			cargarMicrocurriculos2();
		}
	}
	
}

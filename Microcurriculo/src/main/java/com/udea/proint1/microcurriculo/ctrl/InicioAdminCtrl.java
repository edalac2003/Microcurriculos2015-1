package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;

public class InicioAdminCtrl extends GenericForwardComposer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(InicioAdminCtrl.class);

	Label lblFechaActual;
	Label lblUsuarioLogin;
	
	private void extraerInformacion(){
		TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuario");
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblFechaActual.setValue(s4);
		TbAdmPersona docenteSession = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		String userName = docenteSession.getVrNombres()+" "+docenteSession.getVrApellidos();
		lblUsuarioLogin.setValue(userName);
	}
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuario")){
			extraerInformacion();
		}else{
			Executions.getCurrent().sendRedirect("/index.zul");
		}
		
		
	}	
}

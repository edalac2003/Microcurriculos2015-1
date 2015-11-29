package com.udea.proint1.microcurriculo.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

@SuppressWarnings("rawtypes")
public class BorrarVariablesSession extends GenericForwardComposer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static Logger logger = Logger.getLogger(BorrarVariablesSession.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		Executions.getCurrent().getSession().removeAttribute("idMicro");
		Executions.getCurrent().getSession().removeAttribute("semestre");
		Executions.getCurrent().getSession().removeAttribute("materia");
	}
}

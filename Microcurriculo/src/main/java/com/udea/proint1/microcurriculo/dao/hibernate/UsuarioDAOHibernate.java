package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UsuarioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public void guardarUsuarios(TbAdmUsuario usuario) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(usuario);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmUsuario obtenerUsuarios(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmUsuario usuario = null;

		try {
			session = getSession();
			usuario = (TbAdmUsuario) session.get(TbAdmUsuario.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return usuario;
	}

	@Override
	public List<TbAdmUsuario> listarUsuarios() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmUsuario> usuarios = new ArrayList<TbAdmUsuario>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUsuario.class);
			
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return usuarios;
	}

	@Override
	public void actualizarUsuarios(TbAdmUsuario usuario) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(usuario);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}

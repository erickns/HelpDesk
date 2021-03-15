package com.ens.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ens.service.ChamadoService;

public class Repository extends HibernateUtil{
	private static final Logger logger = Logger.getLogger(ChamadoService.class.getName());
	
	public Query getresultQuery(String qs) {
		Session session = null;
		Query query = null;
		try {
			session = this.getSessionFactory().openSession();
			query = session.createQuery(qs);
		}catch(Exception e) {
			logger.log(Level.WARNING, e.getMessage(),e);
			e.printStackTrace();
		}
		return query;
	}
	


}

package com.ens.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ens.service.ChamadoService;

public class HibernateUtil {

	
	private static final SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(ChamadoService.class.getName());
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex) {
			logger.log(Level.WARNING, ex.getMessage(),ex);
			System.err.println("Initial SessionFactory creation failed "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}


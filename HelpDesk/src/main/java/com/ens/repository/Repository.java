package com.ens.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Repository extends HibernateUtil{
	
	public Query getresultQuery(String qs) {
		Session session = this.getSessionFactory().openSession();
		return session.createQuery(qs);
	}
	


}

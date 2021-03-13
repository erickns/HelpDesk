package com.ens.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Repository extends HibernateUtil{
	
	public Query getresultQuery(String qs) {
		Session session = null;
		Query query = null;
		try {
			session = this.getSessionFactory().openSession();
			query = session.createQuery(qs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query;
	}
	


}

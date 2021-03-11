package com.ens.repository;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ens.dto.ConsultaDTO;
import com.ens.model.Chamado;

public class ChamadosRepository extends Repository{

	
	public List<Chamado> listar(ConsultaDTO dto){
		
		/*
		 * Long id; private DominioStatus Status; private Date dtInclusao; private Date
		 * dtConclusao;
		 */
		String queryString = "select * from chamado chamado where";
		
		Query<Chamado> query= this.getresultQuery(queryString);
		
		query.setBigDecimal("campo", Objec o);
		
		return query.getResultList();
	
	}
	
	public Chamado buscar(Long id){
		return (Chamado) this.getSessionFactory().openSession().get(Chamado.class, id);
	}
	
	public void salvar(Chamado chamado){
		Session s = this.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try {
			if(chamado.getId()==null) {
				s.save(chamado);
			}
			else {
				s.update(chamado);
			}
		t.commit();
		s.close();
		}catch(Exception e) {
			if(s.isConnected()) {
				s.close();
			}
			e.printStackTrace();
		}
	}
}

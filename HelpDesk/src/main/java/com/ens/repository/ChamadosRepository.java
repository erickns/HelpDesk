package com.ens.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ens.dto.ConsultaDTO;
import com.ens.model.Chamado;
import com.ens.model.Comentario;
import com.ens.utils.Util;

public class ChamadosRepository extends Repository {

	
	
	public ChamadosRepository() {
		super();
	}

	public List<Chamado> listarChamado(ConsultaDTO dto) {

		String queryString = "from Chamado chamado where 1=1 ";
		queryString = dto.getId() != null ? queryString.concat("and id = :id ") : queryString;
		queryString = dto.getStatus() != null ? queryString.concat("and status = :status ") : queryString;
		queryString = dto.getDtInicio() != null && dto.getDtFim() != null
				? queryString.concat("and dtInclusao >= :dtInicio ").concat("and dtInclusao <= :dtFim")
				: queryString;

		Query<Chamado> query = this.getresultQuery(queryString);
		if (dto.getId() != null) {
			query.setLong("id", dto.getId());
		}
		if (dto.getStatus() != null) {
			query.setString("status", dto.getStatus().getValue());
		}
		if (dto.getDtInicio() != null && dto.getDtFim() != null) {
			query.setString("dtInicio", dto.getDtInicio());
			query.setString("dtFim", dto.getDtFim());
		}

		return query.getResultList();

	}

	public Chamado buscar(Long id) {
		return (Chamado) this.getSessionFactory().openSession().get(Chamado.class, id);
	}

	public Long salvarChamado(Chamado chamado) {
		Session s = this.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
			if (chamado.getId() == null) {
				s.save(chamado);
			} else {
				s.update(chamado);
			}
			t.commit();
			s.close();
			
		return chamado.getId();
	}
	
	
	public List<Comentario> listarComentarios(Long idChamado) {
		Query<Comentario> query = null;
		if (idChamado != null) {
			String queryString = "from Comentario where idChamado = :id ";
			query = this.getresultQuery(queryString);
			query.setLong("id", idChamado);
		}
		List<Comentario> retorno = query.getResultList();

		return retorno;

	}
	
	
	public Long salvarComentario(Comentario comentario) {
		Session s = this.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		try {
			if (comentario.getId() == null) {
				s.save(comentario);
			} else {
				s.update(comentario);
			}
			t.commit();
			s.close();
		} catch (Exception e) {
			if (s.isConnected()) {
				s.close();
			}
			e.printStackTrace();
		}
		if (s.isConnected()) {
			s.close();
		}
		
		return comentario.getId();
	}
}

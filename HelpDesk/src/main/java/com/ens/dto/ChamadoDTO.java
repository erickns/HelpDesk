package com.ens.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ens.model.Chamado;
import com.ens.model.Comentario;
import com.ens.model.domain.DominioStatus;
import com.ens.utils.Util;

public class ChamadoDTO {
	
	
	private Long id;
	private String titulo;
	private String statusValue;
	private String descricao;
	private Date dtInclusao;
	private Date dtConclusao;
	private List<Comentario> comentarios;
	
	public ChamadoDTO() {
		
	}
	
	public ChamadoDTO(Long id, String titulo, String statusValue, String descricao, String dtInclusao,String dtConclusao,
			List<Comentario> comentarios) {
		
		this.id = id != null ? id : null;
		this.titulo =  titulo !=null && !titulo.equals("") ? titulo : "";
		this.statusValue =  statusValue !=null && !statusValue.equals("") ? statusValue : DominioStatus.DEFAULT.getValue();
		this.descricao = descricao !=null && !descricao.equals("") ? descricao : "";
		this.dtInclusao = dtInclusao !=null && !dtInclusao.equals("")  ? Util.stringParaData(dtInclusao) : new Date();
		this.dtConclusao = dtConclusao !=null && !dtConclusao.equals("") ? Util.stringParaData(dtConclusao) : null;
	}
	
	public ChamadoDTO(Chamado chamado) {
		this.id = chamado.getId();
		this.titulo = chamado.getTitulo();
		this.statusValue = chamado.getStatus().toValue();
		this.descricao = chamado.getDescriçao();
		this.dtInclusao = chamado.getDtInclusao();
		this.dtConclusao = chamado.getDtConclusao();
		this.comentarios = new ArrayList<Comentario>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public DominioStatus getStatus() {
		return DominioStatus.fromValue(statusValue); 
	}
	public void setStatus(DominioStatus status) {
		this.statusValue = status.toValue();  
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	public Date getDtConclusao() {
		return dtConclusao;
	}
	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "ChamadoDTO {id:" + id 
				+ ", titulo:" + titulo 
				+ ", Status:" + statusValue 
				+ ", descricao:" + descricao
				+ ", dtInclusao:" + Util.dataParaString(dtInclusao) 
				+ ", dtConclusao:" + Util.dataParaString(dtConclusao) 
				+ ", comentarios:" + comentarios + "}";
	}
	
	
	
}

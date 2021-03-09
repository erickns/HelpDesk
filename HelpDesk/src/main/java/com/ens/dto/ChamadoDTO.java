package com.ens.dto;

import java.util.Date;
import java.util.List;

import com.ens.model.Comentario;
import com.ens.model.domain.DominioStatus;

public class ChamadoDTO {
	
	
	private Long id;
	private String titulo;
	private DominioStatus Status;
	private String descrição;
	private Date dtInclusao;
	private Date dtConclusao;
	private List<Comentario> comentarios;
	
	
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
		return Status;
	}
	public void setStatus(DominioStatus status) {
		Status = status;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
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
	
}

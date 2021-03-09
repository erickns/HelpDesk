package com.ens.model;

import java.util.Date;

import com.ens.model.domain.DominioStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chamado {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 255)
	private String titulo;
	@Enumerated
	private DominioStatus Status;
	@Column(length = 1000)
	private String descrição;
	private Date dtInclusao;
	private Date dtConclusao;
	
	
	public Long getId() {
		return this.id;
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
	

}

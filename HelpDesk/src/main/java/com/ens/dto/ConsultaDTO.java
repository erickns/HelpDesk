package com.ens.dto;

import java.util.Date;

import com.ens.model.domain.DominioStatus;

public class ConsultaDTO {
	
	private Long id;
	private DominioStatus Status;
	private Date dtInclusao;
	private Date dtConclusao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DominioStatus getStatus() {
		return Status;
	}
	public void setStatus(DominioStatus status) {
		Status = status;
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

package com.ens.dto;

import java.util.Date;

import com.ens.model.domain.DominioStatus;
import com.ens.utils.Util;

public class ConsultaDTO {
	
	private Long id;
	private String statusValue;
	private String dtInicio;
	private String dtFim;
	
	
	
	public ConsultaDTO(Long id, String status, String dtInicio, String dtFim) {
		this.id = id != null ? id : null;
		this.statusValue =  statusValue !=null && !statusValue.equals("") ? statusValue : null;
		this.dtInicio = dtInicio !=null && !dtInicio.equals("")  ? dtInicio : null;
		this.dtFim = dtFim !=null && !dtFim.equals("") ? dtFim : null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DominioStatus getStatus() {
		return DominioStatus.fromValue(statusValue); 
	}
	public void setStatus(DominioStatus status) {
		this.statusValue = status.toValue();  
	}
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInclusao) {
		this.dtInicio = dtInclusao;
	}
	public String getDtFim() {
		return dtFim;
	}
	public void setDtFim(String dtConclusao) {
		this.dtFim = dtConclusao;
	}
	@Override
	public String toString() {
		return "ConsultaDTO {id:" + id 
				+ ", Status:" + statusValue 
				+ ", dtInicio:" + dtInicio
				+ ", dtFim:" + dtFim + "}";
	}
	
	
	

}

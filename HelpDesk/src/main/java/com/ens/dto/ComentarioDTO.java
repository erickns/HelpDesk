package com.ens.dto;

import java.util.Date;

import com.ens.model.Comentario;
import com.ens.utils.Util;

public class ComentarioDTO {

	private Long id;
	private Long idChamado;
	private String descricao;
	private Date dtInclusao;

	
	
	public ComentarioDTO(Long id, Long idChamado, String descricao, String dtInclusao) {
		this.id = id != null ? id : null;
		this.idChamado = idChamado != null ? idChamado : null;;
		this.descricao = descricao;
		this.dtInclusao = dtInclusao !=null && !dtInclusao.equals("")  ? Util.stringParaData(dtInclusao) : new Date();
	}

	public ComentarioDTO(Comentario comentario) {
		
		this.id = comentario.getId();
		this.idChamado = comentario.getIdChamado();
		this.descricao = comentario.getDescricao();
		this.dtInclusao = comentario.getDtInclusao();
	}
	
	public ComentarioDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	@Override
	public String toString() {
		return "Comentario {id:" + id + ", idChamado:" + idChamado + ", descricao:" + descricao + ", dtInclusao:"
				+ Util.dataParaString(dtInclusao) + "}";
	}
}

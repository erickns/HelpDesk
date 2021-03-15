package com.ens.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ens.dto.ComentarioDTO;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_chamado")
	private Long idChamado;
	
	@Column(name = "descricao", length = 1000)
	private String descricao;
	
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.DATE)
	private Date dtInclusao;
	
	
	
	public Comentario(ComentarioDTO dto) {
		
		this.id = dto.getId();
		this.idChamado = dto.getIdChamado();
		this.descricao = dto.getDescricao();
		this.dtInclusao = dto.getDtInclusao();
	}

	public Comentario() {
		
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
				+ dtInclusao + "}";
	}
	
	

}

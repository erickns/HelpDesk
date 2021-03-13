package com.ens.model;

import java.util.Date;

import com.ens.dto.ChamadoDTO;
import com.ens.model.domain.DominioStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Chamado {
	
	@Id
	private Long id;
	
	@Column(name = "titulo" ,length = 255)
	private String titulo;
	
	
	@Column(name = "status" ,length = 2)
	private String statusValue;
	
	@Column(name = "descricao" ,length = 1000)
	private String descricao;
	
	@Column(name = "dt_inclusao" )
	private Date dtInclusao;
	
	@Column(name = "dt_conclusao" )
	private Date dtConclusao;
	
	public Chamado() {
		
	}
	
	public Chamado(ChamadoDTO chamado) {
		this.id = chamado.getId();
		this.titulo = chamado.getTitulo();
		this.statusValue = chamado.getStatus().toValue();
		this.descricao = chamado.getDescricao();
		this.dtInclusao = chamado.getDtInclusao();
		this.dtConclusao = chamado.getDtConclusao();
	}
	
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
		return DominioStatus.fromValue(statusValue); 
	}
	public void setStatus(DominioStatus status) {
		this.statusValue = status.toValue();  
	}
	public String getDescriçao() {
		return descricao;
	}
	public void setDescrição(String descricao) {
		this.descricao = descricao;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chamado [id=" + id + ", titulo=" + titulo + ", Status=" + statusValue + ", descricao=" + descricao
				+ ", dtInclusao=" + dtInclusao + ", dtConclusao=" + dtConclusao + "]";
	}
	
	

}

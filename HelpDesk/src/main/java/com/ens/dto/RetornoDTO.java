package com.ens.dto;

public class RetornoDTO {
	
	private String status;
	private String mensagem;
	private String protocolo;
	private String codigoStatus;
	
	public static synchronized RetornoDTO create() {
		return new RetornoDTO();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getCodigoStatus() {
		return codigoStatus;
	}

	public void setCodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	
	public RetornoDTO withStatus(String status) {
		this.status = status;
		return this;
	}
	public RetornoDTO withmensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}
	public RetornoDTO withprotocolo(String protocolo) {
		this.protocolo = protocolo;
		return this;
	}
	public RetornoDTO withcodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
		return this;
	}

	@Override
	public String toString() {
		return "RetornoDTO {status:" + status + ", mensagem:" + mensagem + ", protocolo:" + protocolo
				+ ", codigoStatus:" + codigoStatus + "}";
	}

}

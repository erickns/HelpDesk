package com.ens.model.domain;

public enum DominioStatus {
	
	ABERTO("AB","ABERTO"),
	EM_ANALISE("EA","EM ANALISE"),
	FECHADO("FE","FECHADO");
	
	private final String value;
	private final String description;
	
	private DominioStatus(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	

}

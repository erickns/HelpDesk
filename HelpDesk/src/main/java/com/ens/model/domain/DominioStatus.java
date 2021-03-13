package com.ens.model.domain;

public enum DominioStatus {
	
	ABERTO("AB","ABERTO"),
	EM_ANALISE("EA","EM ANALISE"),
	FECHADO("FE","FECHADO"),
	DEFAULT("DF","DEFAULT");
	
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
	
	 public static DominioStatus fromValue(String value) {  
		   if (value != null) {  
		     for (DominioStatus dominioStatus : values()) {  
		       if (dominioStatus.value.equals(value)) {  
		         return dominioStatus;  
		       }  
		     }  
		   }  
		  
		   // you may return a default value  
		   return null;  
		   // or throw an exception  
		   // throw new IllegalArgumentException("Invalid color: " + value);  
		 }  
		  
		 public String toValue() {  
		   return value;  
		 }  
		  
		 public static DominioStatus getDefault() {  
		   return DEFAULT;  
		 } 

}

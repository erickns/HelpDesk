package com.ens.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	
	public static Date stringParaData(String strdata) {		
		SimpleDateFormat formato = new SimpleDateFormat("DD/MM/YYYY"); 
		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(strdata);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dataFormatada;
	}
	
	public static String dataParaString(Date data) {
		SimpleDateFormat out = new SimpleDateFormat("DD/MM/YYYY");  
		String result = out.format(new Date());
		return result;
	}
}

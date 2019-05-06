package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public String formatoISO8601 = "yyyy-MM-dd";
	public String formatoNorteAmericano = "MM-dd-yyyy"; 
	public String formatoLatinoAmericano = "dd/MM/yyyy";
	public Date fechaInicial2;
	
	public String getFormatoISO() {
		return formatoISO8601;
	}

	public String getFormatoNorteAmericano() {
		return formatoNorteAmericano;
	}

	public String getFormatoLatinoAmericano() {
		return formatoLatinoAmericano;
	}
	
	public void fechaInicial(String fecha, String formato) {
		try {
			Date nuevaFecha = new SimpleDateFormat(formato).parse(fecha);
			fechaInicial2 = nuevaFecha;
	    } catch (ParseException e) {}
    }
	
	public boolean esISO8601(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formatoISO8601);
	        formatoFecha.setLenient(false);
	        formatoFecha.parse(fecha);
	    } catch (ParseException e) {
	    	return false;
	    }
		return true;
    }
	
	public boolean esNorteAmericano(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formatoNorteAmericano);
	        formatoFecha.setLenient(false);
	        formatoFecha.parse(fecha);
	    } catch (ParseException e) {
	    	return false;
	    }
		return true;
	}
	
	public boolean esLatinoAmericano(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat(formatoLatinoAmericano);
	        formatoFecha.setLenient(false);
	        formatoFecha.parse(fecha);
	    } catch (ParseException e) {
	    	return false;
	    }
		return true;
	}
	
}
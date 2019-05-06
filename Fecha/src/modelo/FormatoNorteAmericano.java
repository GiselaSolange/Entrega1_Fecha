package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatoNorteAmericano extends Formato{
	
	public boolean esNorteAmericano(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("MM-dd-yyyy");
	        formatoFecha.setLenient(false);
	        formatoFecha.parse(fecha);
	    } catch (ParseException e) {
	    	return false;
	    }
		return true;
	}
}

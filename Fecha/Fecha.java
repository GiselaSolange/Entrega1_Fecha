package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Fecha {
	private SimpleDateFormat formatoISO8601 = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatoLatinoAmericano = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatoNorteAmericano = new SimpleDateFormat("MM-dd-yyyy");
	private String patronISO8601 = "^[0-9]{4}-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$";
	private String patronLatinoAmericano = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	private String patronNorteAmericano = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$"; 
	
	
	public Date convertirAISO8601(String fechaISO) throws ParseException{
		formatoISO8601.setLenient(false);
		return formatoISO8601.parse(fechaISO);
    }
	
	public Date convertirALatinoAmericano(String fechaLatina) throws ParseException{
		formatoLatinoAmericano.setLenient(false);
		return formatoLatinoAmericano.parse(fechaLatina);
    }
	
	public Date convertirANorteAmericano(String fechaAmericana) throws ParseException{
		formatoNorteAmericano.setLenient(false);
		return formatoNorteAmericano.parse(fechaAmericana);
    }
	
	public Date convertirAFecha(String fechaAConvertir) throws ParseException{
		Date date = null;
		if (Pattern.matches(patronISO8601, fechaAConvertir)) {
		date = convertirAISO8601(fechaAConvertir);
		}
		else if (Pattern.matches(patronLatinoAmericano, fechaAConvertir)) {
			date = convertirALatinoAmericano(fechaAConvertir);
		}
		else if (Pattern.matches(patronNorteAmericano, fechaAConvertir)) {
			date = convertirANorteAmericano(fechaAConvertir);
		}
		else {
			throw new ParseException ("El formato de la fecha ingresada no es valido", 0);
		}
		return date;
	}
	
	public int obtenerDiasDeDiferencia(Date fechaInicial, Date fechaFinal){
		return Math.abs((int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000));
	}

	public boolean fechaAesAnteriorAfechaB(Date fechaA, Date fechaB){
		return fechaA.before(fechaB);
	}
}
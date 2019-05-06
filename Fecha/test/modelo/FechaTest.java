package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;
@SuppressWarnings("deprecation")

public class FechaTest {
	
	@Test
	public void esISO8601_SeIngresaUnaFechaConFormatoISO(){
		Fecha fecha = new Fecha();
		String fechaISO = new String ();
		fechaISO = "2019-07-24";
		Assert.assertTrue("El formato de la fecha ingresada no es tipo ISO8601", fecha.esISO8601(fechaISO));
	}
	
	@Test
	public void esLatinoAmericano_SeIngresaUnaFechaConFormatoLatinoAmericano(){
		Fecha fecha = new Fecha();
		String fechaLatina = new String ();
		fechaLatina = "24/07/2019";
		Assert.assertTrue("El formato de la fecha ingresada no es tipo Latino", fecha.esLatinoAmericano(fechaLatina));
	}
	
	@Test
	public void esNorteAmericano_SeIngresaUnaFechaConFormatoNorteAmericano(){
		Fecha fecha = new Fecha();
		String fechaAmericana = new String ();
		fechaAmericana = "07-24-2019";
		Assert.assertTrue("El formato de la fecha ingresada no es tipo Norte Americano", fecha.esNorteAmericano(fechaAmericana));
	}
	
	@Test
	public void esFormatoValido_SeIngresaUnaFechaConFormatoIncorrectoYEsComparadaConTodosLosFormatosPermitidos(){
		Fecha fecha = new Fecha();
		String fechaSinFormato = new String ();
		fechaSinFormato = "24/2019/07";
		Assert.assertFalse("El formato de la fecha ingresada es ISO", fecha.esISO8601(fechaSinFormato));
		Assert.assertFalse("El formato de la fecha ingresada es Latino Americano", fecha.esLatinoAmericano(fechaSinFormato));
		Assert.assertFalse("El formato de la fecha ingresada es Norte Americano", fecha.esNorteAmericano(fechaSinFormato));
	}
	
	@Test
	public void fechaInicial_SeIngresaUnaFechaValidaYUnFormatoValido() throws ParseException{
		Fecha fecha = new Fecha();
		String fechaValida = new String ();
		fechaValida = "2019-07-24";
		fecha.fechaInicial(fechaValida, fecha.getFormatoISO());
		Date nuevaFecha = new SimpleDateFormat(fecha.getFormatoISO()).parse(fechaValida);
		Assert.assertEquals("La fecha ingresada es invalida", fecha.fechaInicial2, nuevaFecha);
	}
	
}

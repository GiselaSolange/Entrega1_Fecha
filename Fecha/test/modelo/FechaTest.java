package modelo;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import junit.framework.Assert;
@SuppressWarnings("deprecation")

public class FechaTest {
	public Calendar fechaCalendario() {
		Calendar fecha = Calendar.getInstance();
		fecha.clear();
		fecha.set(2019, Calendar.JULY, 24);
        return fecha;
	}
	
	@Test
	public void convertirAISO8601_SeIngresaUnStringFechaYSeConvierteAFormatoISO8601() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaISO8601 = fecha.convertirAISO8601("2019-07-24");
		Calendar fechaEsperada = fechaCalendario();
		Assert.assertTrue("El formato de la fecha ingresada no es tipo ISO8601", fechaEsperada.getTime().equals(fechaISO8601));
	}
	
	@Test(expected = ParseException.class)
	public void convertirAISO8601_SeIngresaUnStringFechaYNoSeConvierteAFormatoISO8601() throws ParseException{
		Fecha fecha = new Fecha();
		fecha.convertirAISO8601("20190724");
	}
	
	@Test
	public void convertirALatinoAmericano_SeIngresaUnStringFechaYSeConvierteAFormatoLatinoAmericano() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaLatinoAmericano = fecha.convertirALatinoAmericano("24/07/2019");
		Calendar fechaEsperada = fechaCalendario();
		Assert.assertTrue("El formato de la fecha ingresada no es tipo Latino Americano", fechaEsperada.getTime().equals(fechaLatinoAmericano));
	}
	
	@Test(expected = ParseException.class)
	public void convertirALatinoAmericano_SeIngresaUnStringFechaYNoSeConvierteAFormatoLatinoAmericano() throws ParseException{
		Fecha fecha = new Fecha();
		fecha.convertirALatinoAmericano("24072019");
	}
	
	@Test
	public void convertirANorteAmericano_SeIngresaUnStringFechaYSeConvierteAFormatoNorteAmericano() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaNorteAmericana = fecha.convertirANorteAmericano("07-24-2019");
		Calendar fechaEsperada = fechaCalendario();
		Assert.assertTrue("El formato de la fecha ingresada no es tipo Norte Americano", fechaEsperada.getTime().equals(fechaNorteAmericana));
	}
	
	@Test(expected = ParseException.class)
	public void convertirANorteAmericano_SeIngresaUnStringFechaYNoSeConvierteAFormatoNorteAmericano() throws ParseException{
		Fecha fecha = new Fecha();
		fecha.convertirANorteAmericano("07242019");
	}
	
	@Test
	public void convertirAFecha_SeIngresaUnStringFechaConFormatoValido() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaValida = fecha.convertirAFecha("24/07/2019");
		Calendar fechaEsperada = fechaCalendario();
		Assert.assertTrue("El formato de la fecha ingresada no es valido", fechaEsperada.getTime().equals(fechaValida));
	}
	
	@Test(expected = ParseException.class)
	public void convertirAFecha_SeIngresaUnStringFechaConFormatoInvalido() throws ParseException{
		Fecha fecha = new Fecha();
		fecha.convertirAFecha("24072019");
	}
	
	@Test
	public void obtenerDiasDeDiferencia_SeIngresaUnaFechaInicialYUnaFechaFinalYSeObtieneLaCantidadDeDiasEntreEllas() throws ParseException{
		Fecha fecha = new Fecha();
		Date FechaIncial = fecha.convertirAFecha("2019-1-29");
		Date fechaFinal = fecha.convertirAFecha("2019-1-31");
		int diferenciaDias = fecha.obtenerDiasDeDiferencia(FechaIncial,fechaFinal);
		Assert.assertEquals("No se puede obtener la cantidad de dias entre las fechas ingresadas", diferenciaDias, 2);
	}
	
	@Test
	public void fechaAesAnteriorAfechaB_SeIngresaUnaFechaAAnteriorALaFechaB() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaA = fecha.convertirAFecha("2018-12-31");
		Date fechaB = fecha.convertirAFecha("2019-1-1");
		Assert.assertTrue("La fecha A es posterior a la fecha B", fecha.fechaAesAnteriorAfechaB(fechaA, fechaB));
	}
	
	@Test
	public void fechaAesAnteriorAfechaB_SeIngresaUnaFechaAPosteriorALaFechaB() throws ParseException{
		Fecha fecha = new Fecha();
		Date fechaA = fecha.convertirAFecha("2019-1-1");
		Date fechaB = fecha.convertirAFecha("2018-12-31");
		Assert.assertFalse("La fecha A es anterior a la fecha B", fecha.fechaAesAnteriorAfechaB(fechaA, fechaB));
	}
	
}

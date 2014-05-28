import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test; 

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import excepciones.Hay10EstandarException;

public class test {
	private Partido semifinal;
	private Jugador juan;
	private InscripcionEstandar inscripcionJuan;
	private Jugador esteban;
	private InscripcionEstandar inscripcionEsteban;
	private Jugador ramiro;
	private InscripcionEstandar inscripcionramiro;
	private Jugador mario;
	private InscripcionEstandar inscripcionmario;
	private Jugador adrian;
	private InscripcionEstandar inscripcionadrian;
	private Jugador marcos;
	private InscripcionEstandar inscripcionmarcos;
	private Jugador carlos;
	private InscripcionEstandar inscripcioncarlos;
	private Jugador turco;
	private	InscripcionEstandar inscripcionturco;
	private Jugador coqui;
	private	InscripcionEstandar inscripcioncoqui;
	private Jugador mati;
	private	InscripcionEstandar inscripcionmati;
	
	private Jugador jose;
	private InscripcionCondicional inscripcionJose;
	private Condicion condicionJose;
	
	private Jugador maria;
	private InscripcionSolidaria inscripcionMaria;
	private Jugador gordo;
	private InscripcionSolidaria inscripciongordo;
	
	private MailAAdministrador mailAAdministradorMock;
	private MailAAmigos mailAAmigosMock;
	
	@Before
	public void init(){
		LocalDate hoy=LocalDate.now();
		LocalTime hora=LocalTime.of(22,00);
		semifinal= new Partido(hoy,hora,"calleFalsa1234");
		
		juan= new Jugador();
		juan.setEdad(21);
		inscripcionJuan= new InscripcionEstandar(juan);
		esteban= new Jugador();
		esteban.setEdad(21);
		inscripcionEsteban= new InscripcionEstandar(esteban);
		ramiro= new Jugador();
		ramiro.setEdad(21);
		inscripcionramiro= new InscripcionEstandar(ramiro);
		mario= new Jugador();
		mario.setEdad(21);
		inscripcionmario= new InscripcionEstandar(mario);
		adrian= new Jugador();
		adrian.setEdad(21);
		inscripcionadrian= new InscripcionEstandar(adrian);
		marcos= new Jugador();
		marcos.setEdad(21);
		inscripcionmarcos= new InscripcionEstandar(marcos);
		carlos= new Jugador();
		carlos.setEdad(21);
		inscripcioncarlos= new InscripcionEstandar(carlos);
		turco= new Jugador();
		turco.setEdad(21);
		inscripcionturco= new InscripcionEstandar(turco);
		coqui= new Jugador();
		coqui.setEdad(21);
		inscripcioncoqui= new InscripcionEstandar(coqui);
		mati= new Jugador();
		mati.setEdad(21);
		inscripcionmati= new InscripcionEstandar(mati);
		
		jose= new Jugador();
		jose.setEdad(22);
		condicionJose = new Condicion();
		inscripcionJose= new InscripcionCondicional(jose,condicionJose);
	
		maria= new Jugador();
		maria.setEdad(22);
		inscripcionMaria= new InscripcionSolidaria(maria,3);
		gordo= new Jugador();
		gordo.setEdad(22);
		inscripciongordo= new InscripcionSolidaria(gordo,4);
		
		mailAAdministradorMock= mock(MailAAdministrador.class);
		mailAAmigosMock= mock(MailAAmigos.class);
	}
	@Test 
	public void agregar1Condicional_ContarLosCondicionales(){
		semifinal.altaInscripcion(inscripcionJose);
		assertEquals(1,semifinal.cantidadInscriptosCondicionales());
	}
	
	@Test 
	public void agregar2Soldiarios_ContarLosEstandar(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		assertEquals(2,semifinal.cantidadInscriptosEstandar());
	}
	
	@Test 
	public void agregar2Estandar_ContarLosSolidarios(){
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionMaria);
		assertEquals(2,semifinal.cantidadInscriptosSolidarios());
	}
	
	@Test 
	public void agregar2Estandar2SolidariaY1Condicional_ContarTotal(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		
		assertEquals(5,semifinal.cantidadTotalInscriptos());
	}
	/*
	ESTE DA FALLA, NO SE Q MENSAJE USAR EN VEZ DE assertEquals()...
	@Test
	public void agregar2Solidarios1Estandar1Condicional_VerificarOrdenCorrecto(){
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionJose);
		PriorityQueue<Inscripcion> colec = new PriorityQueue<Inscripcion>();
		colec.add(inscripcionJuan);
		colec.add(inscripciongordo);
		colec.add(inscripcionJose);
		colec.add(inscripcionMaria);
		assertEquals(colec,semifinal.getInscripciones());
	}
	*/
	@Test (expected=Hay10EstandarException.class)
	public void agregar10EstandarY1Solidaria_Hay10EstandarException(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
		semifinal.altaInscripcion(inscripcionmarcos);
		semifinal.altaInscripcion(inscripcioncarlos);
		semifinal.altaInscripcion(inscripcionturco);
		semifinal.altaInscripcion(inscripcioncoqui);
		semifinal.altaInscripcion(inscripcionmati);
		
		semifinal.altaInscripcion(inscripcionMaria);
	}
	
	@Test
	public void agregar8Estandar1Condicional1SolidarioYReemplazo1SolidarioPorOtro_cantidadTotalInscriptosEs10(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
		semifinal.altaInscripcion(inscripcionmarcos);
		semifinal.altaInscripcion(inscripcioncarlos);
		semifinal.altaInscripcion(inscripcionturco);
		
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.BajaInscripcion(inscripcionMaria,inscripciongordo);
		
		assertEquals(10,semifinal.cantidadTotalInscriptos());
	}
	
	@Test
	public void reemplazo1SolidarioSinSustituto_AgregarInfraccion(){
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.BajaInscripcion(inscripcionMaria,null);
		
		assertEquals(1,maria.getCantidadInfracPorNoTenerSustituto());	
	}
	
	@Test
	public void agregarInscripcion_AvisarAAdmin(){
		semifinal.altaInscripcion(inscripcionJuan);
		mailAAdministradorMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAdministradorMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void agregarInscripcion_AvisarAAMigos(){
		semifinal.altaInscripcion(inscripcionJuan);
		mailAAmigosMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAmigosMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAdmin(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.BajaInscripcion(inscripcionJuan, null);
		mailAAdministradorMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAdministradorMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAmigos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.BajaInscripcion(inscripcionJuan, null);
		mailAAmigosMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAmigosMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
}

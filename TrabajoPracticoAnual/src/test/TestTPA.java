package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test; 

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

import excepciones.Hay10EstandarException;
import excepciones.NoHay10InscriptosParaGenerarEquiposException;



import clases.Condicion;
import clases.CriterioHandicap;
import clases.Inscripcion;
import clases.InscripcionCondicional;
import clases.InscripcionEstandar;
import clases.InscripcionSolidaria;
import clases.Jugador;
import clases.MailAAdministrador;
import clases.MailAAmigos;
import clases.Partido;

public class TestTPA {

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
	private Jugador franco;
	private InscripcionCondicional inscripcionfranco;
	private Condicion condicionfranco;
	private Jugador dani;
	private InscripcionCondicional inscripciondani;
	private Condicion condiciondani;
	
	private Jugador maria;
	private InscripcionSolidaria inscripcionMaria;
	private Jugador gordo;
	private InscripcionSolidaria inscripciongordo;
	
	private MailAAdministrador mailAAdministradorMock;
	private MailAAmigos mailAAmigosMock;
	private CriterioHandicap criterioHandicap;
	
	@Before
	public void init(){
		LocalDate hoy=LocalDate.now();
		LocalTime hora=LocalTime.of(22,00);
		semifinal= new Partido(hoy,hora,"calleFalsa1234");
		
		juan= new Jugador(21);
		juan.setHandicap(1);
		inscripcionJuan= new InscripcionEstandar(juan);
		esteban= new Jugador(21);
		esteban.setHandicap(2);
		inscripcionEsteban= new InscripcionEstandar(esteban);
		ramiro= new Jugador(21);
		ramiro.setHandicap(3);
		inscripcionramiro= new InscripcionEstandar(ramiro);
		mario= new Jugador(21);
		mario.setHandicap(4);
		inscripcionmario= new InscripcionEstandar(mario);
		adrian= new Jugador(21);
		adrian.setHandicap(5);
		inscripcionadrian= new InscripcionEstandar(adrian);
		marcos= new Jugador(21);
		marcos.setHandicap(6);
		inscripcionmarcos= new InscripcionEstandar(marcos);
		carlos= new Jugador(21);
		carlos.setHandicap(7);
		inscripcioncarlos= new InscripcionEstandar(carlos);
		turco= new Jugador(21);
		turco.setHandicap(8);
		inscripcionturco= new InscripcionEstandar(turco);
		coqui= new Jugador(21);
		coqui.setHandicap(9);
		inscripcioncoqui= new InscripcionEstandar(coqui);
		mati= new Jugador(21);
		mati.setHandicap(10);
		inscripcionmati= new InscripcionEstandar(mati);
		
		jose= new Jugador(21);
		condicionJose = new Condicion();
		inscripcionJose= new InscripcionCondicional(jose,condicionJose);
		franco= new Jugador(21);
		condicionfranco = new Condicion();
		inscripcionfranco= new InscripcionCondicional(franco,condicionfranco);
		dani= new Jugador(21);
		condiciondani = new Condicion();
		inscripciondani= new InscripcionCondicional(dani,condiciondani);
	
		maria= new Jugador(21);
		inscripcionMaria= new InscripcionSolidaria(maria);
		gordo= new Jugador(21);
		inscripciongordo= new InscripcionSolidaria(gordo);
		
		mailAAdministradorMock= mock(MailAAdministrador.class);
		mailAAmigosMock= mock(MailAAmigos.class);
	
	}
	
	@Test 
	public void agregar1Condicional_ContarLosCondicionales(){
		semifinal.altaInscripcion(inscripcionJose);
		assertEquals(1,semifinal.cantidadInscriptosCondicionales());
	}
	
	@Test 
	public void agregar2Estandar_ContarLosEstandar(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		assertEquals(2,semifinal.cantidadInscriptosEstandar());
	}
	
	@Test 
	public void agregar2Solidarios_ContarLosSolidarios(){
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionMaria);
		assertEquals(2,semifinal.cantidadInscriptosSolidarios());
	}
	
	
	@Test 
	public void agregar2Estandar2SolidariaY1Condicional_cantidadTotalInscriptos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		
		assertEquals(5,semifinal.cantidadTotalInscriptos());
	}
	
	@Test
	public void agregar2Solidarios1Estandar1Condicional_VerificarOrdenCorrecto(){
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionJose);
		
		assertEquals(inscripcionJuan,semifinal.getInscripciones().poll());
		assertEquals(inscripcionJose,semifinal.getInscripciones().poll());
		assertEquals(inscripciongordo,semifinal.getInscripciones().poll());
		assertEquals(inscripcionMaria,semifinal.getInscripciones().poll());		
	}


//VER SI CAMBIA
	@Test
	public void agregar5Estandar3Condicional2Solidario_generarEquipos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
	
		semifinal.altaInscripcion(inscripciondani);
		semifinal.altaInscripcion(inscripcionfranco);
		semifinal.altaInscripcion(inscripcionJose);
	
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.generarEquipos();
	
		assertTrue(semifinal.getEquipo1().contains(inscripcionJuan));
		assertTrue(semifinal.getEquipo1().contains(inscripcionEsteban));
		assertTrue(semifinal.getEquipo1().contains(inscripcionramiro));
		assertTrue(semifinal.getEquipo1().contains(inscripcionmario));
		assertTrue(semifinal.getEquipo1().contains(inscripcionadrian));
 		assertTrue(semifinal.getEquipo2().contains(inscripcionfranco));
		assertTrue(semifinal.getEquipo2().contains(inscripcionMaria));
		assertTrue(semifinal.getEquipo2().contains(inscripcionJose));
		assertTrue(semifinal.getEquipo2().contains(inscripciongordo));
		assertTrue(semifinal.getEquipo2().contains(inscripciondani));
}

//VER SI CAMBIA
	@Test(expected=NoHay10InscriptosParaGenerarEquiposException.class)
	public void agregar5Estandar3CondicionalYGenerarEquipos_SeGeneraExcepcionPqNoHay10Inscriptos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
	
		semifinal.altaInscripcion(inscripciondani);
		semifinal.altaInscripcion(inscripcionfranco);
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.generarEquipos();
}
	
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
	
	@Test 
	public void ordenarPrimeros10_conCriterioHandicap(){
		//tienen handicap ascendente de 1 a 10
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
		criterioHandicap= new CriterioHandicap();
		semifinal.agregarcriterioDeOrganizacion(criterioHandicap);	
		PriorityQueue<Inscripcion> inscripcionesOrdenadas = semifinal.ordenarPrimeros10();
		
		assertEquals(inscripcionJuan,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionEsteban,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionramiro,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionmario,inscripcionesOrdenadas.poll());	
		assertEquals(inscripcionadrian,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionmarcos,inscripcionesOrdenadas.poll());
		assertEquals(inscripcioncarlos,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionturco,inscripcionesOrdenadas.poll());
		assertEquals(inscripcioncoqui,inscripcionesOrdenadas.poll());
		assertEquals(inscripcionmati,inscripcionesOrdenadas.poll());
	}
	
}


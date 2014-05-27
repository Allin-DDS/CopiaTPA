import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test; 
import java.time.LocalDate;
import java.time.LocalTime;
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
		inscripcionJuan= new InscripcionEstandar();
		inscripcionJuan.setJugador(juan);
		esteban= new Jugador();
		esteban.setEdad(21);
		inscripcionEsteban= new InscripcionEstandar();
		inscripcionEsteban.setJugador(esteban);
		ramiro= new Jugador();
		ramiro.setEdad(21);
		inscripcionramiro= new InscripcionEstandar();
		inscripcionramiro.setJugador(ramiro);
		mario= new Jugador();
		mario.setEdad(21);
		inscripcionmario= new InscripcionEstandar();
		inscripcionmario.setJugador(mario);
		adrian= new Jugador();
		adrian.setEdad(21);
		inscripcionadrian= new InscripcionEstandar();
		inscripcionadrian.setJugador(adrian);
		marcos= new Jugador();
		marcos.setEdad(21);
		inscripcionmarcos= new InscripcionEstandar();
		inscripcionmarcos.setJugador(marcos);
		carlos= new Jugador();
		carlos.setEdad(21);
		inscripcioncarlos= new InscripcionEstandar();
		inscripcioncarlos.setJugador(carlos);
		turco= new Jugador();
		turco.setEdad(21);
		inscripcionturco= new InscripcionEstandar();
		inscripcionturco.setJugador(turco);
		coqui= new Jugador();
		coqui.setEdad(21);
		inscripcioncoqui= new InscripcionEstandar();
		inscripcioncoqui.setJugador(coqui);
		mati= new Jugador();
		mati.setEdad(21);
		inscripcionmati= new InscripcionEstandar();
		inscripcionmati.setJugador(mati);
		
		jose= new Jugador();
		jose.setEdad(22);
		inscripcionJose= new InscripcionCondicional();
		inscripcionJose.setJugador(jose);
		condicionJose = new Condicion();
		inscripcionJose.setCondicion(condicionJose);
		
		maria= new Jugador();
		maria.setEdad(22);
		inscripcionMaria= new InscripcionSolidaria();
		inscripcionMaria.setJugador(maria);
		gordo= new Jugador();
		gordo.setEdad(22);
		inscripciongordo= new InscripcionSolidaria();
		inscripciongordo.setJugador(gordo);
		
		mailAAdministradorMock= mock(MailAAdministrador.class);
		mailAAmigosMock= mock(MailAAmigos.class);
	}
	@Test 
	public void agregar1Condicional_ContarLosCondicionales(){
		semifinal.agregarInscripcion(inscripcionJose);
		assertEquals(1,semifinal.cantidadInscriptosCondicionales());
	}
	
	@Test 
	public void agregar2Soldiarios_ContarLosEstandar(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		assertEquals(2,semifinal.getCantidadInscriptosEstandar());
	}
	
	@Test 
	public void agregar2Estandar_ContarLosSolidarios(){
		semifinal.agregarInscripcion(inscripciongordo);
		semifinal.agregarInscripcion(inscripcionMaria);
		assertEquals(2,semifinal.cantidadInscriptosSolidarios());
	}
	
	@Test 
	public void agregar2Estandar2SolidariaY1Condicional_ContarTotal(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		
		semifinal.agregarInscripcion(inscripcionJose);
		
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.agregarInscripcion(inscripciongordo);
		
		assertEquals(5,semifinal.cantidadTotalInscriptos());
	}
	
	@Test
	public void agregar8Estandar1Condicional2SolidariosYCompletarPosibles10_cantidadInscriptosPosiblesEs10(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		semifinal.agregarInscripcion(inscripcionramiro);
		semifinal.agregarInscripcion(inscripcionmario);
		semifinal.agregarInscripcion(inscripcionadrian);
		semifinal.agregarInscripcion(inscripcionmarcos);
		semifinal.agregarInscripcion(inscripcioncarlos);
		semifinal.agregarInscripcion(inscripcionturco);
		
		semifinal.agregarInscripcion(inscripcionJose);
		
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.agregarInscripcion(inscripciongordo);
		semifinal.completarPosibles10();
		assertEquals(10,semifinal.cantidadInscriptosPosibles10());
	}
	
	@Test
	public void agregar8Estandar1Condicional2SolidariosYcompletarPosibles10_Sobra1Solidario(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		semifinal.agregarInscripcion(inscripcionramiro);
		semifinal.agregarInscripcion(inscripcionmario);
		semifinal.agregarInscripcion(inscripcionadrian);
		semifinal.agregarInscripcion(inscripcionmarcos);
		semifinal.agregarInscripcion(inscripcioncarlos);
		semifinal.agregarInscripcion(inscripcionturco);
		
		semifinal.agregarInscripcion(inscripcionJose);
		
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.agregarInscripcion(inscripciongordo);
		semifinal.completarPosibles10();
		assertEquals(1,semifinal.pilaInscripcionesSolidarias.size());
	}
	
	@Test (expected=Hay10EstandarException.class)
	public void agregar10EstandarY1Solidaria_Hay10EstandarException(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		semifinal.agregarInscripcion(inscripcionramiro);
		semifinal.agregarInscripcion(inscripcionmario);
		semifinal.agregarInscripcion(inscripcionadrian);
		semifinal.agregarInscripcion(inscripcionmarcos);
		semifinal.agregarInscripcion(inscripcioncarlos);
		semifinal.agregarInscripcion(inscripcionturco);
		semifinal.agregarInscripcion(inscripcioncoqui);
		semifinal.agregarInscripcion(inscripcionmati);
		
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.completarPosibles10();
	}
	
	@Test
	public void agregar8Estandar1Condicional1SolidarioYReemplazo1SolidarioPorOtro_NoSobranSolidarios(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		semifinal.agregarInscripcion(inscripcionramiro);
		semifinal.agregarInscripcion(inscripcionmario);
		semifinal.agregarInscripcion(inscripcionadrian);
		semifinal.agregarInscripcion(inscripcionmarcos);
		semifinal.agregarInscripcion(inscripcioncarlos);
		semifinal.agregarInscripcion(inscripcionturco);
		
		semifinal.agregarInscripcion(inscripcionJose);
		
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.reemplazarInscripcion(inscripcionMaria,inscripciongordo);
		semifinal.completarPosibles10();
		assertEquals(0,semifinal.pilaInscripcionesSolidarias.size());
	}
	
	@Test
	public void reemplazo1SolidarioSinSustituto_AgregarInfraccion(){
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.reemplazarInscripcion(inscripcionMaria,null);
		semifinal.completarPosibles10();
		assertEquals(1,maria.getCantidadInfracPorNoTenerSustituto());	
	}
	
	@Test
	public void agregarInscripcion_AvisarAAdmin(){
		semifinal.agregarInscripcion(inscripcionJuan);
		mailAAdministradorMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAdministradorMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void agregarInscripcion_AvisarAAMigos(){
		semifinal.agregarInscripcion(inscripcionJuan);
		mailAAmigosMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAmigosMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAdmin(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.reemplazarInscripcion(inscripcionJuan, null);
		mailAAdministradorMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAdministradorMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAmigos(){
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.reemplazarInscripcion(inscripcionJuan, null);
		mailAAmigosMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAmigosMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
}

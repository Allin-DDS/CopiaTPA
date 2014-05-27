import static org.junit.Assert.*;

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
		
		
	}
	
	@Test
	public void agregar8Estandar1Condicional2Solidarios_Quedan10enPosibles10(){
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
	public void agregar8Estandar1Condicional2Solidarios_Sobra1Solidario(){
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
	public void agregar8Estandar1Condicional1SolidarioYReemplazo1SolidarioPorOtro_NoSobraSolidarios(){
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
}

package testTPA;

import ordenamiento.CriterioHandicap;
import ordenamiento.CriterioUltimasNCalificaciones;
import futbol5.Jugador;
import futbol5.Partido;
import dividirEquipos.CriterioParesEImpares;
import inscripcion.Condicion;
import inscripcion.Inscripcion;
import inscripcion.InscripcionCondicional;
import inscripcion.InscripcionEstandar;
import inscripcion.InscripcionSolidaria;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test; 

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class testOrdenarYGenerarEquipos {

	private Partido semifinal;
	private Partido pfinal;
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

	private CriterioHandicap criterioHandicap;
	private CriterioUltimasNCalificaciones criterioUltimas2Calificaciones;
	private CriterioParesEImpares criterioParesEImpares;

	@Before
	public void init(){
		LocalDate hoy=LocalDate.now();
		LocalTime hora=LocalTime.of(22,00);
		semifinal= new Partido(hoy,hora,"calleFalsa1234");
		pfinal= new Partido(hoy,hora,"calleFalsa1234");

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

		jose= new Jugador(21);
		jose.setHandicap(6);
		condicionJose = new Condicion();
		inscripcionJose= new InscripcionCondicional(jose,condicionJose);
		franco= new Jugador(21);
		franco.setHandicap(7);
		condicionfranco = new Condicion();
		inscripcionfranco= new InscripcionCondicional(franco,condicionfranco);
		dani= new Jugador(21);
		dani.setHandicap(8);
		condiciondani = new Condicion();
		inscripciondani= new InscripcionCondicional(dani,condiciondani);

		maria= new Jugador(21);
		maria.setHandicap(9);
		inscripcionMaria= new InscripcionSolidaria(maria);
		gordo= new Jugador(21);
		gordo.setHandicap(10);
		inscripciongordo= new InscripcionSolidaria(gordo);
		criterioHandicap= new CriterioHandicap();
		criterioUltimas2Calificaciones= new CriterioUltimasNCalificaciones(2);
		criterioParesEImpares= new CriterioParesEImpares();
		
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
	}

	@Test
	public void ordenarInscriptosConCriterioHandicap(){
		semifinal.setCriterioDeOrden(criterioHandicap);
		semifinal.setCriterioParaDividirEquipos(criterioParesEImpares);
		PriorityQueue<Inscripcion> primeros10Ordenados = semifinal.ordenarPrimeros10();

		assertTrue(primeros10Ordenados.poll()==inscripcionJuan);
		assertTrue(primeros10Ordenados.poll()==inscripcionEsteban);
		assertTrue(primeros10Ordenados.poll()==inscripcionramiro);
		assertTrue(primeros10Ordenados.poll()==inscripcionmario);
		assertTrue(primeros10Ordenados.poll()==inscripcionadrian);
		assertTrue(primeros10Ordenados.poll()==inscripcionJose);
		assertTrue(primeros10Ordenados.poll()==inscripcionfranco);
		assertTrue(primeros10Ordenados.poll()==inscripciondani);
		assertTrue(primeros10Ordenados.poll()==inscripcionMaria);
		assertTrue(primeros10Ordenados.poll()==inscripciongordo);

	}

	@Test
	public void ordenarInscriptosConCriterioUltimas2Calif(){
		semifinal.setCriterioDeOrden(criterioHandicap);
		semifinal.setCriterioParaDividirEquipos(criterioParesEImpares);
		semifinal.generarEquipos(semifinal.ordenarPrimeros10());
		semifinal.equiposConfirmados();
		esteban.calificarA(juan,semifinal,"bla",2);
		ramiro.calificarA(juan,semifinal,"bla",4);
		juan.calificarA(esteban,semifinal,"bla",2);
		esteban.calificarA(esteban,semifinal,"bla",2);
		juan.calificarA(ramiro,semifinal,"bla",4);
		esteban.calificarA(ramiro,semifinal,"bla",4);
		juan.calificarA(mario,semifinal,"bla",5);
		esteban.calificarA(mario,semifinal,"bla",5);
		juan.calificarA(adrian,semifinal,"bla",6);
		esteban.calificarA(adrian,semifinal,"bla",6);
		juan.calificarA(dani,semifinal,"bla",7);
		esteban.calificarA(dani,semifinal,"bla",7);
		juan.calificarA(franco,semifinal,"bla",8);
		esteban.calificarA(franco,semifinal,"bla",8);
		juan.calificarA(jose,semifinal,"bla",9);
		esteban.calificarA(jose,semifinal,"bla",9);
		juan.calificarA(maria,semifinal,"bla",9);
		esteban.calificarA(maria,semifinal,"bla",10);
		juan.calificarA(gordo,semifinal,"bla",10);
		esteban.calificarA(gordo,semifinal,"bla",10);

		pfinal.altaInscripcion(inscripcionJuan);
		pfinal.altaInscripcion(inscripcionEsteban);
		pfinal.altaInscripcion(inscripcionramiro);
		pfinal.altaInscripcion(inscripcionmario);
		pfinal.altaInscripcion(inscripcionadrian);
		pfinal.altaInscripcion(inscripciondani);
		pfinal.altaInscripcion(inscripcionfranco);
		pfinal.altaInscripcion(inscripcionJose);
		pfinal.altaInscripcion(inscripcionMaria);
		pfinal.altaInscripcion(inscripciongordo);

		pfinal.setCriterioDeOrden(criterioUltimas2Calificaciones);
		PriorityQueue<Inscripcion> primeros10Ordenados = pfinal.ordenarPrimeros10();
		assertTrue(primeros10Ordenados.poll()==inscripcionEsteban);
		assertTrue(primeros10Ordenados.poll()==inscripcionJuan);
		assertTrue(primeros10Ordenados.poll()==inscripcionramiro);
		assertTrue(primeros10Ordenados.poll()==inscripcionmario);
		assertTrue(primeros10Ordenados.poll()==inscripcionadrian);
		assertTrue(primeros10Ordenados.poll()==inscripciondani);
		assertTrue(primeros10Ordenados.poll()==inscripcionfranco);
		assertTrue(primeros10Ordenados.poll()==inscripcionJose);
		assertTrue(primeros10Ordenados.poll()==inscripcionMaria);
		assertTrue(primeros10Ordenados.poll()==inscripciongordo);
	}

	@Test
	public void generarEquiposConCriterioParEImpar(){
		semifinal.setCriterioDeOrden(criterioHandicap);
		semifinal.setCriterioParaDividirEquipos(criterioParesEImpares);
		semifinal.generarEquipos(semifinal.ordenarPrimeros10());
		Collection<Inscripcion> equipo1Esperado = new LinkedList<>();
		equipo1Esperado.add(inscripcionJuan);
		equipo1Esperado.add(inscripcionramiro);
		equipo1Esperado.add(inscripcionadrian);
		equipo1Esperado.add(inscripcionfranco);
		equipo1Esperado.add(inscripcionMaria);
		Collection<Inscripcion> equipo2Esperado = new LinkedList<>();
		equipo2Esperado.add(inscripcionEsteban);
		equipo2Esperado.add(inscripcionmario);
		equipo2Esperado.add(inscripciondani);
		equipo2Esperado.add(inscripcionJose);
		equipo2Esperado.add(inscripciongordo);
		assertTrue(semifinal.getEquipo1().containsAll(equipo1Esperado));
		assertTrue(semifinal.getEquipo2().containsAll(equipo2Esperado));
	}

}

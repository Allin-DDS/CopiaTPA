package ui.arena;

import java.time.LocalDate;
import java.time.LocalTime;

import futbol5.Jugador;
import futbol5.Partido;
import inscripcion.Condicion;
import inscripcion.InscripcionCondicional;
import inscripcion.InscripcionEstandar;
import inscripcion.InscripcionSolidaria;
import ordenamiento.CriterioDeOrden;
import ordenamiento.CriterioHandicap;
import ordenamiento.CriterioUltimasNCalificaciones;
import dividirEquipos.CriterioParaDividirEquipos;
import dividirEquipos.CriterioParesEImpares;

public class RepositorioDeJugadores {

	private Partido partido;
	
	public Partido getPartido() {
		return partido;
	}



	public void setPartido(Partido partido) {
		this.partido = partido;
	}



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
	

	private CriterioHandicap criterioHandicap;
	private CriterioParesEImpares criterioParesEImpares;
//	private Partido partidoAnterior;
	
	

public RepositorioDeJugadores(){

	LocalDate hoy=LocalDate.now();
	LocalTime hora=LocalTime.of(22,00);
	Partido partidoAnterior= new Partido(hoy,hora,"calleFalsa1234");
	partido= new Partido(hoy,hora,"calleFalsa1234");

	juan= new Jugador(21);
	juan.setHandicap(1);
	juan.setNombre("Juan");
	inscripcionJuan= new InscripcionEstandar(juan);
	
	esteban= new Jugador(21);
	esteban.setHandicap(2);
	esteban.setNombre("Esteban");
	inscripcionEsteban= new InscripcionEstandar(esteban);
	
	ramiro= new Jugador(21);
	ramiro.setHandicap(3);
	ramiro.setNombre("Ramiro");
	inscripcionramiro= new InscripcionEstandar(ramiro);
	
	mario= new Jugador(21);
	mario.setHandicap(4);
	mario.setNombre("Mario");
	inscripcionmario= new InscripcionEstandar(mario);
	
	adrian= new Jugador(21);
	adrian.setHandicap(5);
	adrian.setNombre("Adrian");
	inscripcionadrian= new InscripcionEstandar(adrian);
	
	marcos= new Jugador(21);
	marcos.setNombre("Marcos");
	inscripcionmarcos= new InscripcionEstandar(marcos);
	
	carlos= new Jugador(21);
	carlos.setNombre("Carlos");
	inscripcioncarlos= new InscripcionEstandar(carlos);
	
	turco= new Jugador(21);	
	turco.setNombre("Turco");
	inscripcionturco= new InscripcionEstandar(turco);
	
	coqui= new Jugador(21);
	inscripcioncoqui= new InscripcionEstandar(coqui);
	coqui.setNombre("Coqui");
	
	mati= new Jugador(21);
	inscripcionmati= new InscripcionEstandar(mati);
	mati.setNombre("Mati");

	jose= new Jugador(21);
	jose.setHandicap(6);
	jose.setNombre("Jose");
	condicionJose = new Condicion();
	inscripcionJose= new InscripcionCondicional(jose,condicionJose);
	
	franco= new Jugador(21);
	franco.setHandicap(7);
	franco.setNombre("Franco");
	condicionfranco = new Condicion();
	inscripcionfranco= new InscripcionCondicional(franco,condicionfranco);
	
	dani= new Jugador(21);
	dani.setHandicap(8);
	dani.setNombre("Dani");
	condiciondani = new Condicion();
	inscripciondani= new InscripcionCondicional(dani,condiciondani);

	maria= new Jugador(21);
	maria.setHandicap(9);
	maria.setNombre("Maria");
	inscripcionMaria= new InscripcionSolidaria(maria);
	
	gordo= new Jugador(21);
	gordo.setHandicap(10);
	gordo.setNombre("Gordo");
	inscripciongordo= new InscripcionSolidaria(gordo);
	


	partidoAnterior.altaInscripcion(inscripcionJuan);
	partidoAnterior.altaInscripcion(inscripcionEsteban);
	partidoAnterior.altaInscripcion(inscripcionramiro);
	partidoAnterior.altaInscripcion(inscripcionmario);
	partidoAnterior.altaInscripcion(inscripcionadrian);
	partidoAnterior.altaInscripcion(inscripciondani);
	partidoAnterior.altaInscripcion(inscripcionfranco);
	partidoAnterior.altaInscripcion(inscripcionJose);
	partidoAnterior.altaInscripcion(inscripcionMaria);
	partidoAnterior.altaInscripcion(inscripciongordo);
	
	partidoAnterior.setCriterioDeOrden(new CriterioHandicap());
	partidoAnterior.setCriterioParaDividirEquipos(new CriterioParesEImpares());
	partidoAnterior.generarEquipos(partidoAnterior.ordenarPrimeros10());
	partidoAnterior.equiposConfirmados();
	esteban.calificarA(juan,partidoAnterior,"bla",2);
	ramiro.calificarA(juan,partidoAnterior,"bla",4);
	juan.calificarA(esteban,partidoAnterior,"bla",2);
	esteban.calificarA(esteban,partidoAnterior,"bla",2);
	juan.calificarA(ramiro,partidoAnterior,"bla",4);
	esteban.calificarA(ramiro,partidoAnterior,"bla",4);
	juan.calificarA(mario,partidoAnterior,"bla",5);
	esteban.calificarA(mario,partidoAnterior,"bla",5);
	juan.calificarA(adrian,partidoAnterior,"bla",6);
	esteban.calificarA(adrian,partidoAnterior,"bla",6);
	juan.calificarA(dani,partidoAnterior,"bla",7);
	esteban.calificarA(dani,partidoAnterior,"bla",7);
	juan.calificarA(franco,partidoAnterior,"bla",8);
	esteban.calificarA(franco,partidoAnterior,"bla",8);
	juan.calificarA(jose,partidoAnterior,"bla",9);
	esteban.calificarA(jose,partidoAnterior,"bla",9);
	juan.calificarA(maria,partidoAnterior,"bla",9);
	esteban.calificarA(maria,partidoAnterior,"bla",10);
	juan.calificarA(gordo,partidoAnterior,"bla",10);
	esteban.calificarA(gordo,partidoAnterior,"bla",10);

	partido.altaInscripcion(inscripcionJuan);
	partido.altaInscripcion(inscripcionEsteban);
	partido.altaInscripcion(inscripcionramiro);
	partido.altaInscripcion(inscripcionmario);
	partido.altaInscripcion(inscripcionadrian);
	partido.altaInscripcion(inscripciondani);
	partido.altaInscripcion(inscripcionfranco);
	partido.altaInscripcion(inscripcionJose);
	partido.altaInscripcion(inscripcionMaria);
	partido.altaInscripcion(inscripciongordo);

	}









}


package ui.arena;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import futbol5.Administrador;
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
	
	private Partido partidoAnterior;

	
	

public RepositorioDeJugadores(){

	LocalDate hoy=LocalDate.now();
	LocalTime hora=LocalTime.of(22,00);
	partidoAnterior= new Partido(hoy,hora,"calleFalsa1234");
	partido= new Partido(hoy,hora,"calleFalsa1234");

	juan = nuevoJugador(21,"Juan","Juancito","01-02-1992",1);
	inscripcionJuan= new InscripcionEstandar(juan);
	
	esteban= nuevoJugador(21,"Esteban","Steve","01-02-1992",2);
	inscripcionEsteban= new InscripcionEstandar(esteban);
	
	ramiro= nuevoJugador(21,"Ramiro","Rama","01-02-1992",3);
	inscripcionramiro= new InscripcionEstandar(ramiro);
	
	mario= nuevoJugador(34,"Mario","It's My Mario!","01-02-1992",4);
	inscripcionmario= new InscripcionEstandar(mario);
	
	adrian= nuevoJugador(21,"Adrian","Adri","01-02-1992",5);
	inscripcionadrian= new InscripcionEstandar(adrian);
	
	marcos= nuevoJugador(27,"Marcos","Marco","01-02-1992",6);
	inscripcionmarcos= new InscripcionEstandar(marcos);
	
	carlos= nuevoJugador(19,"Carlos","Charly","01-02-1992",2);
	inscripcioncarlos= new InscripcionEstandar(carlos);
	
	turco= nuevoJugador(45,"Carlitos","Turco","01-02-1992",1);
	inscripcionturco= new InscripcionEstandar(turco);
	
	coqui= nuevoJugador(23,"Damian","Coqui","01-02-1992",6);
	inscripcioncoqui= new InscripcionEstandar(coqui);
	coqui.setNombre("Coqui");
	
	mati= nuevoJugador(21,"Matias","Mati","01-02-1992",6);
	inscripcionmati= new InscripcionEstandar(mati);
	mati.setNombre("Mati");

	jose= nuevoJugador(21,"Jose Maria","Josema","01-02-1992",6);
	condicionJose = new Condicion();
	inscripcionJose= new InscripcionCondicional(jose,condicionJose);
	
	franco= nuevoJugador(32,"Franco","Fran","01-02-1992",7);
	condicionfranco = new Condicion();
	inscripcionfranco= new InscripcionCondicional(franco,condicionfranco);
	
	dani= nuevoJugador(17,"Daniel","Dani","01-02-1992",8);
	condiciondani = new Condicion();
	inscripciondani= new InscripcionCondicional(dani,condiciondani);

	maria= nuevoJugador(22,"Maria","Mary","01-02-1992",9);
	inscripcionMaria= new InscripcionSolidaria(maria);
	
	gordo= nuevoJugador(22,"Raul","Gordo","01-02-1992",10);
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



private Jugador nuevoJugador(int edad, String nombre, String apodo,String fecha, int handicap) {
	Jugador jugador = new Jugador(edad);
	jugador.setNombre(nombre);
		

	jugador.setFechaDeNacimiento(fecha);
	//jugador.setFechaDeNacimiento(new SimpleDateFormat("dd/MM/yyyy").format(date));
	jugador.setApodo(apodo);
	jugador.setHandicap(handicap);
	return jugador;
}









}


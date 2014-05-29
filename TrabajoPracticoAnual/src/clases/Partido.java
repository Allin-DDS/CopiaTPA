package clases;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

import excepciones.ElPartidoNoSeJugoException;
import excepciones.Hay10EstandarException;
import excepciones.NoHay10InscriptosParaGenerarEquiposException;

public class Partido {
	private LocalTime horario;
	private LocalDate fecha;
	private String lugar;
	private String motivoRechazo;
	private boolean partidoJugado;
	private Collection<Observador> observadores = new ArrayList<>();
	private PriorityQueue<Inscripcion> inscripciones=(new PriorityQueue<>(Comparator.comparing(inscripcion->inscripcion.getPrioridad())));
	private Collection<Inscripcion> equipo1 = new LinkedList<>();
	private Collection<Inscripcion> equipo2 = new LinkedList<>();
	private Collection<Inscripcion> inscripcionesPropuestas = new ArrayList<>();
	private Collection<InscripcionRechazada> inscripcionesRechazadas= new LinkedList<>();
	private Collection<Calificacion> calificaciones = new ArrayList<>();
	
	public Partido(LocalDate dia, LocalTime hora,String lugar) {
		this.fecha= dia;
		this.horario= hora;
		this.lugar=lugar;
	}	
	
	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public boolean isPartidoJugado() {
		return partidoJugado;
	}

	public void setPartidoJugado(boolean partidoJugado) {
		this.partidoJugado = partidoJugado;
	}
	
	public Collection<Inscripcion> getEquipo1() {
		return equipo1;
	}

	public void agregarEquipo1(Inscripcion insc) {
		this.equipo1.add(insc);
	}

	public Collection<Inscripcion> getEquipo2() {
		return equipo2;
	}

	public void agregarEquipo2(Inscripcion insc) {
		this.equipo1.add(insc);
	}
	
	public Collection<Observador> getObservadores() {
		return observadores;
	}

	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public Collection<Inscripcion> getInscripcionesPropuestas() {
		return inscripcionesPropuestas;
	}

	public void agregarInscripcionPropuesta(Inscripcion inscripcion) {
		inscripcionesPropuestas.add(inscripcion);
	}
	
	public Collection<InscripcionRechazada> getInscripcionesRechazadas() {
		return inscripcionesRechazadas;
	}

	public void agregarInscripcionRechazada(String motivo,Inscripcion inscripcion) {
		InscripcionRechazada inscRechazada= new InscripcionRechazada(motivo,LocalDate.now(),inscripcion);
		inscripcionesRechazadas.add(inscRechazada);
	}
	
	public  PriorityQueue<Inscripcion> getInscripciones(){
		return inscripciones;
	}
	
	public void altaInscripcion(Inscripcion inscripcion) {
		if(cantidadInscriptosEstandar()>=10){
			throw new Hay10EstandarException("No se puede realizar la inscripcion porque ya hay 10 inscriptos en modo estandar para el partido");
		}
			inscripciones.add(inscripcion);
			 for (Observador observador : observadores)  
				 observador.notificarNuevaInscripcion(inscripcion.jugador,this);
	}
	
	public void BajaInscripcion(Inscripcion inscripcionBaja, Inscripcion inscripcionAlta){
		inscripciones.remove(inscripcionBaja);
		if(inscripcionAlta!= null)
			this.altaInscripcion(inscripcionAlta);
		else{
			inscripcionBaja.jugador.incrementarcantidadInfracPorNoTenerSustituto();
			for (Observador observador : observadores)  
				observador.notificarReemplazoDeInscSinSustituto(this);
		}
	}
	
	public int cantidadInscriptosEstandar() {
		return (int) inscripciones.stream().filter(inscripcion -> inscripcion instanceof InscripcionEstandar).count();
	}
	
	public int cantidadInscriptosCondicionales() {
		return (int) inscripciones.stream().filter(inscripcion -> inscripcion instanceof InscripcionCondicional).count();
	}
	
	public int cantidadInscriptosSolidarios() {
		return (int) inscripciones.stream().filter(inscripcion -> inscripcion instanceof InscripcionSolidaria).count();
	}
	
	public int cantidadTotalInscriptos(){
		return inscripciones.size();  
	}
	
	public void generarEquipos(){
		for (Observador observador : observadores)  
			observador.notificarPartidoConfirmado(this);
		if(this.cantidadTotalInscriptos()<10){
			throw new NoHay10InscriptosParaGenerarEquiposException("No se puede generarEquipos pq no hay 10 jugadores ");
		}
			for(int i=1; i<=5; i++)
				equipo1.add(inscripciones.poll());
			for(int i=1; i<=5; i++)
				equipo2.add(inscripciones.poll());					
	}
	
	//cambiar de clase, es prioridad de sist no de partido
	public void aceptarInscripcionesPropuestas(Inscripcion inscripcion){
		inscripcionesPropuestas.remove(inscripcion);
		this.altaInscripcion(inscripcion);
	}
	//cambiar de clase, es prioridad de sist no de partido	
	public void rechazarInscripcionesPropuestas(Inscripcion inscripcion){
		inscripcionesPropuestas.remove(inscripcion);
		this.agregarInscripcionRechazada(motivoRechazo,inscripcion);
	}
	
	public void agregarCalificacion(Inscripcion inscripcionCalificacdora,Inscripcion inscripcionACalificar,String  comentario,int  nota){
		if(this.isPartidoJugado()){
			throw new ElPartidoNoSeJugoException("El partido no se jugo, no se pueden hacer evaluaciones");
		}
		Calificacion calificacion= new Calificacion(inscripcionCalificacdora,inscripcionACalificar,nota,comentario);
		calificaciones.add(calificacion);
	}
}


package clases;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

import excepciones.Hay10EstandarException;
import excepciones.NoHay10InscriptosParaGenerarEquiposException;

public class Partido {
	private LocalTime horario;
	private LocalDate fecha;
	private String lugar;
	private boolean partidoConfirmado;
	private boolean partidoJugado;
	private Collection<Observador> observadores = new ArrayList<>();
	private PriorityQueue<Inscripcion> inscripciones=(new PriorityQueue<>(Comparator.
			comparing(inscripcion->inscripcion.getPrioridad())));
	private Collection<Inscripcion> equipo1 = new LinkedList<>();
	private Collection<Inscripcion> equipo2 = new LinkedList<>();
	private Collection<CriterioDeOrden> criteriosDeOrden= new LinkedList<>();
	private CriterioParaDividirEquipos criterioParaDividirEquipos;
	
	
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
	
	public boolean getPartidoConfirmado() {
		return partidoConfirmado;
	}

	public void confirmarPartido() {
		this.partidoConfirmado = true;
		for (Observador observador : observadores)  
			observador.notificarPartidoConfirmado(this);
	}
	
	public boolean getPartidoJugado() {
		return partidoJugado;
	}

	public void partidoJugado() {
		this.partidoJugado = true;
	}
	
	public Collection<Inscripcion> getEquipo1() {
		return equipo1;
	}

	public void agregarAEquipo1(Inscripcion insc) {
		this.equipo1.add(insc);
	}

	public Collection<Inscripcion> getEquipo2() {
		return equipo2;
	}

	public void agregarAEquipo2(Inscripcion insc) {
		this.equipo1.add(insc);
	}
	
	public Collection<Observador> getObservadores() {
		return observadores;
	}

	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public Collection<CriterioDeOrden> getCriteriosDeOrden() {
		return criteriosDeOrden;
	}

	public void agregarCriterioDeOrden(CriterioDeOrden criterio) {
		this.criteriosDeOrden.add(criterio);
	}
	
	public CriterioParaDividirEquipos getCriterioParaDividirEquipos() {
		return criterioParaDividirEquipos;
	}

	public void setCriterioParaDividirEquipos(
			CriterioParaDividirEquipos criterioParaDividirEquipos) {
		this.criterioParaDividirEquipos = criterioParaDividirEquipos;
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
	    
	public PriorityQueue<Inscripcion> ordenarPrimeros10(){
		//aca utilizo inscripcionesAux pq quiero no quiero modificar inscripciones, ya q el admin puede ordenar tantas veces 
		//como quiera sin necessidad de recortar la colecc de inscripciones de manera definitiva
		LinkedList<Inscripcion> inscripcionesAux= new LinkedList<Inscripcion>();
		inscripcionesAux.addAll(inscripciones);
		inscripcionesAux.stream().limit(10);
		PriorityQueue<Inscripcion> primeros10Ordenados=(new PriorityQueue<>(Comparator.
				comparing(inscripcion->inscripcion.getJugador().obtenerPromedioFinal(criteriosDeOrden) )));		
		primeros10Ordenados.addAll(inscripcionesAux);
		return primeros10Ordenados;
	}
	
    public void generarEquipos(PriorityQueue<Inscripcion> primeros10Ordenados){
    	if(this.cantidadTotalInscriptos()<10){
    		throw new NoHay10InscriptosParaGenerarEquiposException("No se puede generarEquipos pq no hay 10 jugadores ");
    	}
    	criterioParaDividirEquipos.dividirEquipos(equipo1,equipo2,primeros10Ordenados);					
    }

}
	
package futbol5;

import inscripcion.Inscripcion;
import excepciones.EquiposConfirmadosException;
import excepciones.PropuestaDeJugadorNoAmigoException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Jugador {
	private int edad;
	//private int cantidadInfracPorFaltar;
	private int handicap;
	private int cantidadInfracPorNoTenerSustituto;
	private Collection<Jugador> amigos = new ArrayList<Jugador>();
	private PriorityQueue<Calificacion> calificaciones = (new PriorityQueue<>(Comparator.
			comparing(calific -> calific.getPartido().getFecha() )));
	
	public Jugador(int edad) {
		this.edad= edad;
		//Administrador.agregarJugador(this);
	}	
	
	public Collection<Jugador> getAmigos(){
		return amigos;
	}

	public PriorityQueue<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public void agregarAmigo(Jugador jugador){
		amigos.add(jugador);	
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	
	public void incrementarcantidadInfracPorNoTenerSustituto(){
		cantidadInfracPorNoTenerSustituto++;
	}
	
	public int getCantidadInfracPorNoTenerSustituto(){
		return cantidadInfracPorNoTenerSustituto;
	}
	
	public void proponer(Inscripcion inscripcion,Partido partido){
		if(!amigos.contains(inscripcion.getJugador()) )
			throw new PropuestaDeJugadorNoAmigoException("no se puede proponer a un jugador que no es amigo");
		Administrador.agregarInscripcionPropuesta(inscripcion,partido);
	}
	
	public void calificarA(Jugador jugador, Partido partido, String comentario, int nota){
		jugador.agregarCalificacion(this,partido,comentario,nota);
	}
	
	public void agregarCalificacion(Jugador calificador, Partido partido, String comentario, int nota){
		if(partido.getEquiposConfirmados())
			throw new EquiposConfirmadosException("El admin no confirmo los equipos, por lo tanto, el partido no se jugo y no se pueden hacer evaluaciones");
		Calificacion calificacion= new Calificacion(calificador,partido,comentario,nota);
		calificaciones.add(calificacion);
	}
	
}

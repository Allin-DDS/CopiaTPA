package futbol5;

import inscripcion.Inscripcion;
import excepciones.EquiposConfirmadosException;
import excepciones.PropuestaDeJugadorNoAmigoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Stream;


public class Jugador {
	private int edad;
	private LocalDate fechaDeNacimiento;
	private int cantidadPartidosJugados;
	//private int cantidadInfracPorFaltar;
	private int handicap;
	private int cantidadInfracPorNoTenerSustituto;
	private Collection<Jugador> amigos = new ArrayList<Jugador>();
	public PriorityQueue<Calificacion> calificaciones = (new PriorityQueue<>(Comparator.
			comparing(calific -> calific.getPartido().getFecha() )));
	//Arrays.asList(new Calificacion(), new Calificacion().stream().sorted(Comparator.comparing(Calificacion::getFecha()).reversed());
	public Jugador(int edad) {
		this.edad= edad;
		//Administrador.agregarJugador(this);
	}	
	
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Collection<Jugador> getAmigos(){
		return amigos;
	}

	public LinkedList<Calificacion> getCalificaciones(){
		return invertirColeccion(calificaciones);
	}

	private LinkedList<Calificacion> invertirColeccion(PriorityQueue<Calificacion> calificaciones) {
		LinkedList<Calificacion> copiaCalific = new LinkedList<>();//para no modificar la colecc original
		LinkedList<Calificacion> calificacionesInvertidas= new LinkedList<>();
		copiaCalific.addAll(calificaciones);		
		int i;
		for(i=0;i<calificaciones.size();i++){
			calificacionesInvertidas.add(copiaCalific.pollLast());
		}
		return calificacionesInvertidas;
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
	
	public void aumentarCantidadPartidosJugados() {
		cantidadPartidosJugados= cantidadPartidosJugados+1;
	}
	
	public int getCantidadPartidosJugados(){
		return cantidadPartidosJugados;
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
		if(!partido.getEquiposConfirmados())
			throw new EquiposConfirmadosException("El admin no confirmo los equipos, por lo tanto, el partido no se jugo y no se pueden hacer evaluaciones");
		Calificacion calificacion= new Calificacion(calificador,partido,comentario,nota);
		calificaciones.add(calificacion);
	}
	
	public double promedioDeCalificaciones(Stream<Calificacion> calificaciones){
		return calificaciones.mapToDouble(calific-> calific.getNota()).average().getAsDouble();
	}
	
	public double promedioDeUltimoPartido(){
		Partido ultimoPartido= this.obtenerUltimoPartido();
		return this.promedioDeCalificaciones(this.getCalificaciones().stream().filter
				(calificacion->calificacion.getPartido().equals(ultimoPartido)));
			
	}

	public Partido obtenerUltimoPartido() {
		return this.getCalificaciones().peek().getPartido();
	}
	
	public double promedioDeTodosLosPartido(){
		return this.promedioDeCalificaciones(this.getCalificaciones().stream());
	}
	
}

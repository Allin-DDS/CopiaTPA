package futbol5;

import inscripcion.Inscripcion;
import excepciones.EquiposConfirmadosException;
import excepciones.PropuestaDeJugadorNoAmigoException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;
@Transactional
@Observable

public class Jugador {
	private String nombre;
	private String apodo;
	private int edad;
	private Date fechaDeNacimiento;
	private int cantidadPartidosJugados = 0;
	private int handicap;
	private int cantidadInfracPorNoTenerSustituto;
	private double promedioDeUltimoPartido;
	private boolean handicapCriterio;
	private int infraccionesCriterio;
	private boolean promedioCriterio;


	private Collection<Infraccion> infracciones = new ArrayList<Infraccion>();
	private Collection<Jugador> amigos = new ArrayList<Jugador>();
	private PriorityQueue<Calificacion> calificaciones = (new PriorityQueue<>(Comparator.
			comparing(calific -> calific.getPartido().getFecha() )));
	//Arrays.asList(new Calificacion(), new Calificacion().stream().sorted(Comparator.comparing(Calificacion::getFecha()).reversed());
	
	public Jugador(int edad) {
		this.edad= edad;
		//Administrador.agregarJugador(this);
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

	public void setPromedioDeUltimoPartido(double promedioDeUltimoPartido) {
		this.promedioDeUltimoPartido = promedioDeUltimoPartido;
	}

	public double getPromedioDeUltimoPartido(){
		Partido ultimoPartido= obtenerUltimoPartido();
		return calificaciones.stream().filter(calificacion->calificacion.getPartido()==ultimoPartido).mapToDouble(calific-> calific.nota).average().getAsDouble();
	}

	public Partido obtenerUltimoPartido() {
		Calificacion ultima = new Calificacion(null, null, null, 0);
		for(Calificacion calificacion: calificaciones){
			ultima= calificacion;
		}
		return ultima.getPartido();
	}
	
	public double getPromedioDeTodosLosPartido(){
		double promedio = 0;
		if(this.cantidadPartidosJugados != 0){
			promedio = calificaciones.stream().mapToDouble(calific-> calific.nota).average().getAsDouble();
		}
		return promedio;
	}
	public void agregarInfraccion(Partido partido, String motivo) {
		infracciones.add(new Infraccion(partido,motivo));
	
	}
	
	public String getFechaDeNacimiento() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String reportDate = df.format(this.fechaDeNacimiento);

		return reportDate;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public String getApodo() {
		return apodo;
	}
	
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public int getEdad() {
		return edad;
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
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Collection<Infraccion> getInfracciones() {
		return infracciones;
	}
	public void setInfracciones(Collection<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}
	public void setAmigos(Collection<Jugador> amigos) {
		this.amigos = amigos;
	}

	/**
	 * @return the handicapCriterio
	 */
	public boolean isHandicapCriterio() {
		return handicapCriterio;
	}

	/**
	 * @param handicapCriterio the handicapCriterio to set
	 */
	public void setHandicapCriterio(boolean handicapCriterio) {
		this.handicapCriterio = handicapCriterio;
	}

	/**
	 * @return the promedioCriterio
	 */
	public boolean isPromedioCriterio() {
		return promedioCriterio;
	}

	/**
	 * @param promedioCriterio the promedioCriterio to set
	 */
	public void setPromedioCriterio(boolean promedioCriterio) {
		this.promedioCriterio = promedioCriterio;
	}

	/**
	 * @return the infraccionesCriterio
	 */
	public int getInfraccionesCriterio() {
		return infraccionesCriterio;
	}

	/**
	 * @param infraccionesCriterio the infraccionesCriterio to set
	 */
	public void setInfraccionesCriterio(int infraccionesCriterio) {
		this.infraccionesCriterio = infraccionesCriterio;
	}

	public Date getFechaDeNacimientoDate(){
		return this.fechaDeNacimiento;
	}
}

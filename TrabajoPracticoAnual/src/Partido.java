import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import excepciones.Hay10EstandarException;

public class Partido {
	
	LocalTime horario;
	LocalDate fecha;
	String lugar;
	int cantidadInscriptosEstandar=0;
	Collection<Observador> observadores = new ArrayList<Observador>();
	Collection<Inscripcion> posibles10 = new ArrayList<Inscripcion>();
	Queue<InscripcionCondicional> colaInscripcionesCondicionales = new LinkedList<InscripcionCondicional>();
	Stack<InscripcionSolidaria> pilaInscripcionesSolidarias = new Stack <InscripcionSolidaria>();
	
	public Partido(LocalDate dia, LocalTime hora,String lugar) {
		this.fecha= dia;
		this.horario= hora;
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
	
	public int getCantidadInscriptosEstandar() {
		return cantidadInscriptosEstandar;
	}

	public void setCantidadInscriptosEstandar(int cantidadInscriptosEstandar) {
		this.cantidadInscriptosEstandar = cantidadInscriptosEstandar;
	}
	
	public Collection<Observador> getObservadores() {
		return observadores;
	}

	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public int cantidadTotalinscriptos(){
		return this.cantidadInscriptosPosibles10() + this.cantidadInscriptosCondicionales() + this.cantidadInscriptosSolidarios();  
	}
	
	public int cantidadInscriptosCondicionales() {
		return colaInscripcionesCondicionales.size();
	}
	
	public int cantidadInscriptosSolidarios() {
		return pilaInscripcionesSolidarias.size();
	}
	
	public int cantidadInscriptosPosibles10() {
		return posibles10.size();
	}
	
	public void completarPosibles10(){//Estaban solo los estandar, si son menos de 10, completa en lo posible en condicionales y solidarios
		
		while(cantidadInscriptosPosibles10()<10 && hayJugadoresCondicionalesInscriptos()){
			agregarInscripcionesCondicionales();
		}
		
		while(cantidadInscriptosPosibles10()<10 && hayJugadoresSolidariosInscriptos()){	
			agregarinscripcionSolidaria();
		}
	}
	
	public boolean hayJugadoresCondicionalesInscriptos(){
		return !(this.colaInscripcionesCondicionales.isEmpty());
	}
	
	public boolean hayJugadoresSolidariosInscriptos(){
		return !(this.pilaInscripcionesSolidarias.isEmpty());
	}
	
	private void agregarInscripcionesCondicionales() {
		InscripcionCondicional inscripcionCondicional = (this.colaInscripcionesCondicionales.element());
		posibles10.add(inscripcionCondicional);
		this.colaInscripcionesCondicionales.remove();	
	}
	
	private void agregarinscripcionSolidaria() {
		InscripcionSolidaria inscripcionSolidaria = this.pilaInscripcionesSolidarias.peek();
		posibles10.add(inscripcionSolidaria);
		this.pilaInscripcionesSolidarias.pop();		
	}
	
	public void agregarInscripcion(InscripcionEstandar inscripcion) {
		if(cantidadInscriptosEstandar<10){
			posibles10.add(inscripcion);
			cantidadInscriptosEstandar ++;
			 for (Observador observador : observadores)  
				 observador.notificarNuevaInscripcion(inscripcion.jugador,this);
		}
		else
		{
			throw new Hay10EstandarException("No se puede realizar la inscripcion porque ya hay 10 inscriptos en modo estandar para el partido");
		}
		
	}
	
	public void agregarInscripcion(InscripcionCondicional inscripcion) {
		if(cantidadInscriptosEstandar<10 && inscripcion.getCondicion().condicionDelJugador()){
			colaInscripcionesCondicionales.add(inscripcion);
			for (Observador observador : observadores)  
				 observador.notificarNuevaInscripcion(inscripcion.jugador,this);
		}
		else
		{
			throw new Hay10EstandarException("No se puede realizar la inscripcion porque ya hay 10 inscriptos en modo estandar para el partido");
		}
		
	}

	public void agregarInscripcion(InscripcionSolidaria inscripcion) {
			if(cantidadInscriptosEstandar<10){
			pilaInscripcionesSolidarias.add(inscripcion);
			for (Observador observador : observadores)  
				 observador.notificarNuevaInscripcion(inscripcion.jugador,this);
		}
		else
		{
			throw new Hay10EstandarException("No se puede realizar la inscripcion porque ya hay 10 inscriptos en modo estandar para el partido");
		}	
	}

	public void reemplazarInscripcion(InscripcionEstandar inscripcionBaja, InscripcionEstandar inscripcionAlta){
		posibles10.remove(inscripcionBaja);
		if(inscripcionAlta!= null){
			this.agregarInscripcion(inscripcionAlta);
		}
		else{
			cantidadInscriptosEstandar --;
			inscripcionBaja.jugador.incrementarcantidadInfracPorNoTenerSustituto();
			for (Observador observador : observadores)  
				observador.notificarBajaDeInscSinReemplazo(this);
		}
	}
	
	public void reemplazarInscripcion(InscripcionCondicional inscripcionBaja, InscripcionEstandar inscripcionAlta){
		colaInscripcionesCondicionales.remove(inscripcionBaja);
		if(inscripcionAlta!= null){
			this.agregarInscripcion(inscripcionAlta);
		}
		else{
			inscripcionBaja.jugador.incrementarcantidadInfracPorNoTenerSustituto();
			for (Observador observador : observadores)  
				observador.notificarBajaDeInscSinReemplazo(this);
		}
	}
	
	
	public void reemplazarInscripcion(InscripcionSolidaria inscripcionBaja, InscripcionSolidaria inscripcionAlta){
		pilaInscripcionesSolidarias.remove(inscripcionBaja);
		if(inscripcionAlta!= null){
			this.agregarInscripcion(inscripcionAlta);
		}
		else{
			inscripcionBaja.jugador.incrementarcantidadInfracPorNoTenerSustituto();
			for (Observador observador : observadores)  
				observador.notificarBajaDeInscSinReemplazo(this);
		}
	}

}


package clases;
import java.util.ArrayList;
import java.util.Collection;

import excepciones.PropuestaDeJugadorNoAmigoException;

public class Jugador {
	private int edad;
	//private int cantidadInfracPorFaltar;
	private int cantidadInfracPorNoTenerSustituto;
	private Collection<Jugador> amigos = new ArrayList<Jugador>();
	
	public Collection<Jugador> mostrar(){
		return amigos;
	}

	public void agregar(Jugador jugador){
		amigos.add(jugador);	
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void incrementarcantidadInfracPorNoTenerSustituto(){
		cantidadInfracPorNoTenerSustituto++;
	}
	
	public int getCantidadInfracPorNoTenerSustituto(){
		return cantidadInfracPorNoTenerSustituto;
	}
	
	public void proponer(Inscripcion inscripcion,Partido partido){
		if(amigos.contains(inscripcion.getJugador()) ){
			partido.agregarInscripcionPropuesta(inscripcion);
		}
		else{
			throw new PropuestaDeJugadorNoAmigoException("no se puede proponer a un jugador que no es amigo");
		}
	}
	
}

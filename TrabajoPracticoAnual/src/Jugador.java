import java.util.ArrayList;
import java.util.Collection;

public class Jugador {
	int edad;
	int cantidadInfracPorFaltar;
	int cantidadInfracPorNoTenerSustituto;
	Collection<Jugador> amigos = new ArrayList<Jugador>();
	
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
}

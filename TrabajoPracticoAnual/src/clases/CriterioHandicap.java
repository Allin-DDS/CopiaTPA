package clases;



public class CriterioHandicap implements Criterio {

	public double obtenerPromedio(Jugador jugador) {
		return jugador.getHandicap();
	}

}

package clases;

public class CriterioHandicap implements CriterioDeOrden {

	public double obtenerPromedio(Jugador jugador) {
		return jugador.getHandicap();
	}
}

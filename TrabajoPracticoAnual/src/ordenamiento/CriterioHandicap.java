package ordenamiento;

import futbol5.Jugador;

public class CriterioHandicap implements CriterioDeOrden {

	public double obtenerPromedio(Jugador jugador) {
		return jugador.getHandicap();
	}
}

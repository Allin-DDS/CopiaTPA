package ordenamiento;

import java.util.stream.DoubleStream;

import futbol5.Jugador;

public abstract class CriterioDeOrden {
	public double obtenerPromedio(Jugador jugador){
		return this.notas(jugador).average().getAsDouble();
	}

	public abstract DoubleStream notas(Jugador jugador);
}

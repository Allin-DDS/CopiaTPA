package ordenamiento;

import java.util.stream.DoubleStream;

import futbol5.Jugador;

public class CriterioHandicap extends CriterioDeOrden {

	public DoubleStream notas(Jugador jugador) {
		return DoubleStream.builder().add(jugador.getHandicap()).build();
	}
	public String getNombre(){
		return "Hándícap";
	}
}

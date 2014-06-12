package clases;

import java.util.stream.Stream;

public class CriterioCalificacionesUltimoPartido implements CriterioDeOrden {

	public Partido ultimoPartido;
	
	public double obtenerPromedio(Jugador jugador){
		ultimoPartido= jugador.getCalificaciones().peek().getPartido();
		return this.obtenerCalificacionesUltimoPartido(jugador).mapToInt(calif -> calif.getNota()).average().getAsDouble();
	}
	
	public Stream<Calificacion> obtenerCalificacionesUltimoPartido(Jugador jugador){ 
		return jugador.getCalificaciones().stream().filter(calificacion -> calificacion.esDelPartido(ultimoPartido));
	}
	
}

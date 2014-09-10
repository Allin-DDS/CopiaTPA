package ordenamiento;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import futbol5.Calificacion;
import futbol5.Jugador;
import futbol5.Partido;

public class CriterioCalificacionesUltimoPartido extends CriterioDeOrden {
	
	public String getNombre(){
		return "Promedio de notas del �ltimo partido";
		}

	public DoubleStream notas(Jugador jugador) {
		Partido ultimoPartido= jugador.getCalificaciones().peek().getPartido();
		return this.obtenerCalificacionesUltimoPartido(jugador,ultimoPartido).
					mapToDouble(calif -> calif.getNota());
		
	}
	
	public Stream<Calificacion> obtenerCalificacionesUltimoPartido(Jugador jugador, Partido ultimoPartido){
		return jugador.getCalificaciones().stream().filter(calificacion -> calificacion.esDelPartido(ultimoPartido));
	}

	
}

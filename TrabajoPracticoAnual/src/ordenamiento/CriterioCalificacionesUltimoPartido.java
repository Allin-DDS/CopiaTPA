package ordenamiento;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.uqbar.commons.utils.TransactionalAndObservable;

import futbol5.Calificacion;
import futbol5.Jugador;
import futbol5.Partido;

public class CriterioCalificacionesUltimoPartido extends CriterioDeOrden {
	
	public String getNombre(){
		return "Promedio de notas del último partido";
		}
	
	public Partido obtenerUltimoPartido(Jugador jugador) {
		Calificacion ultima = new Calificacion(null, null, null, 0);
		for(Calificacion calificacion: jugador.getCalificaciones()){
			ultima= calificacion;
		}
		return ultima.getPartido();
	}
	
	public DoubleStream notas(Jugador jugador) {
		Partido ultimoPartido= this.obtenerUltimoPartido(jugador);
		return this.obtenerCalificacionesUltimoPartido(jugador,ultimoPartido).
					mapToDouble(calif -> calif.getNota());
		
	}
	
	public Stream<Calificacion> obtenerCalificacionesUltimoPartido(Jugador jugador, Partido ultimoPartido){
		return jugador.getCalificaciones().stream().filter(calificacion -> calificacion.esDelPartido(ultimoPartido));
	}

	
}

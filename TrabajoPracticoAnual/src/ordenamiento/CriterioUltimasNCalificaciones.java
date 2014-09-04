package ordenamiento;

import java.util.stream.DoubleStream;
import futbol5.Jugador;

public class CriterioUltimasNCalificaciones extends CriterioDeOrden {
	private int cantidadCalificaciones;
	
	public CriterioUltimasNCalificaciones(int cantCalific){
		this.cantidadCalificaciones=cantCalific;
	}
	
	public int getCantidadCalificaciones() {
		return cantidadCalificaciones;
	}
	
	public void setCantidadCalificaciones(int cantidadCalificaciones) {
		this.cantidadCalificaciones = cantidadCalificaciones;
	}
	
	public DoubleStream notas(Jugador jugador) {
		return this.ultimosNCalificaciones(this.obtenerNotas(jugador));
	}
	
	private DoubleStream obtenerNotas(Jugador jugador) {
		return jugador.getCalificaciones().stream().mapToDouble(calificacion -> calificacion.getNota());
	}
	
	private DoubleStream ultimosNCalificaciones(DoubleStream doubleStream) {
		//son los primeros N pq las calificaciones estan ordenadas de la fecha más reciente a la más vieja
		return doubleStream.limit(cantidadCalificaciones);
	}
	
}
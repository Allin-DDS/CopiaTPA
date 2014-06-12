package clases;

import java.util.stream.IntStream;

public class CriterioUltimasNCalificaciones implements CriterioDeOrden {
	private int cantCalific;
	public CriterioUltimasNCalificaciones(int cantCalific){
		this.cantCalific=cantCalific;
	}
	
	public int getCantidadCalificaciones() {
		return cantCalific;
	}

	public void setCantidadCalificaciones(int cantidadCalificaciones) {
		this.cantCalific = cantidadCalificaciones;
	}
	
	public double obtenerPromedio(Jugador jugador){
		return this.promedoUltimosN(this.obtenerNotas(jugador));
	}
	
	private IntStream obtenerNotas(Jugador jugador) {
		return jugador.getCalificaciones().stream().mapToInt(calificacion -> calificacion.getNota());
	}

	private double promedoUltimosN(IntStream notas) {
		//son los primeros N pq las calificaciones estan ordenadas de la fecha más reciente a la más vieja
		return notas.limit(cantCalific).average().getAsDouble();
	}

}


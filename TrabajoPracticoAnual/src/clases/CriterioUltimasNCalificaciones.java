package clases;

import java.util.stream.IntStream;

public class CriterioUltimasNCalificaciones implements Criterio {
	private int cantCalific;
	
	public int getCantidadCalificaciones() {
		return cantCalific;
	}

	public void setCantidadCalificaciones(int cantidadCalificaciones) {
		this.cantCalific = cantidadCalificaciones;
	}
	
	public double obtenerPromedio(Jugador jugador){
		return 1;
	}
	/*LOS ESTOY DESARROLLANDO!!
	 * public double obtenerPromedio(Jugador jugador){
		this.promediaUltimosN( (jugador.getCalificaciones().stream().mapToInt(calificacion -> calificacion.getNota()) ));
	}
	
	private void promediaUltimosN(IntStream intStream) {
		return 
	}*/

}
//.average().getAsDouble();
//ArrayList<Persona> equipo1 = confirmados.stream().limit(5).collect(Collectors.toCollection(()-> new ArrayList<Persona>()));
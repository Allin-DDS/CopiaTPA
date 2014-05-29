package clases;


public class Inscripcion{
	Jugador jugador;
	int prioridad;
	
	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	//El jugador deberia conocer las calificaciones, el partido no. No me acuerdo si habia q cambiarlo si o si
	public void calificarA(Inscripcion inscripcionACalificar, Partido partido, String critica, int calificacion){
		partido.agregarCalificacion(this,inscripcionACalificar,critica,calificacion);
		
	}
}



public class InscripcionCondicional extends Inscripcion {
	private Condicion condicion;
	
	public InscripcionCondicional(Jugador jugador,Condicion condicion){
		this.jugador=jugador;
		this.condicion= condicion;
		this.prioridad=2;
	}
	
	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	
}



public class Calificacion{
	int nota;
	String comentario;
	Inscripcion calificador;
	Inscripcion calificado;
	
	public Calificacion(Inscripcion calificador,Inscripcion calificado, int nota,String comentario) {

	this.nota= nota;
	this.comentario= comentario;
	this.calificador= calificador;
	this. calificado= calificado;
	}
	
}

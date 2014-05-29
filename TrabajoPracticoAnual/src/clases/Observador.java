package clases;

public abstract class Observador {
	public abstract void notificarNuevaInscripcion(Jugador jugador, Partido partido);
	public abstract void notificarReemplazoDeInscSinSustituto(Partido partido);
	public abstract void notificarPartidoConfirmado(Partido partido);
}


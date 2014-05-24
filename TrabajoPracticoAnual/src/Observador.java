
public interface Observador {
	public void notificarNuevaInscripcion(Jugador jugador, Partido partido);
	public void notificarBajaDeInscSinReemplazo(Partido partido);
}

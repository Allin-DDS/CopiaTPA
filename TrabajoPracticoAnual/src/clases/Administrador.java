package clases;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Administrador {

	static String motivoRechazo;
	static Collection<Partido> partidos = new ArrayList<>();
	static Collection<Jugador> jugadores = new ArrayList<>();
	static Collection<InscripcionPropuesta> inscripcionesPropuestas = new ArrayList<>();
	static Collection<InscripcionRechazada> inscripcionesRechazadas= new LinkedList<>();
    static {
    	//Inicializacion del singleton
    }

    private Administrador() { }

    public Collection<InscripcionPropuesta> getInscripcionesPropuestas() {
		return inscripcionesPropuestas;
	}

	public static void agregarInscripcionPropuesta(Inscripcion inscripcion, Partido partido) {
		InscripcionPropuesta inscPropuesta= new InscripcionPropuesta(inscripcion, partido);
		inscripcionesPropuestas.add(inscPropuesta);
	}
    
	public static Collection<Partido> getPartidos() {
		return partidos;
	}

	public static void agregarPartidos(Partido partido) {
		partidos.add(partido);
	}

	public static Collection<Jugador> getJugadores() {
		return jugadores;
	}

	public static void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public static Collection<InscripcionRechazada> getInscripcionesRechazadas() {
		return inscripcionesRechazadas;
	}

	public static void agregarInscripcionRechazada(String motivo,Inscripcion inscripcion) {
		InscripcionRechazada inscRechazada= new InscripcionRechazada(motivo,LocalDate.now(),inscripcion);
		inscripcionesRechazadas.add(inscRechazada);
	}
	
	public static void aceptarInscripcionesPropuestas(InscripcionPropuesta inscripcionPropuesta){
		inscripcionPropuesta.getPartido().altaInscripcion(inscripcionPropuesta.getInscripcion());
		inscripcionesPropuestas.remove(inscripcionPropuesta);
	}
		
	public static void rechazarInscripcionesPropuestas(Inscripcion inscripcion){
		inscripcionesPropuestas.remove(inscripcion);
		agregarInscripcionRechazada(motivoRechazo,inscripcion);
	}
	
}
 
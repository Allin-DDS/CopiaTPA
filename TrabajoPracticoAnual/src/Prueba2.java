import java.time.LocalDate;
import java.time.LocalTime;


public class Prueba2 {
	public static void main(String[] args) {
		LocalDate hoy=LocalDate.now();
		LocalTime hora=LocalTime.of(22,00);
		Partido semifinal= new Partido(hoy,hora,"calleFalsa1234");
		
		Jugador juan= new Jugador();
		juan.setEdad(21);
		InscripcionEstandar inscripcionJuan= new InscripcionEstandar();
		inscripcionJuan.setJugador(juan);
		
		Jugador esteban= new Jugador();
		esteban.setEdad(21);
		InscripcionEstandar inscripcionEsteban= new InscripcionEstandar();
		inscripcionEsteban.setJugador(esteban);
		
		Jugador ramiro= new Jugador();
		ramiro.setEdad(21);
		InscripcionEstandar inscripcionramiro= new InscripcionEstandar();
		inscripcionramiro.setJugador(ramiro);
		
		Jugador mario= new Jugador();
		mario.setEdad(21);
		InscripcionEstandar inscripcionmario= new InscripcionEstandar();
		inscripcionmario.setJugador(mario);
		
		Jugador adrian= new Jugador();
		adrian.setEdad(21);
		InscripcionEstandar inscripcionadrian= new InscripcionEstandar();
		inscripcionadrian.setJugador(adrian);
		
		Jugador marcos= new Jugador();
		marcos.setEdad(21);
		InscripcionEstandar inscripcionmarcos= new InscripcionEstandar();
		inscripcionmarcos.setJugador(marcos);
		
		Jugador nose= new Jugador();
		nose.setEdad(21);
		InscripcionEstandar inscripcionnose= new InscripcionEstandar();
		inscripcionnose.setJugador(nose);
		
		Jugador turco= new Jugador();
		turco.setEdad(21);
		InscripcionEstandar inscripcionturco= new InscripcionEstandar();
		inscripcionturco.setJugador(turco);
		
		Jugador maria= new Jugador();
		maria.setEdad(22);
		InscripcionEstandar inscripcionMaria= new InscripcionEstandar();
		inscripcionMaria.setJugador(maria);
		
		Jugador gordo= new Jugador();
		gordo.setEdad(22);
		InscripcionEstandar inscripciongordo= new InscripcionEstandar();
		inscripciongordo.setJugador(gordo);
		
		Jugador jose= new Jugador();
		jose.setEdad(22);
		InscripcionEstandar inscripcionJose= new InscripcionEstandar();
		inscripcionJose.setJugador(jose);
	
		
		
		MailAAmigos mailing= new MailAAmigos(); 
		MailAAdministrador mailing2= new MailAAdministrador(); 
		semifinal.agregarObservador(mailing);
		semifinal.agregarObservador(mailing2);
		
		semifinal.agregarInscripcion(inscripcionJuan);
		semifinal.agregarInscripcion(inscripcionEsteban);
		semifinal.agregarInscripcion(inscripcionramiro);
		semifinal.agregarInscripcion(inscripcionmario);
		semifinal.agregarInscripcion(inscripcionadrian);
		semifinal.agregarInscripcion(inscripcionmarcos);
		semifinal.agregarInscripcion(inscripcionnose);
		semifinal.agregarInscripcion(inscripcionturco);
		semifinal.agregarInscripcion(inscripcionMaria);
		semifinal.agregarInscripcion(inscripciongordo);
		semifinal.agregarInscripcion(inscripcionJose);
		
		semifinal.completarPosibles10();
		int cantTot= semifinal.cantidadInscriptosPosibles10();
		
		System.out.println("cantidad total " + cantTot);
		System.out.println("cantidad de estandar " + semifinal.cantidadInscriptosEstandar);
		System.out.println("cantidad de Solidarios " + semifinal.pilaInscripcionesSolidarias.size());
		
	}
}
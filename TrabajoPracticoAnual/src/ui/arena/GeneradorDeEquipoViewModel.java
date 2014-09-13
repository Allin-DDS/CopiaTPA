package ui.arena;

import inscripcion.Inscripcion;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

import ordenamiento.CriterioCalificacionesUltimoPartido;
import ordenamiento.CriterioDeOrden;
import ordenamiento.CriterioHandicap;
import ordenamiento.MixDeCriterios;
import dividirEquipos.CriterioParaDividir2;
import dividirEquipos.CriterioParaDividirEquipos;
import dividirEquipos.CriterioParesEImpares;
import futbol5.Jugador;
import futbol5.Partido;

@Observable
public class GeneradorDeEquipoViewModel {
	

	private CriterioParaDividirEquipos criterioSeleccionado;
	private CriterioDeOrden ordenamientoSeleccionado;
	private int ultimosPartidosSeleccionados;
	private List<CriterioParaDividirEquipos> criteriosDisponibles;
	private List<CriterioDeOrden> ordenamientosDisponibles;
	private RepositorioDeJugadores partidoYjugadores;
	private List<Inscripcion> equipoNro1;
	private List<Inscripcion> equipoNro2;
	private Inscripcion inscriptoSeleccionado;
	private String nombreJugador;
	
	
	public List<Inscripcion> getEquipoNro2() {
		return equipoNro2;
	}

	public void setEquipoNro2(List<Inscripcion> equipoNro2) {
		this.equipoNro2 = equipoNro2;
	}

	public Inscripcion getInscriptoSeleccionado() {
		return inscriptoSeleccionado;
	}

	public void setInscriptoSeleccionado(Inscripcion inscriptoSeleccionado) {
		this.inscriptoSeleccionado = inscriptoSeleccionado;
	}


	

	public void init() {
		List<CriterioParaDividirEquipos> criterios = new ArrayList<CriterioParaDividirEquipos>();
		criterios.add(new CriterioParesEImpares());
		criterios.add(new CriterioParaDividir2());
		
		List<CriterioDeOrden> ordenesGenerales = new ArrayList<CriterioDeOrden>();
		ordenesGenerales.add(new CriterioHandicap());
		ordenesGenerales.add(new CriterioCalificacionesUltimoPartido());
		ordenesGenerales.add(new ordenamiento.CriterioUltimasNCalificaciones(this.ultimosPartidosSeleccionados));
		ordenesGenerales.add(new MixDeCriterios());

		this.setOrdenamientosDisponibles(ordenesGenerales);
		this.setCriteriosDisponibles(criterios);
		
		partidoYjugadores = new RepositorioDeJugadores();
		
		
	}

	public List<CriterioDeOrden> getOrdenamientosDisponibles() {
		return ordenamientosDisponibles;
	}

	public void setOrdenamientosDisponibles(List<CriterioDeOrden> ordenamientosDisponibles) {
		this.ordenamientosDisponibles = ordenamientosDisponibles;
	}

	public CriterioParaDividirEquipos getCriterioSeleccionado() {
		return criterioSeleccionado;
	}

	public void setCriterioSeleccionado(CriterioParaDividirEquipos criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
	}

	public List<CriterioParaDividirEquipos> getCriteriosDisponibles() {
		return criteriosDisponibles;
	}

	public void setCriteriosDisponibles(List<CriterioParaDividirEquipos> criteriosDisponibles) {
		this.criteriosDisponibles = criteriosDisponibles;
	}
	public int getUltimosPartidosSeleccionados() {
		return ultimosPartidosSeleccionados;
	}

	public void setUltimosPartidosSeleccionados(int ultimosPartidosSeleccionados) {
		this.ultimosPartidosSeleccionados = ultimosPartidosSeleccionados;
	}

	public CriterioDeOrden getOrdenamientoSeleccionado() {
		return ordenamientoSeleccionado;
	}

	public void setOrdenamientoSeleccionado(CriterioDeOrden ordenamientoSeleccionado) {
		this.ordenamientoSeleccionado = ordenamientoSeleccionado;
	}

	public void generarEquiposTentativos() {

		this.partidoYjugadores = new RepositorioDeJugadores();
		Partido partido = this.partidoYjugadores.getPartido();
		
		partido.setCriterioDeOrden(ordenamientoSeleccionado);
		partido.setCriterioParaDividirEquipos(criterioSeleccionado);
		partido.generarEquipos(partido.ordenarPrimeros10());
		
		 setEquipoNro1((List<Inscripcion>) partido.getEquipo1());
		 setEquipoNro2((List<Inscripcion>) partido.getEquipo2());
	}

	public List<Inscripcion> getEquipoNro1() {
		return equipoNro1;
	}

	public void setEquipoNro1(List<Inscripcion> equipoNro1) {
		this.equipoNro1 = equipoNro1;
	}

	public String getNombreJugador() {
		return this.inscriptoSeleccionado.getNombreJugador();
	}

	public void confirmarEquipos() {
		this.partidoYjugadores.getPartido().equiposConfirmados();
		//ver como devuelvo un mensaje, o como cerrarlo
		
	}

	public Jugador getJugadorSeleccionado() {
		
		return this.inscriptoSeleccionado.getJugador();
	}

	



}
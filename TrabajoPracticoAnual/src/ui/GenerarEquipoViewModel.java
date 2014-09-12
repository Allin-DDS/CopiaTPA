package ui;

import inscripcion.Inscripcion;

import java.util.ArrayList;





import java.util.Collection;
import java.util.List;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

import dividirEquipos.*;
import futbol5.Jugador;
import futbol5.Partido;
import ordenamiento.*;

@Observable
public class GenerarEquipoViewModel {
	private CriterioParaDividirEquipos criterioSeleccionado;
	private CriterioDeOrden ordenamientoSeleccionado;
	private int ultimosPartidosSeleccionados;
	private Inscripcion inscriptoSeleccionado;
	

	private Collection<Inscripcion> equipo1;
	
	public List<Inscripcion> getEquipo1() {
		List<Inscripcion> lista = new ArrayList<Inscripcion>();
		lista.addAll(equipo1);
		
		return lista;
	}

	public void setEquipo1(Collection<Inscripcion> equipo1) {
		this.equipo1 = equipo1;
	}

	
	public Collection<Inscripcion> getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Collection<Inscripcion> equipo2) {
		this.equipo2 = equipo2;
	}
	private Collection<Inscripcion> equipo2;
	private Partido partido;
	
	public int getUltimosPartidosSeleccionados() {
		return ultimosPartidosSeleccionados;
	}
	public void setUltimosPartidosSeleccionados(int ultimosPartidosSeleccionados) {
		this.ultimosPartidosSeleccionados = ultimosPartidosSeleccionados;
	}

public ArrayList<CriterioParaDividirEquipos> getCriterios(){
		ArrayList<CriterioParaDividirEquipos> criteriosGenerales = new ArrayList<CriterioParaDividirEquipos>();
		criteriosGenerales.add(new CriterioParesEImpares());
		criteriosGenerales.add(new CriterioParaDividir2());
		return criteriosGenerales;
	}
	public ArrayList<CriterioDeOrden> getOrden(){

		ArrayList<CriterioDeOrden> ordenesGenerales = new ArrayList<CriterioDeOrden>();
		ordenesGenerales.add(new CriterioHandicap());
		ordenesGenerales.add(new CriterioCalificacionesUltimoPartido());
		ordenesGenerales.add(new ordenamiento.CriterioUltimasNCalificaciones(this.ultimosPartidosSeleccionados));
		ordenesGenerales.add(new MixDeCriterios());
		return ordenesGenerales;
	}

	public CriterioParaDividirEquipos getCriterioSeleccionado() {
		return criterioSeleccionado;
	}
	public void setCriterioSeleccionado(
			CriterioParaDividirEquipos criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
	}
	public CriterioDeOrden getOrdenamientoSeleccionado() {
		return ordenamientoSeleccionado;
	}
	public void setOrdenamientoSeleccionado(CriterioDeOrden ordenamientoSeleccionado) {
		this.ordenamientoSeleccionado = ordenamientoSeleccionado;
	}
	public void generarEquipo() {
		RepositorioDeJugadores repo = new RepositorioDeJugadores();
		Partido partido = repo.generadorDePartido(ordenamientoSeleccionado,criterioSeleccionado);
		equipo1 = partido.getEquipo1();
		equipo2 = partido.getEquipo2();
		this.partido = partido;
		
	}

	public void confirmarEquipo() {
		//this.partido.EquiposConfirmados();
		//tendría que tirar error si no se armaron los equipos
	}

	public Inscripcion getInscriptoSeleccionado() {
		return inscriptoSeleccionado;
	}

	public void setInscriptoSeleccionado(Inscripcion inscriptoSeleccionado) {
		this.inscriptoSeleccionado = inscriptoSeleccionado;
	}


	

}

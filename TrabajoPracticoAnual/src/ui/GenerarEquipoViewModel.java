package ui;

import java.util.ArrayList;


import org.uqbar.commons.utils.Observable;

import dividirEquipos.*;
import ordenamiento.*;

@Observable
public class GenerarEquipoViewModel {
	private CriterioParaDividirEquipos criterioSeleccionado;
	private String ordenamientoSeleccionado;
	private int ultimosPartidosSeleccionados;
	
	public int getUltimosPartidosSeleccionados() {
		return ultimosPartidosSeleccionados;
	}
	public void setUltimosPartidosSeleccionados(int ultimosPartidosSeleccionados) {
		this.ultimosPartidosSeleccionados = ultimosPartidosSeleccionados;
	}
	public ArrayList<String> getEquipo2Tentativo() {
		 ArrayList<String> equipo2Tentativo = null;
		return equipo2Tentativo;
	}
	public ArrayList<String> getEquipo1Tentativo() {
		 ArrayList<String> equipo1Tentativo = null;
		return equipo1Tentativo;
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
	public String getOrdenamientoSeleccionado() {
		return ordenamientoSeleccionado;
	}
	public void setOrdenamientoSeleccionado(String ordenamientoSeleccionado) {
		this.ordenamientoSeleccionado = ordenamientoSeleccionado;
	}

}

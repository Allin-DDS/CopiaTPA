package ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;


@Observable
public class GenerarEquipoViewModel {
	private String criterioSeleccionado;
	private String ordenamientoSeleccionado;
	
	public ArrayList<String> getEquipo2Tentativo() {
		 ArrayList<String> equipo2Tentativo = null;
		return equipo2Tentativo;
	}
	public ArrayList<String> getEquipo1Tentativo() {
		 ArrayList<String> equipo1Tentativo = null;
		return equipo1Tentativo;
	}


	public ArrayList<String> getCriterios(){
		ArrayList<String> criteriosGenerales = new ArrayList<String>();
		criteriosGenerales.add("Par/Impar");
		criteriosGenerales.add("1,4,5,8,9");
		return criteriosGenerales;
	}
	public ArrayList<String> getOrden(){

		ArrayList<String> ordenesGenerales = new ArrayList<String>();
		ordenesGenerales.add("Por hándicap");
		ordenesGenerales.add("Por promedio de notas del último partido");
		ordenesGenerales.add("Por promedio de notas de los últimos n partidos");
		ordenesGenerales.add("Mixto");
		return ordenesGenerales;
	}
	public String getCriterioSeleccionado() {
		return criterioSeleccionado;
	}
	public void setCriterioSeleccionado(String criterioSeleccionado) {
		this.criterioSeleccionado = criterioSeleccionado;
	}
	public String getOrdenamientoSeleccionado() {
		return ordenamientoSeleccionado;
	}
	public void setOrdenamientoSeleccionado(String ordenamientoSeleccionado) {
		this.ordenamientoSeleccionado = ordenamientoSeleccionado;
	}

}

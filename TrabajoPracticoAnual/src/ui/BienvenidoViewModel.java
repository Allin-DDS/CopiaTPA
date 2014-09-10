package ui;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;


@Observable
public class BienvenidoViewModel{
	private String nombreElegido;
	private String apodoElegido;
	private int handicap;
	private int promedio;
	private int promedioCriterioSeleccionado;
	private int handicapCriterioSeleccionado;
	private int infraccionesSeleccionada;
	
	public ArrayList<String> getInfracciones(){
		ArrayList<String> criterios = new ArrayList<String>();
		criterios.add("Tuvo infacciones");
		criterios.add("No tuvo infracciones");
		criterios.add("Todos");
		return criterios;
	}
	public ArrayList<String> getPromedioCriterio(){
		ArrayList<String> criterios = new ArrayList<String>();
		criterios.add("Desde");
		criterios.add("Hasta");
		return criterios;
	}
	public String getNombreElegido() {
		return nombreElegido;
	}
	public void setNombreElegido(String nombreElegido) {
		this.nombreElegido = nombreElegido;
	}
	public String getApodoElegido() {
		return apodoElegido;
	}
	public void setApodoElegido(String apodoElegido) {
		this.apodoElegido = apodoElegido;
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	public int getPromedio() {
		return promedio;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	public int getPromedioCriterioSeleccionado() {
		return promedioCriterioSeleccionado;
	}
	public void setPromedioCriterioSeleccionado(int promedioCriterioSeleccionado) {
		this.promedioCriterioSeleccionado = promedioCriterioSeleccionado;
	}
	public int getHandicapCriterioSeleccionado() {
		return handicapCriterioSeleccionado;
	}
	public void setHandicapCriterioSeleccionado(int handicapCriterioSeleccionado) {
		this.handicapCriterioSeleccionado = handicapCriterioSeleccionado;
	}
	public int getInfraccionesSeleccionada() {
		return infraccionesSeleccionada;
	}
	public void setInfraccionesSeleccionada(int infraccionesSeleccionada) {
		this.infraccionesSeleccionada = infraccionesSeleccionada;
	}
	public void buscar() {
		// TODO Auto-generated method stub
	
	}
	
}

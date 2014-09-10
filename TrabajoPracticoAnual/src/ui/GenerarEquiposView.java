package ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import futbol5.Jugador;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader



public class GenerarEquiposView extends Window<GenerarEquipoViewModel> {

	public GenerarEquiposView(WindowOwner owner){
		super(owner, new GenerarEquipoViewModel());
		
	}
	 @Override
	  public void createContents(Panel mainPanel) {
		 //Acá van todos label, textbox, etc
		    setTitle("Generador de Equipos");
		    mainPanel.setLayout(new VerticalLayout());
		    
		    new Label(mainPanel).setText("Seleccione un criterio: ");
		    
		    RadioSelector<String> radioSelectorCriterios = new RadioSelector<>(mainPanel);
		    radioSelectorCriterios.setWidth(10);
		    radioSelectorCriterios.bindValueToProperty("criterioSeleccionado");
		    radioSelectorCriterios.bindItemsToProperty("criterios");
		    
		    
		    new Label(mainPanel).setText("Seleccione un orden: ");
		    RadioSelector<String> radioSelectorOrdenes = new RadioSelector<>(mainPanel);
		    radioSelectorOrdenes.setWidth(300);
		    radioSelectorOrdenes.bindValueToProperty("ordenamientoSeleccionado");
		    radioSelectorOrdenes.bindItemsToProperty("orden");
		   
		    
		    new Button(mainPanel)
		    .setCaption("Generar equipos");


		    new Label(mainPanel).setText("Equipo Nº1");
			

			Table<Jugador> equipo1 = new Table<Jugador>(mainPanel, Jugador.class);
		    new Column<Jugador>(equipo1) //
			.setTitle("Jugadores")
			.setFixedSize(150);
		    
			
		    
		    new Label(mainPanel).setText("Equipo Nº2");
		    
			Table<Jugador> equipo2 = new Table<Jugador>(mainPanel, Jugador.class);
		    new Column<Jugador>(equipo2) //
			.setTitle("Jugadores")
			.setFixedSize(150);
		    
			    new Button(mainPanel)
			    .setCaption("Confirmar equipo");

	 }
	 
	 

}

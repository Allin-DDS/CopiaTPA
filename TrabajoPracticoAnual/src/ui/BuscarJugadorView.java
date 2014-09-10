package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class BuscarJugadorView extends Window<BienvenidoViewModel> {

	public BuscarJugadorView(WindowOwner owner) {
		super(owner, new BienvenidoViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		 new Label(mainPanel).setText("Criterio de búsqueda");
		 
		 
		 new Label(mainPanel).setText("Nombre comienza con:");
		 new TextBox(mainPanel).bindValueToProperty("nombreElegido");
		 
		 new Label(mainPanel).setText("Apodo");
		 new TextBox(mainPanel).bindValueToProperty("apodoElegido");
		 
		 new Label(mainPanel).setText("Hándicap");
		  RadioSelector<String> radioSelectorHandicapCriterio = new RadioSelector<>(mainPanel);
		  radioSelectorHandicapCriterio.setWidth(10);
		  radioSelectorHandicapCriterio.bindValueToProperty("handicapCriterioSeleccionado");
		  radioSelectorHandicapCriterio.bindItemsToProperty("promedioCriterio");
		 new TextBox(mainPanel).bindValueToProperty("handicap");

		 new Label(mainPanel).setText("Promedio");
		  RadioSelector<String> radioSelectorPromedioCriterio = new RadioSelector<>(mainPanel);
		  radioSelectorPromedioCriterio.setWidth(10);
		  radioSelectorPromedioCriterio.bindValueToProperty("promedioCriterioSeleccionado");
		  radioSelectorPromedioCriterio.bindItemsToProperty("promedioCriterio");
		new TextBox(mainPanel).bindValueToProperty("promedio");


		 new Label(mainPanel).setText("Filtro de infracciones");
		 
		  RadioSelector<String> radioSelectorInfracciones = new RadioSelector<>(mainPanel);
		  radioSelectorInfracciones.setWidth(50);
		  radioSelectorInfracciones.bindValueToProperty("infraccionesSeleccionada");
		  
		  
		    new Button(mainPanel) //
		    .setCaption("Buscar") //
		    .onClick(() -> getModelObject().buscar());
		  radioSelectorInfracciones.bindItemsToProperty("infracciones");
	
	}
	

}

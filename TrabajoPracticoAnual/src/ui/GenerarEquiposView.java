package ui;

import ordenamiento.CriterioDeOrden;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import dividirEquipos.CriterioParaDividirEquipos;
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
		    
		    new Label(mainPanel).setText("Seleccione un criterio");
		    
		    
			Selector<CriterioParaDividirEquipos> selectorDeCriterio = new Selector<CriterioParaDividirEquipos>(mainPanel) //
					.allowNull(false);
			selectorDeCriterio.bindValueToProperty("criterioSeleccionado");
				
			Binding<ListBuilder<CriterioParaDividirEquipos>> itemsBinding = selectorDeCriterio.bindItemsToProperty("criterios");
			itemsBinding.setAdapter(new PropertyAdapter(CriterioParaDividirEquipos.class, "nombre"));


		    new Label(mainPanel).setText("Cantidad de últimos partidos");
			new TextBox(mainPanel).bindValueToProperty("ultimosPartidosSeleccionados");
			
		    new Label(mainPanel).setText("Seleccione un orden");
		    Selector<CriterioDeOrden> selectorDeOrden = new Selector<CriterioDeOrden>(mainPanel) //
					.allowNull(false);
		    selectorDeOrden.bindValueToProperty("ordenamientoSeleccionado");
		    
			Binding<ListBuilder<CriterioDeOrden>> itemsBindingDeOrden = selectorDeOrden.bindItemsToProperty("orden");
			itemsBindingDeOrden.setAdapter(new PropertyAdapter(CriterioDeOrden.class, "nombre"));

			
			
			
			
		    new Label(mainPanel).setText("Cantidad de últimos partidos");
			new TextBox(mainPanel).bindValueToProperty("ultimosPartidosSeleccionados");

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

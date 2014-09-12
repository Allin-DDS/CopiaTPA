package ui.arena;


import inscripcion.Inscripcion;
import ordenamiento.CriterioDeOrden;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import dividirEquipos.CriterioParaDividirEquipos;


public class GeneradorDeEquipoView extends SimpleWindow<GeneradorDeEquipoViewModel> {
	
	public GeneradorDeEquipoView(WindowOwner parent) {
		super(parent, new GeneradorDeEquipoViewModel());
		this.getModelObject().init();
		
	}
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Generador de Equipos");
		this.setTaskDescription("Selecione los criterios que desee");
		
		super.createMainTemplate(mainPanel);

	}
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)//
		.setCaption("Generar Equipos")
		.onClick(()-> this.getModelObject().generarEquiposTentativos());
		
		new Button(actionsPanel)//
		.setCaption("Ver datos del Jugador")
		.onClick(()-> new DatosDeJugador(this,this.getModelObject().getJugadorSeleccionado()).open());
		
		new Button(actionsPanel)//
		.setCaption("Confirmar Equipo")
		.onClick(()-> this.getModelObject().confirmarEquipos());
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel SelectorCriterioFormPanel = this.nuevoPanel(mainPanel,2);
		Panel  SelectorOrdenFormPanel = this.nuevoPanel(mainPanel,4);
	

		this.crearCriterioDeDivisionDeEquipo(SelectorCriterioFormPanel);	
		this.crearCriterioDeOrdenamiento(SelectorOrdenFormPanel);
		
		Panel equiposFormPanel = this.nuevoPanel(mainPanel,2);
	
	    new Label(equiposFormPanel).setText("Equipo Nº1");
	    new Label(equiposFormPanel).setText("Equipo Nº2");

	    this.crearGrillaDeEquipo("equipoNro1",equiposFormPanel);
	    this.crearGrillaDeEquipo("equipoNro2",equiposFormPanel);
		
	}
	private Panel nuevoPanel(Panel mainPanel, int i) {
		Panel panel = new Panel(mainPanel);
		panel.setLayout(new ColumnLayout(i));
		return panel;
	}
	public <C extends ControlBuilder> Binding<C> crearGrillaDeEquipo(String string, Panel panel) {
		
		Table<Inscripcion> table = new Table<Inscripcion>(panel, Inscripcion.class);
		table.setHeigth(100);
		table.setWidth(150);

		table.bindItemsToProperty(string);
		table.bindValueToProperty("inscriptoSeleccionado");

		new Column<Inscripcion>(table) //
		.setTitle("Jugadores del Equipo")
		.setFixedSize(150)
		.bindContentsToProperty("nombreJugador");

		
		return null;
		
		
	}
	
	
	private void crearCriterioDeOrdenamiento(Panel panel) {
		 new Label(panel).setText("Criterio de ordenamiento");
		   
			Selector<CriterioDeOrden> selectorDeOrden = new Selector<CriterioDeOrden>(panel) //
					.allowNull(false);
		    selectorDeOrden.bindValueToProperty("ordenamientoSeleccionado");

			Binding<ListBuilder<CriterioDeOrden>> itemsBindingDeOrden = selectorDeOrden.bindItemsToProperty("ordenamientosDisponibles");
			itemsBindingDeOrden.setAdapter(new PropertyAdapter(CriterioDeOrden.class, "nombre"));

			TextBox partidosAnteriores = new TextBox(panel);
			partidosAnteriores.bindValueToProperty("ultimosPartidosSeleccionados");	
			new Label(panel).setText("partidos anteriores");
			
			NotNullObservable elementSelected = new NotNullObservable("ordenamientoSeleccionado");
			partidosAnteriores.bindEnabled(elementSelected);
		
	}
	private void crearCriterioDeDivisionDeEquipo(Panel panel) {
new Label(panel).setText("Criterio de orden");
		
		Selector<CriterioParaDividirEquipos> selectorDeCriterio = new Selector<CriterioParaDividirEquipos>(panel) //
				.allowNull(false);
		selectorDeCriterio.bindValueToProperty("criterioSeleccionado");
			
		Binding<ListBuilder<CriterioParaDividirEquipos>> itemsBinding = selectorDeCriterio.bindItemsToProperty("criteriosDisponibles");
		itemsBinding.setAdapter(new PropertyAdapter(CriterioParaDividirEquipos.class, "nombre"));
		

		
	}

}

package ui;

import ordenamiento.CriterioDeOrden;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import dividirEquipos.CriterioParaDividirEquipos;
import inscripcion.Inscripcion;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader



public class GenerarEquiposView extends SimpleWindow<GenerarEquipoViewModel> {

	public GenerarEquiposView(WindowOwner owner){
		super(owner, new GenerarEquipoViewModel());
		//this.getModelObject().search();
		
	}
	
	 @Override
	  public void createMainTemplate(Panel mainPanel) {
		 //Acá van todos label, textbox, etc
		    setTitle("Generador de Equipos");
		    mainPanel.setLayout(new VerticalLayout());
		    
		    new Label(mainPanel).setText("Seleccione un criterio");
		    
		    
			Selector<CriterioParaDividirEquipos> selectorDeCriterio = new Selector<CriterioParaDividirEquipos>(mainPanel) //
					.allowNull(false);
			selectorDeCriterio.bindValueToProperty("criterioSeleccionado");
				
			Binding<ListBuilder<CriterioParaDividirEquipos>> itemsBinding = selectorDeCriterio.bindItemsToProperty("criterios");
			itemsBinding.setAdapter(new PropertyAdapter(CriterioParaDividirEquipos.class, "nombre"));



		    new Label(mainPanel).setText("Seleccione un orden");
		    Selector<CriterioDeOrden> selectorDeOrden = new Selector<CriterioDeOrden>(mainPanel) //
					.allowNull(false);
		    selectorDeOrden.bindValueToProperty("ordenamientoSeleccionado");
		    
			Binding<ListBuilder<CriterioDeOrden>> itemsBindingDeOrden = selectorDeOrden.bindItemsToProperty("orden");
			itemsBindingDeOrden.setAdapter(new PropertyAdapter(CriterioDeOrden.class, "nombre"));
			
			new Label(mainPanel).setText("Cantidad de últimos partidos");
			new TextBox(mainPanel).bindValueToProperty("ultimosPartidosSeleccionados");

			new Button(mainPanel)
		    .setCaption("Generar equipos")
		    .onClick(() -> getModelObject().generarEquipo());


		    new Label(mainPanel).setText("Equipo Nº1");
			
		    //List<Inscripcion> listEquipo1 = new List<Inscripcion>(mainPanel);   		    
		    //Binding<ListBuilder<Inscripcion>> itemsBindingDeEquipo1 = listEquipo1.bindItemsToProperty("equipo1");
			//itemsBindingDeEquipo1.setAdapter(new PropertyAdapter(Inscripcion.class, "nombreJugador"));
			//listEquipo1.bindValueToProperty("inscriptoSeleccionado");
			//listEquipo1.onSelection(() -> new DatosDeJugador(this,this.getModelObject().getInscriptoSeleccionado()).open());
					
			//Con las table no puedo bindear
			Table<Inscripcion> tablaEquipo1 = new Table<Inscripcion>(mainPanel, Inscripcion.class);
			tablaEquipo1.bindItemsToProperty("equipo1");
			tablaEquipo1.bindItemsToProperty("inscriptoSeleccionado");
			
			tablaEquipo1.setHeigth(120);
			tablaEquipo1.setWidth(50);
			
			new Column<Inscripcion>(tablaEquipo1) //
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombreJugador");


	
		    new Label(mainPanel).setText("Equipo Nº2");
		    
		    List<Inscripcion> listEquipo2 = new List<Inscripcion>(mainPanel);   		    
		    listEquipo2.bindValueToProperty("inscriptoSeleccionado");
		    Binding<ListBuilder<Inscripcion>> itemsBindingDeEquipo2 = listEquipo2.bindItemsToProperty("equipo2");
			itemsBindingDeEquipo2.setAdapter(new PropertyAdapter(Inscripcion.class, "nombreJugador"));
			listEquipo2.onSelection(new MessageSend(this, "mostrarDatosDelJugador"));
			
			
			    new Button(mainPanel)
			    .setCaption("Confirmar equipo")
			    .onClick(() -> getModelObject().confirmarEquipo());;

	 }
		protected void openDialog(Dialog<?> dialog) {
			dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
			dialog.open();
		}
		public void mostrarDatosDelJugador() {
			this.openDialog(new DatosDeJugador(this, this.getModelObject().getInscriptoSeleccionado()));
		}
		@Override
		protected void addActions(Panel actionsPanel) {
			// TODO Auto-generated method stub
			
		}
		@Override
		protected void createFormPanel(Panel mainPanel) {
			// TODO Auto-generated method stub
			
		}
	 

}

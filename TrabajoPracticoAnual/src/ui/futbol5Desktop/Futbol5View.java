package ui.futbol5Desktop;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import ui.futbol5ViewModels.Futbol5ViewModel;



public class Futbol5View extends MainWindow<Futbol5ViewModel>{ 
	
	public Futbol5View() {
		super(new Futbol5ViewModel());
}

	@Override
	public void createContents(Panel mainPanel) {
		 //Acá van todos label, textbox, etc
			setTitle("Bienvenidos");
		    mainPanel.setLayout(new VerticalLayout());
		    
		new Button(mainPanel)
		.setCaption("Buscar Jugador")
		.onClick(() -> new BuscadorDeJugadorView(this).open());

		new Button(mainPanel)//
			.setCaption("Generear Equipos")
			.onClick(() -> new GeneradorDeEquipoView(this).open());
	  }
	 public static void main(String[] args) {
		    new Futbol5View().startApplication();
		  }		

}
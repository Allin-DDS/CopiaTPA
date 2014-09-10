package ui;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

public class BienvenidoView extends MainWindow<BienvenidoViewModel>{

	  public BienvenidoView() {
		super(new BienvenidoViewModel());
	}

	public void createContents(Panel mainPanel) {
		 //Acá van todos label, textbox, etc
			setTitle("Bienvenidos");
		    mainPanel.setLayout(new VerticalLayout());
		    
		new Button(mainPanel)
		.setCaption("Buscar Jugador")
		.onClick(() -> new BuscarJugadorView(this).open());

		new Button(mainPanel)//
			.setCaption("Generear Equipos")
			.onClick(() -> new GenerarEquiposView(this).open());
	  }
	 public static void main(String[] args) {
		    new BienvenidoView().startApplication();
		  }	
}
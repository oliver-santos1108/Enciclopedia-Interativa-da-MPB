package main;

import controler.ArtistaController;
import model.ArtistaRepositorioBD;
import view.JanelaArtista;

public class Main1 {

	public static void main(String[] args) {
		
		ArtistaRepositorioBD repositorio = new ArtistaRepositorioBD();
		JanelaArtista view = new JanelaArtista();
		ArtistaController controller = new ArtistaController(repositorio, view);
		controller.iniciarTela();

	}

}

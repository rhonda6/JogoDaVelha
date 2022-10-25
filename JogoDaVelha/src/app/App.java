/**
 * 
 */
package app;

import controllers.JogoController;
import models.Jogo;
import views.TabuleiroView;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var view = new TabuleiroView();
		var jogo = new Jogo();
		var controller = new JogoController(view, jogo);
		controller.initController();

	}

}

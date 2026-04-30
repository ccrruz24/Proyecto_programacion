package application;

import controllers.AuthController;
import controllers.DishesController;
import controllers.HomeController;
import views.HomeViews;

public class Main {

	public static void main(String[] args) {
		AuthController ac = new AuthController();
		//ac.login();
		//ac.registro();
		
		
		HomeController hc = new HomeController();
		//hc.panelControl();
		
		DishesController vp = new DishesController();
		vp.platillos();

	}

}

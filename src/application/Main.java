package application;

import controllers.AuthController;
import controllers.ClientController;
import controllers.DishesController;
import controllers.HomeController;
import controllers.InventoryController;
import controllers.OrdersController;
import views.HomeViews;

public class Main {

	public static void main(String[] args) {
		AuthController ac = new AuthController();
		ac.login();
		//ac.registro();
		
		
		HomeController hc = new HomeController();
		//hc.panelControl();
		
		DishesController vp = new DishesController();
		//vp.platillos();
		
		OrdersController ov = new OrdersController();
		//ov.ordenes();
		
		ClientController cv = new ClientController();
		//cv.clientes();
		
		InventoryController iv = new InventoryController();
		//iv.inventario();

	}

}

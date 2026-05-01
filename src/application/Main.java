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
		//ac.login();
		//ac.registro();
		
		
		HomeController hc = new HomeController();
		//hc.panelControl();
		
		DishesController vp = new DishesController();
		//vp.platillos();
		//vp.agregarPlatillo();
		//vp.verPlatilloTacosalpastor();
		//vp.verPlatilloEnchilada();
		//vp.editarPlatilloTacosalpastor();
		//vp.editarPlatilloEnchilada();
		
		OrdersController ov = new OrdersController();
		//ov.ordenes();
		//ov.verOrdenesGrady();
		//ov.verOrdenesMarta();
		//ov.verOrdenesSalma();
		//ov.editarOrdenesGrady();
		//ov.editarOrdenesMarta();
		//ov.editarOrdenesSalma();
		//ov.nuevaOrden();
		
		ClientController cv = new ClientController();
		//cv.clientes();
		//cv.verClienteGrady();
		//cv.verClienteMarta();
		//cv.verClienteSalma();
		//cv.editarClienteGrady();
		//cv.editarClienteMarta();
		//cv.editarClienteSalma();
		
		InventoryController iv = new InventoryController();
		iv.inventario();
		//iv.verInventarioTortilla();
		//iv.verInventarioLimon();
		//iv.editarInventarioTortilla();
		//iv.editarInventarioLimon();

	}

}

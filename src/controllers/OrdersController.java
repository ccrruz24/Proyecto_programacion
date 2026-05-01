package controllers;

import views.OrdersView;

public class OrdersController {
	
	private OrdersView ov;
	
	public OrdersController() {

		ov = new OrdersView();
	}
	
	public void ordenes() {
		ov.ordenes();
	}
	
	public void verOrdenesGrady() {
		ov.verOrdenesGrady();
	}

	public void editarOrdenesGrady() {
		ov.editarOrdenesGrady();
	}
	
	public void verOrdenesMarta() {
		ov.verOrdenesMarta();
	}

	public void editarOrdenesMarta() {
		ov.editarOrdenesMarta();
	}
	
	public void verOrdenesSalma() {
		ov.verOrdenesSalma();
	}

	public void editarOrdenesSalma() {
		ov.editarOrdenesSalma();
	}
	
	public void nuevaOrden() {
		ov.nuevaOrden();
	}

}

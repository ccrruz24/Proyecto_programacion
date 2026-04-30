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
}

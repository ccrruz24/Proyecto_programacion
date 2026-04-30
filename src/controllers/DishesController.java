package controllers;

import views.DishesView;

public class DishesController {
	
	private DishesView vp;

	public DishesController() {

		vp = new DishesView();
	}
	
	public void platillos() {
		vp.platillos();
	}
}

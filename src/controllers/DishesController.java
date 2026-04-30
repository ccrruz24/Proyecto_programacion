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
	
	public void agregarPlatillo() {
		vp.agregarPlatillo();
	}
	
	public void verPlatilloTacosalpastor() {
		vp.verPlatilloTacos();
	}
	
	public void editarPlatilloTacosalpastor() {
		vp.editarPlatilloTacos();
	}
	
	public void verPlatilloEnchilada() {
		vp.verPlatilloEnchilada();
	}
	
	public void editarPlatilloEnchilada() {
		vp.editarPlatilloEnchilada();
	}
	
	
}

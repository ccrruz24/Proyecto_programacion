package controllers;

import views.InventoryView;

public class InventoryController {
	private InventoryView iv;

public InventoryController() {
		
		iv = new InventoryView();
	}

	public void inventario() {
		iv.inventario();
	}
	
	public void verInventarioTortilla() {
		iv.verInventarioTortilla();
	}
	
	public void editarInventarioTortilla() {
		iv.editarInventarioTortilla();
	}
	
	public void verInventarioLimon() {
		iv.verInventarioLimon();
	}
	
	public void editarInventarioLimon() {
		iv.editarInventarioLimon();
	}
	
	public void agregarIngrediente() {
		iv.agregarIngrediente();
	}

}
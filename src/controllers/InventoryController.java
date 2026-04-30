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
}

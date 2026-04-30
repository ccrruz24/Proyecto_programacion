package controllers;

import views.ClientsViews;

public class ClientController {
	
	private ClientsViews cv;
	
	public ClientController() {
		
		cv = new ClientsViews();
	}
	
	public void clientes() {
		cv.clientes();
	}

}

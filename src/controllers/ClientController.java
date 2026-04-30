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
	
	public void verClienteGrady() {
		cv.verClienteGrady();
	}

	public void editarClienteGrady() {
		cv.editarClienteGrady();
	}

	public void verClienteMarta() {
		cv.verClienteMarta();
	}

	public void editarClienteMarta() {
		cv.editarClienteMarta();
	}

	public void verClienteSalma() {
		cv.verClienteSalma();
	}

	public void editarClienteSalma() {
		cv.editarClienteSalma();
	}	
	
	public void agregarCliente() {
		cv.agregarCliente();
	}

}

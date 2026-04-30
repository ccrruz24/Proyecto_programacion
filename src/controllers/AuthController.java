package controllers;

import views.AuthViews;

public class AuthController {

	private AuthViews vista;

	public AuthController() {

		vista = new AuthViews();
	}

	public void login() {
		vista.inicioSesion();
		
	}
	
	public void registro() {
		vista.registro();
		
	}
	
	
	
}

package controllers;

import java.util.ArrayList;
import models.ClientsModel;
import models.AuthModel; // Importamos el modelo de datos
import views.ClientsViews;

public class ClientController {
    private ClientsViews vista;
    private AuthModel modeloDB;

    public ClientController(ClientsViews vista) {
        this.vista = vista;
        this.modeloDB = new AuthModel();
    }

    public void iniciar() {
        // Traemos datos reales de la base de datos
        ArrayList<ClientsModel> lista = modeloDB.obtenerClientes();
        vista.clientes(lista, this);
    }

    public void verDetalles(ClientsModel c) {
        vista.verDetallesGenerico(c, this);
    }

    public void editar(ClientsModel c) {
        vista.editarGenerico(c, this);
    }
    
    public void eliminar(int id) {
        System.out.println("Eliminando cliente ID: " + id);
        // Aquí llamarías a un método modeloDB.borrarCliente(id);
    }
}
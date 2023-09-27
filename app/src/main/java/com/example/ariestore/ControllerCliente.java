package com.example.ariestore;

import com.example.ariestore.models.Cliente;

import java.util.ArrayList;

public class ControllerCliente {

    private static ControllerCliente instancia;
    private static ArrayList<Cliente> ListaCliente;

    //só vai ter uma instancia da classe global
    public static ControllerCliente getInstance(){
        if(instancia == null){
            return instancia = new ControllerCliente();
        } else{
            return instancia;
        }
    }

    private ControllerCliente(){
        ListaCliente = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente){
        ListaCliente.add(cliente);
    }

    public ArrayList<Cliente> retornarClientes() {
        return ListaCliente;
    }


}

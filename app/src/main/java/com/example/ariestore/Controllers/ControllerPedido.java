package com.example.ariestore.Controllers;

import com.example.ariestore.models.Pedido;

import java.util.ArrayList;

public class ControllerPedido {

    private static ControllerPedido instancia;
    private static ArrayList<Pedido> ListaPedido;

    public static ControllerPedido getInstance(){
        if (instancia == null){
            return instancia = new ControllerPedido();
        }else{
            return instancia;
        }
    }

    private ControllerPedido(){ListaPedido = new ArrayList<>();}
    public void salvaPedido(Pedido pedido){ListaPedido.add(pedido);}
    public ArrayList<Pedido> retornarPedido(){return ListaPedido;}

}

package com.example.ariestore;

import com.example.ariestore.models.Item;

import java.util.ArrayList;

public class ControllerItem {

    private static ControllerItem instancia;
    private static ArrayList<Item> ListaItem;

    //só vai ter uma instancia da classe global
    public static ControllerItem getInstance(){
        if (instancia == null){
            return instancia = new ControllerItem();
        }else{
            return instancia;
        }
    }

    private ControllerItem(){ListaItem = new ArrayList<>();}
    public void salvarItem(Item item){ListaItem.add(item);}
    public ArrayList<Item> retornarItem(){return ListaItem;}
}

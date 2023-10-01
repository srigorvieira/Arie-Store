package com.example.ariestore.models;

public class Pedido {

    private Item item;
    private Cliente cliente;
    private int qtdItem;
    private double vlrTotal;
    private boolean noDinheiro;
    private int qtdParcelas;

    public Pedido(){}

    public Pedido(Item item, Cliente cliente, int qtdItem, double vlrTotal, boolean noDinheiro, int qtdParcelas) {
        this.item = item;
        this.cliente = cliente;
        this.qtdItem = qtdItem;
        this.vlrTotal = vlrTotal;
        this.noDinheiro = noDinheiro;
        this.qtdParcelas = qtdParcelas;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public boolean isNoDinheiro() {
        return noDinheiro;
    }

    public void setNoDinheiro(boolean noDinheiro) {
        this.noDinheiro = noDinheiro;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "item=" + item +
                ", cliente=" + cliente +
                ", qtdItem=" + qtdItem +
                ", vlrTotal=" + vlrTotal +
                ", noDinheiro=" + noDinheiro +
                ", qtdParcelas=" + qtdParcelas +
                '}';
    }
}

package com.example.ariestore.models;

public class Item {

    public static int getVlrItem;
    private int codItem;
    private String descItem;
    private double vlrItem;

    public Item (){}

    public Item (int codItem, String descItem, double vlrItem){
        this.codItem = codItem;
        this.descItem = descItem;
        this.vlrItem = vlrItem;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public double getVlrItem() {
        return vlrItem;
    }

    public void setVlrItem(double vlrItem) {
        this.vlrItem = vlrItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codItem=" + codItem +
                ", descItem='" + descItem + '\'' +
                ", vlrItem=" + vlrItem +
                '}';
    }
}

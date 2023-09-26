package com.example.ariestore.models;

public class FormaPagto {

    private String aPrazo;
    private String aVista;

    public FormaPagto(){}

    public FormaPagto(String aPrazo, String aVista){
        this.aPrazo = aPrazo;
        this.aVista = aVista;
    }

    public String getaPrazo() {
        return aPrazo;
    }

    public void setaPrazo(String aPrazo) {
        this.aPrazo = aPrazo;
    }

    public String getaVista() {
        return aVista;
    }

    public void setaVista(String aVista) {
        this.aVista = aVista;
    }

    @Override
    public String toString() {
        return "FormaPagto{" +
                "aPrazo='" + aPrazo + '\'' +
                ", aVista='" + aVista + '\'' +
                '}';
    }
}

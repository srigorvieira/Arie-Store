package com.example.ariestore.models;

public class Cliente {

    private String nmCliente;
    private String cpfCliente;

    public Cliente(){}

    public Cliente(String nmCliente, String cpfCliente){
        this.nmCliente = nmCliente;
        this.cpfCliente = cpfCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nmCliente='" + nmCliente + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                '}';
    }
}

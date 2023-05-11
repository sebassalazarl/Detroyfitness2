package com.example.detroyfitness2;

public class Tecnica {
    private String nombre;
    private String url;


    public Tecnica() {}

    public Tecnica(String nombre, String url) {
        this.url = url;
        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }
    public String getUrl() {

        return url;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
}
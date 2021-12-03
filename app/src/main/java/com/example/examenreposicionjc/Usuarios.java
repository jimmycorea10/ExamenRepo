package com.example.examenreposicionjc;

import java.io.Serializable;

public class Usuarios implements Serializable {


    private String name1;
    private  String telefono;
    private  String longitud;
    private  String latitud;
    private String url;
    private  String key;


    public Usuarios(String name1, String telefono, String longitud, String latitud, String url, String key) {
        this.name1 = name1;
        this.telefono = telefono;
        this.longitud = longitud;
        this.latitud = latitud;
        this.url = url;
        this.key = key;
    }

    public Usuarios() {
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

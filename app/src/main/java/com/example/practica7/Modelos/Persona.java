package com.example.practica7.Modelos;

public class Persona {
    private String nombre;
    private String Telefono;

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        Telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}

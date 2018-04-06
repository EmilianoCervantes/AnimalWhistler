package com.example.emilianocervantes.animalwhistler2.Models;

/**
 * Created by Alfredo on 06/04/2018.
 */

public class MascotaPerdidaPojo {
    private String nombre, tipo, raza, color, lugar, descripcion;

    public MascotaPerdidaPojo() {
    }

    public MascotaPerdidaPojo(String nombre, String tipo, String raza, String color, String lugar, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.color = color;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

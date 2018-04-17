package com.example.emilianocervantes.animalwhistler2.Models;

/**
 * Created by Alfredo on 17/04/2018.
 */

public class ChatbotPojo {
    private String name, message;
    private int tipo;

    public ChatbotPojo(){
    }

    public ChatbotPojo(String name, String message, int tipo) {
        this.name = name;
        this.message = message;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

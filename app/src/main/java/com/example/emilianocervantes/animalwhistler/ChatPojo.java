package com.example.emilianocervantes.animalwhistler;

/**
 * Created by ovman on 09/03/2018.
 */

public class ChatPojo {
    private String name, imageUrl, message;

    public ChatPojo() {
    }

    public ChatPojo(String name, String inageUrl, String message) {
        this.name = name;
        this.imageUrl = inageUrl;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

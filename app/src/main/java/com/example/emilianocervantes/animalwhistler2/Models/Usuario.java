package com.example.emilianocervantes.animalwhistler2.Models;

/**
 * Created by Alfredo on 19/03/2018.
 */

public class Usuario {
    public String user, email, photUrl, Uid;

    public Usuario() {
    }

    public Usuario(String user) {
        this.user = user;
    }

    public Usuario(String user, String email, String photUrl, String uid) {
        this.user = user;
        this.email = email;
        this.photUrl = photUrl;
        Uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotUrl() {
        return photUrl;
    }

    public void setPhotUrl(String photUrl) {
        this.photUrl = photUrl;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

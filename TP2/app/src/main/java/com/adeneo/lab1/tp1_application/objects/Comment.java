package com.adeneo.lab1.tp1_application.objects;

public class Comment {

    private String pseudo;
    private String message;
    private String avatar;

    public Comment(String pseudo, String message, String avatar){
        this.pseudo = pseudo;
        this.message = message;
        this.avatar = avatar;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMessage() {
        return message;
    }

    public String getAvatar() {
        return avatar;
    }
}

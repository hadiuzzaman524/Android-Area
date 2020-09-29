package com.nested.messenger;

public class User {
    String username;
    String imageurl;
    String id;

    public User(String username, String imageurl, String id) {
        this.username = username;
        this.imageurl = imageurl;
        this.id = id;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

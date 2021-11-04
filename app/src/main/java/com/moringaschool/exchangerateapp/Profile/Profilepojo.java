package com.moringaschool.exchangerateapp.Profile;

public class Profilepojo {
    String email, phone, bio, username;

    public Profilepojo(String email, String phone, String bio, String username) {
        this.email = email;
        this.phone = phone;
        this.bio = bio;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

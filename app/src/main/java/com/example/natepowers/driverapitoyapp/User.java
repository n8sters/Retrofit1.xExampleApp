package com.example.natepowers.driverapitoyapp;

/**
 * Created by:
 * ~~~~~~_  __     __        ____      ______
 * ~~~~~/ |/ ___ _/ /____   / __/___  /_  _____  ___ __ __
 * ~~~~/    / _ `/ __/ -_)  > _/_ _/   / / / _ \/ _ / // /
 * ~~~/_/|_/\_,_/\__/\__/  |_____/    /_/  \___/_//_\_, /
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/___/
 * ~~~~~~~~~~~~~~~~~~~  at Copia PBC   ~~~~~~~~~~~~~~~~~~~~~~
 */


public class User {

    private String phone;
    private String confirmId;
    private String UUID;
    String success;
    String type;

    User() {

    }

    public String getSuccess() {
        return success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public User(String phone) {
        this.phone = phone;
    }

    public User(String UUID, String confirmId, String phone) {
        this.UUID = UUID;
        this.confirmId = confirmId;
        this.phone = phone;
    }


    public String getPhone() {
        return phone;
    }

    public String getAccessCode() {
        return confirmId;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccessCode(String accessCode) {
        this.confirmId = accessCode;
    }


}
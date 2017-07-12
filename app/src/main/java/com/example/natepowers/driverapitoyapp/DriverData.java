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


public class DriverData {

    boolean sandbox;
    int type;
    int status;
    static String firstName;
    String lastName;
    String nickName;
    int dobYear;
    int dobMonth;

    // address
    String street;
    String street2;
    String city;
    String postal;
    String country;


    String email;
    boolean emailVerified;
    String phone;

    // Availability
    int monday;
    int tuesday;
    int wednesday;
    int thursday;
    int friday;
    int saturday;
    int sunday;

    public DriverData(boolean sandbox, int type, int status, String lastName, String nickName,
                      int dobYear, int dobMonth, String street, String street2, String city,
                      String postal, String country, String email, boolean emailVerified,
                      String phone, int monday, int tuesday, int wednesday, int thursday,
                      int friday, int saturday, int sunday) {
        this.sandbox = sandbox;
        this.type = type;
        this.status = status;
        this.lastName = lastName;
        this.nickName = nickName;
        this.dobYear = dobYear;
        this.dobMonth = dobMonth;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.postal = postal;
        this.country = country;
        this.email = email;
        this.emailVerified = emailVerified;
        this.phone = phone;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public boolean isSandbox() {
        return sandbox;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public static String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public int getDobYear() {
        return dobYear;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getPostal() {
        return postal;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getPhone() {
        return phone;
    }

    public int getMonday() {
        return monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public int getFriday() {
        return friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static void setFirstName(String firstName) {
        DriverData.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }
}


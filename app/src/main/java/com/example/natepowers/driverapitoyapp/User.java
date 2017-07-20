package com.example.natepowers.driverapitoyapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    /**
     * firstname : Nate
     * address : {"country":"united states","city":"Berkeley","street":"2450 Warrint st","street2":"35B","state":"California","postal":"94704"}
     * regions : [{"regionId":"J2nbd9Aqmp","descriptor":"San Francisco"}]
     * sandbox : true
     * dobDay : 28
     * type : 1
     * lastname : Powers
     * emailVerified : false
     * tzId : America/Los_Angeles
     * nickname : N8sters
     * dobYear : 1993
     * dobMonth : 2
     * email : nate@gocopia.com
     * status : 0
     */

    private String firstname;
    private AddressBean address;
    private boolean sandbox;
    private int dobDay;
    @SerializedName("type")
    private int typeX;
    private String lastname;
    private boolean emailVerified;
    private String tzId;
    private String nickname;
    private int dobYear;
    private int dobMonth;
    private String email;
    private int status;
    private List<RegionsBean> regions;

    User() {

    }




    public String getSuccess() {
        return success;
    }

    public void setToken(String token1) {
        token = token1;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public boolean isSandbox() {
        return sandbox;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public int getTypeX() {
        return typeX;
    }

    public void setTypeX(int typeX) {
        this.typeX = typeX;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getTzId() {
        return tzId;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<RegionsBean> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionsBean> regions) {
        this.regions = regions;
    }


    public static class AddressBean {
        /**
         * country : united states
         * city : Berkeley
         * street : 2450 Warrint st
         * street2 : 35B
         * state : California
         * postal : 94704
         */

        private String country;
        private String city;
        private String street;
        private String street2;
        private String state;
        private String postal;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostal() {
            return postal;
        }

        public void setPostal(String postal) {
            this.postal = postal;
        }
    }

    public static class RegionsBean {
        /**
         * regionId : J2nbd9Aqmp
         * descriptor : San Francisco
         */

        private String regionId;
        private String descriptor;

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }
    }
}
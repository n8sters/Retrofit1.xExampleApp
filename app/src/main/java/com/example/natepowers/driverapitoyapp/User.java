package com.example.natepowers.driverapitoyapp;

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



    /**
     * firstname : Nate
     * address : {"country":"united states","city":"Berkeley","street":"2450 Warrint st","street2":"35B","state":"California","postal":"94704"}
     * regions : [{"regionId":"J2nbd9Aqmp","descriptor":"San Francisco"}]
     * sandbox : true
     * dobDay : 28
     * availability : {"sunday":0,"saturday":14336,"tuesday":261888,"wednesday":261888,"thursday":261888,"friday":261888,"monday":261888}
     * type : 1
     * lastname : Powers
     * emailVerified : false
     * phone : +16502234780
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
    private AvailabilityBean availability;
    private int type;
    private String lastname;
    private boolean emailVerified;
    private String phone;
    private String tzId;
    private String nickname;
    private int dobYear;
    private int dobMonth;
    private String email;
    private int status;
    private List<RegionsBean> regions;
    /**
     * token : eyJhbGciOiJIUzI1NiJ9.eyJVU0lEIjoiYTk4MmYzM2FhODViNjQ0OTNiOTNjYzc3Zjk3YjYyMDVlNTliZTc1OSIsInRzIjoxNTAwMzExMjcxfQ.-3dDEe5LTKEeVCvuV7JUbJbYQzJCucsqx5u40yXJp8w
     */

    private String token;
    /**
     * success : true
     */

    private boolean success;
    /**
     * UUID : 557264d2-ee65-41a9-b3b5-83d2-5562431
     * confirmId : 107539
     */

    private String UUID;
    private String confirmId;


    public User() {
    }

    public User(String phone ) {
        this.phone = phone;
    }

    public User(String UUID, String confirmId, String phone) {
        this.UUID = UUID;
        this.confirmId = confirmId;
        this.phone = phone;
    }

    public User(String firstname, String lastname, String nickname, String email) {
        this.firstname = firstname;
        this.address = address;
        this.sandbox = sandbox;
        this.dobDay = dobDay;
        this.availability = availability;
        this.type = type;
        this.lastname = lastname;
        this.emailVerified = emailVerified;
        this.phone = phone;
        this.tzId = tzId;
        this.nickname = nickname;
        this.dobYear = dobYear;
        this.dobMonth = dobMonth;
        this.email = email;
        this.status = status;
        this.regions = regions;
        this.token = token;
        this.success = success;
        this.UUID = UUID;
        this.confirmId = confirmId;
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

    public AvailabilityBean getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityBean availability) {
        this.availability = availability;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(String confirmId) {
        this.confirmId = confirmId;
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

    public static class AvailabilityBean {
        /**
         * sunday : 0
         * saturday : 14336
         * tuesday : 261888
         * wednesday : 261888
         * thursday : 261888
         * friday : 261888
         * monday : 261888
         */

        private int sunday;
        private int saturday;
        private int tuesday;
        private int wednesday;
        private int thursday;
        private int friday;
        private int monday;

        public int getSunday() {
            return sunday;
        }

        public void setSunday(int sunday) {
            this.sunday = sunday;
        }

        public int getSaturday() {
            return saturday;
        }

        public void setSaturday(int saturday) {
            this.saturday = saturday;
        }

        public int getTuesday() {
            return tuesday;
        }

        public void setTuesday(int tuesday) {
            this.tuesday = tuesday;
        }

        public int getWednesday() {
            return wednesday;
        }

        public void setWednesday(int wednesday) {
            this.wednesday = wednesday;
        }

        public int getThursday() {
            return thursday;
        }

        public void setThursday(int thursday) {
            this.thursday = thursday;
        }

        public int getFriday() {
            return friday;
        }

        public void setFriday(int friday) {
            this.friday = friday;
        }

        public int getMonday() {
            return monday;
        }

        public void setMonday(int monday) {
            this.monday = monday;
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
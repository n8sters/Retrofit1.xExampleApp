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


public class Task  {


    /**
     * arriveBy : 1500584400
     * assignedAt : 1500590565
     * signatureRequired : false
     * pickup : {"pickupAt":1500584400,"address":{"country":"United States","lng":-122.4166164,"directions":"Please use service elevator located in the loading dock on Jesse Street (between Market and Mission, off of 10th St).","city":"San Francisco","street":"1355 Market Street","street2":"3rd Floor","state":"California","postal":"94103","lat":37.7767687,"addressId":"Tm3uVbNFNA"},"pickupId":"lDeklOHoBQ","user":{"firstname":"Cristina","phone":"+14154302724","company":"Microsoft","email":"cakimoff@yammer-inc.com","lastname":"Fink"}}
     * type : 0
     * taskId : uO_XNFfykA
     * status : 1
     * minimumPhotos : 0
     */



    private int arriveBy;
    private int assignedAt;
    private boolean signatureRequired;
    private PickupBean pickup;
    private int type;
    private String taskId;
    private int status;
    private int minimumPhotos;
    /**
     * pickupAt : 1500588000
     * address : {"country":"United States","lng":-122.4040147,"directions":"There is a white zone to park just outside of the building, also a yellow loading zone.\nCheck in with building security in the lobby and say that you're visiting App Annie. \nThey will escort you to the elevator for access to 8th floor. \nWendy (our receptionist) will help you with our donation.","city":"San Francisco","street":"23 Geary Street","street2":"8th floor","state":"California","postal":"94108","lat":37.78775419999999,"addressId":"0wvg_Tz07A"}
     * pickupId : vYlKVpsDHg
     * user : {"firstname":"AppAnnie","phone":"+14156106720","company":"App Annie","email":"office-sf@appannie.com","lastname":"-"}
     */

    private int pickupAt;
    private AddressBean address;
    private String pickupId;
    private PickupBean.UserBean user;

    public int getArriveBy() {
        return arriveBy;
    }

    public void setArriveBy(int arriveBy) {
        this.arriveBy = arriveBy;
    }

    public int getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(int assignedAt) {
        this.assignedAt = assignedAt;
    }

    public boolean isSignatureRequired() {
        return signatureRequired;
    }

    public void setSignatureRequired(boolean signatureRequired) {
        this.signatureRequired = signatureRequired;
    }

    public PickupBean getPickup() {
        return pickup;
    }

    public void setPickup(PickupBean pickup) {
        this.pickup = pickup;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMinimumPhotos() {
        return minimumPhotos;
    }

    public void setMinimumPhotos(int minimumPhotos) {
        this.minimumPhotos = minimumPhotos;
    }

    public int getPickupAt() {
        return pickupAt;
    }

    public void setPickupAt(int pickupAt) {
        this.pickupAt = pickupAt;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public String getPickupId() {
        return pickupId;
    }

    public void setPickupId(String pickupId) {
        this.pickupId = pickupId;
    }

    public PickupBean.UserBean getUser() {
        return user;
    }

    public void setUser(PickupBean.UserBean user) {
        this.user = user;
    }

    public static class PickupBean {
        /**
         * pickupAt : 1500584400
         * address : {"country":"United States","lng":-122.4166164,"directions":"Please use service elevator located in the loading dock on Jesse Street (between Market and Mission, off of 10th St).","city":"San Francisco","street":"1355 Market Street","street2":"3rd Floor","state":"California","postal":"94103","lat":37.7767687,"addressId":"Tm3uVbNFNA"}
         * pickupId : lDeklOHoBQ
         * user : {"firstname":"Cristina","phone":"+14154302724","company":"Microsoft","email":"cakimoff@yammer-inc.com","lastname":"Fink"}
         */

        private int pickupAt;
        private AddressBean address;
        private String pickupId;
        private UserBean user;

        public int getPickupAt() {
            return pickupAt;
        }

        public void setPickupAt(int pickupAt) {
            this.pickupAt = pickupAt;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public String getPickupId() {
            return pickupId;
        }

        public void setPickupId(String pickupId) {
            this.pickupId = pickupId;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class AddressBean {
            /**
             * country : United States
             * lng : -122.4166164
             * directions : Please use service elevator located in the loading dock on Jesse Street (between Market and Mission, off of 10th St).
             * city : San Francisco
             * street : 1355 Market Street
             * street2 : 3rd Floor
             * state : California
             * postal : 94103
             * lat : 37.7767687
             * addressId : Tm3uVbNFNA
             */

            private String country;
            private double lng;
            private String directions;
            private String city;
            private String street;
            private String street2;
            private String state;
            private String postal;
            private double lat;
            private String addressId;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public String getDirections() {
                return directions;
            }

            public void setDirections(String directions) {
                this.directions = directions;
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

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public String getAddressId() {
                return addressId;
            }

            public void setAddressId(String addressId) {
                this.addressId = addressId;
            }
        }

        public static class UserBean {
            /**
             * firstname : Cristina
             * phone : +14154302724
             * company : Microsoft
             * email : cakimoff@yammer-inc.com
             * lastname : Fink
             */

            private String firstname;
            private String phone;
            private String company;
            private String email;
            private String lastname;

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }
        }
    }


    public static class AddressBean {
        /**
         * country : United States
         * lng : -122.4040147
         * directions : There is a white zone to park just outside of the building, also a yellow loading zone.
         Check in with building security in the lobby and say that you're visiting App Annie.
         They will escort you to the elevator for access to 8th floor.
         Wendy (our receptionist) will help you with our donation.
         * city : San Francisco
         * street : 23 Geary Street
         * street2 : 8th floor
         * state : California
         * postal : 94108
         * lat : 37.78775419999999
         * addressId : 0wvg_Tz07A
         */

        private String country;
        private double lng;
        private String directions;
        private String city;
        private String street;
        private String street2;
        private String state;
        private String postal;
        private double lat;
        private String addressId;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getDirections() {
            return directions;
        }

        public void setDirections(String directions) {
            this.directions = directions;
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

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getAddressId() {
            return addressId;
        }

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }
    }

    public Task(String pickupId ) {
        this.pickupId =  pickupId;
    }
}

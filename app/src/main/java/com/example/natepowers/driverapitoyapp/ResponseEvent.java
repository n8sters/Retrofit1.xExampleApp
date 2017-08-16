package com.example.natepowers.driverapitoyapp;

/**
 * Created by natepowers on 8/15/17.
 */

public class ResponseEvent {

    public static class InternalMessage {

        private String message;

        public InternalMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}


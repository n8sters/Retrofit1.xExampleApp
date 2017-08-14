package com.example.natepowers.driverapitoyapp;

/**
 * Created by natepowers on 8/14/17.
 */

public class TaskPayload {


    /**
     * payloadId : BLUE-NEAT-EAPGV
     * pounds : 23
     * type : 0
     * checkedInAt : 1502735335
     * checkedOutAt : 1502735464
     * status : 2
     */

    private String payloadId;
    private int pounds;
    private int type;
    private int checkedInAt;
    private int checkedOutAt;
    private int status;

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCheckedInAt() {
        return checkedInAt;
    }

    public void setCheckedInAt(int checkedInAt) {
        this.checkedInAt = checkedInAt;
    }

    public int getCheckedOutAt() {
        return checkedOutAt;
    }

    public void setCheckedOutAt(int checkedOutAt) {
        this.checkedOutAt = checkedOutAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

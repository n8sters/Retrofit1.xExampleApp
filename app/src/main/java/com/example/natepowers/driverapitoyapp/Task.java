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


public class Task  {


    @SerializedName(value = "TaskId", alternate = "taskId")
    public String taskId;
    @SerializedName(value = "CoalescenceId", alternate = "coalescenceId")
    public String coalescenceId;
    @SerializedName(value = "Status", alternate = "status")
    public Integer status = Status.UNASSIGNED;
    @SerializedName(value = "Type", alternate = "type")
    public Integer type = Type.PICKUP;
    @SerializedName(value = "PickupId", alternate = "pickupId")
    public String pickupId;
    @SerializedName(value = "DropoffId", alternate = "dropoffId")
    public String dropoffId;
    @SerializedName(value = "ArriveBy", alternate = "arriveBy")
    public Long arriveBy;
    @SerializedName(value = "AssignedTo", alternate = "assignedTo")
    public String assignedTo;
    @SerializedName(value = "AssignedAt", alternate = "assignedAt")
    public Long assignedAt;
    @SerializedName(value = "StartedAt", alternate = "startedAt")
    public Long startedAt;
    @SerializedName(value = "ArrivedAt", alternate = "arrivedAt")
    public Long arrivedAt;
    @SerializedName(value = "CompletedAt", alternate = "completedAt")
    public Long completedAt;
    @SerializedName(value = "FailedAt", alternate = "failedAt")
    public Long failedAt;
    @SerializedName(value = "AbandonedAt", alternate = "abandonedAt")
    public Long abandonedAt;
    @SerializedName(value = "MinimumPhotos", alternate = "minimumPhotos")
    public Integer minimumPhotos = 0;
    @SerializedName(value = "SignatureRequired", alternate = "signatureRequired")
    public Boolean signatureRequired = false;
    @SerializedName(value = "Photos", alternate = "photos")
    public List<String> photos;
    @SerializedName(value = "Signature", alternate = "signature")
    public String signature;
    @SerializedName(value = "Notes", alternate = "notes")
    public String notes;
    @SerializedName(value = "Reason", alternate = "reason")
    public String reason;

    public static class Type {
        public static final int PICKUP = 0;
        public static final int DROPOFF = 1;
    }

    public static class Status {
        public static final int UNASSIGNED = 0;
        public static final int ASSIGNED = 1;
        public static final int STARTED = 2;
        public static final int ARRIVED = 3;
        public static final int COMPLETED = 4;
        public static final int FAILED = 5;
        public static final int ABANDONED = 6;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setCoalescenceId(String coalescenceId) {
        this.coalescenceId = coalescenceId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setPickupId(String pickupId) {
        this.pickupId = pickupId;
    }

    public void setDropoffId(String dropoffId) {
        this.dropoffId = dropoffId;
    }

    public void setArriveBy(Long arriveBy) {
        this.arriveBy = arriveBy;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setAssignedAt(Long assignedAt) {
        this.assignedAt = assignedAt;
    }

    public void setStartedAt(Long startedAt) {
        this.startedAt = startedAt;
    }

    public void setArrivedAt(Long arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public void setCompletedAt(Long completedAt) {
        this.completedAt = completedAt;
    }

    public void setFailedAt(Long failedAt) {
        this.failedAt = failedAt;
    }

    public void setAbandonedAt(Long abandonedAt) {
        this.abandonedAt = abandonedAt;
    }

    public void setMinimumPhotos(Integer minimumPhotos) {
        this.minimumPhotos = minimumPhotos;
    }

    public void setSignatureRequired(Boolean signatureRequired) {
        this.signatureRequired = signatureRequired;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getCoalescenceId() {
        return coalescenceId;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getType() {
        return type;
    }

    public String getPickupId() {
        return pickupId;
    }

    public String getDropoffId() {
        return dropoffId;
    }

    public Long getArriveBy() {
        return arriveBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public Long getAssignedAt() {
        return assignedAt;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public Long getArrivedAt() {
        return arrivedAt;
    }

    public Long getCompletedAt() {
        return completedAt;
    }

    public Long getFailedAt() {
        return failedAt;
    }

    public Long getAbandonedAt() {
        return abandonedAt;
    }

    public Integer getMinimumPhotos() {
        return minimumPhotos;
    }

    public Boolean getSignatureRequired() {
        return signatureRequired;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public String getSignature() {
        return signature;
    }

    public String getNotes() {
        return notes;
    }

    public String getReason() {
        return reason;
    }
}

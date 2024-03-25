package com.forest000014.hhplusw02.dto;

public class LectureResponseDto {

    private String userId;

    protected boolean registered;

    public LectureResponseDto(String userId, boolean registered) {
        this.userId = userId;
        this.registered = registered;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}

package com.example.ticketbioskop.entity.seat;

public class InvoiceRequest {
    private Long userId;
    private String filmCode;
    private Long scheduleId;
    private String studioName;
    private String seatNumber;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFilmCode() {
        return filmCode;
    }

    public void setFilmCode(String filmCode) {
        this.filmCode = filmCode;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "InvoiceRequest{" +
                "userId=" + userId +
                ", filmCode='" + filmCode + '\'' +
                ", scheduleId=" + scheduleId +
                ", studioName='" + studioName + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}

package kz.roma.statistics_api.dto;

import java.time.LocalDateTime;


public class StatisticDto {

    private String messageType;
    private String gateWayName;
    private int messageAmount;
    private LocalDateTime actualDateTime;

    public StatisticDto(String messageType, String gateWayName, int messageAmount, LocalDateTime actualDateTime) {
        this.messageType = messageType;
        this.gateWayName = gateWayName;
        this.messageAmount = messageAmount;
        this.actualDateTime = actualDateTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getGateWayName() {
        return gateWayName;
    }

    public void setGateWayName(String gateWayName) {
        this.gateWayName = gateWayName;
    }

    public int getMessageAmount() {
        return messageAmount;
    }

    public void setMessageAmount(int messageAmount) {
        this.messageAmount = messageAmount;
    }

    public LocalDateTime getActualDateTime() {
        return actualDateTime;
    }

    public void setActualDateTime(LocalDateTime actualDateTime) {
        this.actualDateTime = actualDateTime;
    }

    @Override
    public String toString() {
        return "StatisticDto{" +
                "messageType='" + messageType + '\'' +
                ", gateWayName='" + gateWayName + '\'' +
                ", messageAmount=" + messageAmount +
                ", actualDateTime=" + actualDateTime +
                '}';
    }
}

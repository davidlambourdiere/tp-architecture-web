package com.lifetech.application.dto;

public class NotificationContainerInitializeDTO {
    private String countMessagesReceived;
    private String countMessagesSent;
    private String countMessagesReceivedNotRead;

    public NotificationContainerInitializeDTO() {
    }

    public String getCountMessagesReceived() {
        return countMessagesReceived;
    }

    public void setCountMessagesReceived(String countMessagesReceived) {
        this.countMessagesReceived = countMessagesReceived;
    }

    public String getCountMessagesSent() {
        return countMessagesSent;
    }

    public void setCountMessagesSent(String countMessagesSent) {
        this.countMessagesSent = countMessagesSent;
    }

    public String getCountMessagesReceivedNotRead() {
        return countMessagesReceivedNotRead;
    }

    public void setCountMessagesReceivedNotRead(String countMessagesReceivedNotRead) {
        this.countMessagesReceivedNotRead = countMessagesReceivedNotRead;
    }
}

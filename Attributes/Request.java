package Attributes;

import java.io.Serializable;
import Enums.Priority;
import Users.User;

public class Request implements Comparable<Request>, Serializable {
    private Priority priority;
    private User sender;
    private User recipient;
    private String request;

    public Request(Priority priority, User sender, User recipient, String request) {
        this.priority = priority;
        this.sender = sender;
        this.recipient = recipient;
        this.request = request;
    }

    public Priority getPriority() {
        return priority;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "From: " + sender.getFirstName() + " -> To: " + recipient.getFirstName() + " Request: " + request;
    }

    @Override
    public int compareTo(Request o) {
        return this.priority.compareTo(o.getPriority());
    }
}


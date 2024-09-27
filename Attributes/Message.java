package Attributes;

import java.time.LocalDate;
import java.util.Objects;

import Users.User;

public class Message implements Comparable<Message>{
	private User sender;
	private String message;
	private User recipient;
	private LocalDate date;
	
	public Message() {
		
	}
	public Message(User sender, User recipient, String message, LocalDate date) {
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
		this.date = date;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public int hashCode() {	
		return Objects.hash(sender, recipient, date, message);
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message other = (Message) obj;
        return Objects.equals(sender, other.sender) && 
               Objects.equals(recipient, other.recipient) &&
               Objects.equals(message, other.message) &&
               Objects.equals(date, other.date);
    }
	public String toString() {
		return "Sender: " + sender + " Recipient: " + recipient + " Message:" + message + " Date: " + date;
	}
		
	@Override
    public int compareTo(Message other) {
        return this.date.compareTo(other.date);
    }
}

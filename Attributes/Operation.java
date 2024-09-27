package Attributes;

import java.time.LocalDate;

import Users.User;

public class Operation {
    private User executor;
	private String action;
	private LocalDate date;
	
	public Operation() {
		
	}
	
    public Operation(User executor, String action) {
        this.executor = executor;
        this.action = action;
        this.date = LocalDate.now();
    }
	
	public User getExecutor() {
		return executor;
	}
	public void setExecutor(User executor) {
		this.executor = executor;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String toString() {
	     return "Date = " + this.date + ", executor = " + this.executor + ", action = " + this.action + "\n";
	}
}

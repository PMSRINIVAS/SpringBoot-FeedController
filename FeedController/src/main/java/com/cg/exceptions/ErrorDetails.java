package com.cg.exceptions;


import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String messsage;
	private String details;
	public ErrorDetails(Date timestamp, String messsage, String details) {
		this.timestamp = timestamp;
		this.messsage = messsage;
		this.details = details;
	}
	public ErrorDetails() {
		super();
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", messsage=" + messsage + ", details=" + details + "]";
	}
	
	
		
	
}



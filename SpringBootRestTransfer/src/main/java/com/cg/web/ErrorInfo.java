package com.cg.web;

public class ErrorInfo {
	private String message;
        
	public ErrorInfo() {
		
	}
	public ErrorInfo(String msg) {
		super();
		this.message = msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

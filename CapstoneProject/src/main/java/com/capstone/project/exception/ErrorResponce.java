package com.capstone.project.exception;

import java.time.LocalDate;

public class ErrorResponce {
	private LocalDate localdate;
	private int status;
	private String error;
	private String message;
	private String path;
	public ErrorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDate getLocaldate() {
		return localdate;
	}
	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ErrorResponce(LocalDate localdate, int status, String error, String message, String path) {
		super();
		this.localdate = localdate;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}

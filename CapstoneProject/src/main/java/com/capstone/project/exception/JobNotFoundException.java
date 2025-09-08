package com.capstone.project.exception;

public class JobNotFoundException extends RuntimeException {
	public JobNotFoundException(String msg) {
		super(msg);
	}
}

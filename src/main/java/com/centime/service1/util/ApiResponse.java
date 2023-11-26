package com.centime.service1.util;

import lombok.Data;

import java.util.List;

/**
 * This class is used throughout the application as json format response for
 * every API
 * 
 * 
 */
@Data
public class ApiResponse {

	private int statusCode;

	private String status;

	private String message;

	private Object data;
   

	
	public ApiResponse() {
		this.status = "success";

	}

	public ApiResponse(int statusCode, String status, String message, Object data) {

		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public ApiResponse(int statusCode, String status, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
	}

	public ApiResponse(int statusCode) {

		if (statusCode == 200 || statusCode == 201) {
			this.statusCode = statusCode;
			this.status = "success";

		} else if (statusCode == 500) {
			this.statusCode = statusCode;
			this.status = "failure";
			this.message = "";

		} else {
			this.statusCode = statusCode;
			this.status = "failure";
		}

	}



}

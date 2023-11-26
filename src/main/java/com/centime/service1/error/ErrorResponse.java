package com.centime.service1.error;

import lombok.Data;

@Data
public class ErrorResponse {
	private final String url;
    private final String ex;
     
    public ErrorResponse(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
}

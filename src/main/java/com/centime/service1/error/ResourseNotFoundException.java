package com.centime.service1.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 private String resourceName;
	    private String fieldName;
	  //  private long fieldValue;

	    public ResourseNotFoundException(String resourceName, String fieldName) {
	        super(String.format("%s not found with %s : '%s'", resourceName, fieldName)); // user not found with id : 1
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	      //  this.fieldValue = fieldValue;
	    }


}

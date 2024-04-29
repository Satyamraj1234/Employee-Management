package com.springbootrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourcenotfoundexception extends RuntimeException {
	private String resoucename;
	private String fieldname;
	private Object fieldvalue;
	public resourcenotfoundexception(String resoucename, String fieldname, Object fieldvalue) {
		super(String.format("%s not found with %s:%s", resoucename,fieldname,fieldvalue));
		this.resoucename = resoucename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue; 
	}
	public String getResoucename() {
		return resoucename;
	}
	public String getFieldname() {
		return fieldname;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}
	

}

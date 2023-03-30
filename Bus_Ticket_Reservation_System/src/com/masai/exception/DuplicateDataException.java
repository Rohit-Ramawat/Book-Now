package com.masai.exception;

public class DuplicateDataException extends Exception {
	
	public DuplicateDataException(){
		
	}
	
	public DuplicateDataException(String msg){
		super(msg);
	}
}

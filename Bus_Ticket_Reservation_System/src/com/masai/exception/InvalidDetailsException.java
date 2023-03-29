package com.masai.exception;

public class InvalidDetailsException extends Exception{
     
	public InvalidDetailsException(){
		super();
	}
	public InvalidDetailsException(String msg){
		super(msg);
	}
}

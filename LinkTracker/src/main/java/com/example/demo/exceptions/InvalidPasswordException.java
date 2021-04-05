package com.example.demo.exceptions;

public class InvalidPasswordException extends Exception{

    public InvalidPasswordException(Integer linkId, String pwd){
        super("Password: " + pwd + " is not valid for linkId: " + linkId.toString());
    }
}

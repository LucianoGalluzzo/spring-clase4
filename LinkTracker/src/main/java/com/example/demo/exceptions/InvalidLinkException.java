package com.example.demo.exceptions;

public class InvalidLinkException extends Exception{

    public InvalidLinkException(Integer linkId){
        super("Link with linkId: " + linkId.toString() + " is invalid");
    }
}

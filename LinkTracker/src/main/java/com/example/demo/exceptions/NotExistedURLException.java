package com.example.demo.exceptions;

public class NotExistedURLException extends Exception{

    public NotExistedURLException(Integer linkId){
        super("Not existed link with linkId: " + linkId.toString());
    }
}

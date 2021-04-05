package com.example.demo.exceptions;

public class NotMatchURLException extends Exception{

    public NotMatchURLException(String url){
        super(url + " is not a valid url");
    }
}

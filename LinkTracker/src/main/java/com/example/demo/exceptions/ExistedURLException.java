package com.example.demo.exceptions;

public class ExistedURLException extends Exception{

    public ExistedURLException(String url){
        super(url + " already exist in database");
    }
}

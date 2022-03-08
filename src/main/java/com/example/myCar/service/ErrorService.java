package com.example.myCar.service;

public class ErrorService extends Exception{

    public ErrorService(String msn){
            super(msn);
        }
}

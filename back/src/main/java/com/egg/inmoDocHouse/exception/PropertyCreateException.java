package com.egg.inmoDocHouse.exception;

public class PropertyCreateException extends NullPointerException{

    public PropertyCreateException(){
        super("Los datos enviados son incorrectos");
    }

}

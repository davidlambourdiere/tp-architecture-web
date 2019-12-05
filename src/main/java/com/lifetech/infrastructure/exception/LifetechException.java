package com.lifetech.infrastructure.exception;

import java.util.Map;

public abstract class LifetechException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMsgParameters;

    public Map<String, String> getErrorMsgParameters(){
        return errorMsgParameters;
    }

    public void setErrorMsgParameters(Map<String, String> errorMsgParameters){
        this.errorMsgParameters = errorMsgParameters;
    }

    public LifetechException(){
        super();
    }

    public LifetechException(Throwable throwable){
        super(throwable);
    }

    public LifetechException(String message){
        super(message);
    }

    public LifetechException(String message, Map<String, String> errorMsgParameters){
        super(message);
        this.errorMsgParameters = errorMsgParameters;
    }

    public LifetechException(String message, Throwable throwable){
        super(message, throwable);
    }
}

package org.example;

public class MyNullPointerException extends RuntimeException {
    public MyNullPointerException (){
    }
    public MyNullPointerException (String message){
        super(message);
    }
    public MyNullPointerException (String message, Throwable cause){
        super(message,cause);
    }
    public MyNullPointerException (Throwable cause) {
        super(cause);
    }
    public MyNullPointerException (String message, Throwable cause, boolean suppresion, boolean stackTeace){
        super(message,cause,suppresion, stackTeace);
    }
}




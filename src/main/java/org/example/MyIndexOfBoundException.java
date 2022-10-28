package org.example;

public class MyIndexOfBoundException extends RuntimeException {
    public MyIndexOfBoundException (){
    }
    public MyIndexOfBoundException (String message){
        super(message);
    }
    public MyIndexOfBoundException (String message, Throwable cause){
        super(message,cause);
    }
    public MyIndexOfBoundException (Throwable cause) {
        super(cause);
    }
    public MyIndexOfBoundException (String message, Throwable cause, boolean suppresion, boolean stackTeace){
        super(message,cause,suppresion, stackTeace);
    }
}



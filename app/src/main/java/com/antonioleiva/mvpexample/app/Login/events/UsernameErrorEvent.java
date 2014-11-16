package com.antonioleiva.mvpexample.app.Login.events;

/**
 * Created by Nathan on 15/11/2014.
 */
public class UsernameErrorEvent {

    private String errorMessage;

    public UsernameErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

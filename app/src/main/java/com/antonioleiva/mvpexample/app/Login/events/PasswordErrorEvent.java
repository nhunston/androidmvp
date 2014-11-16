package com.antonioleiva.mvpexample.app.Login.events;

/**
 * Created by Nathan on 16/11/2014.
 */
public class PasswordErrorEvent {

    private String errorMessage;

    public PasswordErrorEvent(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

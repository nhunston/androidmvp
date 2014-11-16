package com.antonioleiva.mvpexample.app.Login;

import android.os.Handler;
import android.text.TextUtils;

import com.antonioleiva.mvpexample.app.Login.bus.BusServiceImpl;
import com.antonioleiva.mvpexample.app.Login.events.LoginSuccessEvent;
import com.antonioleiva.mvpexample.app.Login.events.PasswordErrorEvent;
import com.antonioleiva.mvpexample.app.Login.events.UsernameErrorEvent;

public class LoginInteractorImpl implements LoginInteractor {

    BusServiceImpl busService;
    public LoginInteractorImpl(BusServiceImpl busService) {
        this.busService = busService;
    }

    @Override
    public void login(final String username, final String password) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){

                    busService.post(new UsernameErrorEvent("Username was empty"));

                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    busService.post(new PasswordErrorEvent("Password was empty"));
                    error = true;
                }
                if (!error){
                    busService.post(new LoginSuccessEvent());
                }
            }
        }, 2000);
    }
}

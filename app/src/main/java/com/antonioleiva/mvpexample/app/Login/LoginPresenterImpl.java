/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.Login;

import com.antonioleiva.mvpexample.app.Login.bus.BusServiceImpl;
import com.antonioleiva.mvpexample.app.Login.events.LoginSuccessEvent;
import com.antonioleiva.mvpexample.app.Login.events.PasswordErrorEvent;
import com.antonioleiva.mvpexample.app.Login.events.UsernameErrorEvent;
import com.squareup.otto.Subscribe;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    private BusServiceImpl busService;

    public LoginPresenterImpl(LoginView loginView) {
        this.busService = BusServiceImpl.getInstance();
        this.busService.register(this);

        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl(busService);
    }

    @Override public void validateCredentials(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username, password);
    }

    @Subscribe
    public void onUsernameError(UsernameErrorEvent event) {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Subscribe
    public void onPasswordError(PasswordErrorEvent event) {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Subscribe
    public void onSuccess(LoginSuccessEvent event) {
        loginView.navigateToHome();
    }
}

package com.antonioleiva.mvpexample.app.Login.bus;

/**
 * Created by Nathan on 16/11/2014.
 */
public interface BusService {

    public void register(Object object);
    public void unregister(Object object);

    public void post(Object object);
}

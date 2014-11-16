package com.antonioleiva.mvpexample.app.Login.bus;

import com.squareup.otto.Bus;

/**
 * Created by Nathan on 15/11/2014.
 */
public class BusServiceImpl implements BusService {

    private Bus bus;
    private static BusServiceImpl busService;

    private BusServiceImpl() {
        this.bus = new Bus();
    }

    public static BusServiceImpl getInstance() {
        if (busService == null) {
            synchronized (BusServiceImpl.class) {
                if (busService == null) {
                    busService = new BusServiceImpl();
                }
            }
        }

        return busService;
    }

    public void register(Object object) {
        bus.register(object);
    }

    @Override
    public void unregister(Object object) {
        bus.unregister(object);
    }

    @Override
    public void post(Object object) {
        bus.post(object);
    }
}

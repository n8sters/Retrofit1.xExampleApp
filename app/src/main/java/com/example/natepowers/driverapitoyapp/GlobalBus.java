package com.example.natepowers.driverapitoyapp;

import com.squareup.otto.Bus;

/**
 * Created by natepowers on 8/15/17.
 */

public class GlobalBus {
    private static Bus sBus;
    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }
}

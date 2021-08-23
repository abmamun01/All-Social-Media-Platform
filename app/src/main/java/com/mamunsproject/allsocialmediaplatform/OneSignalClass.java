package com.mamunsproject.allsocialmediaplatform;


import android.app.Application;

import com.onesignal.OneSignal;

public class OneSignalClass extends Application {
    private static final String ONESIGNAL_APP_ID = "e2c15833-f70d-485c-85ea-829c920e4825";

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

    
}

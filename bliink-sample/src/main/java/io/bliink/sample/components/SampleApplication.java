package io.bliink.sample.components;

import android.app.Application;

import io.bliink.sample.utils.Constants;
import io.bliink.sdk.components.BLIINK;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BLIINK.getInstance().initialize(this, Constants.NETWORK_ID, Constants.SITE_ID, true, 5);
    }
}
package com.wayfair.jhu.attbill;

import android.app.Application;

import io.realm.Realm;


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        Realm.init(this);
    }
}

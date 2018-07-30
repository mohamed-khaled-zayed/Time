package com.binarycase.mohamed.ontime.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import static java.security.AccessController.getContext;

public class OnTime extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT == 19) {
            try {
                ProviderInstaller.installIfNeeded(this);
            } catch (Exception ignored) {
                Log.e("EXCEPTIONNN", ignored.getMessage() + " ");
            }
        }
        AndroidNetworking.initialize(getApplicationContext());
    }
}

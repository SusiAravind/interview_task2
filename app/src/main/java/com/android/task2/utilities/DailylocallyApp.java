
package com.android.task2.utilities;

import android.app.Activity;
import android.app.Application;


import com.android.task2.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class DailylocallyApp extends Application implements HasActivityInjector {

    public static final String TAG = DailylocallyApp.class
            .getSimpleName();

    private static DailylocallyApp mInstance;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;



    public static synchronized DailylocallyApp getInstance() {
        return mInstance;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);



    }


}


package com.android.task2.di.component;

import android.app.Application;


import com.android.task2.di.ActivityBuilder;
import com.android.task2.di.appmodule.AppModule;
import com.android.task2.utilities.DailylocallyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(DailylocallyApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();

    }


}

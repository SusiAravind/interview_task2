package com.android.task2.di;


import com.android.task2.ui.main.MainActivity;
import com.android.task2.ui.main.MainActivityModule;
import com.android.task2.ui.pages.PageProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {



    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,PageProvider.class

    })
    abstract MainActivity bindMainActivity();



}

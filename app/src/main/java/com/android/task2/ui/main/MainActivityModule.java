package com.android.task2.ui.main;

import androidx.lifecycle.ViewModelProvider;

import com.android.task2.utilities.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {



    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

}

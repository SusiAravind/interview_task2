package com.android.task2.ui.main;

import androidx.databinding.ObservableBoolean;

import com.android.task2.ui.base.BaseViewModel;


public class MainViewModel extends BaseViewModel<MainNavigator> {


    public final ObservableBoolean isHome = new ObservableBoolean();
    public final ObservableBoolean isSettings = new ObservableBoolean();
    public final ObservableBoolean isMail = new ObservableBoolean();
    public final ObservableBoolean isAcc = new ObservableBoolean();



    public MainViewModel() {
        super();
    }


    public void home() {
        getNavigator().home();
        isHome.set(true);
        isSettings.set(false);
        isMail.set(false);
        isAcc.set(false);
    }

    public void settings() {
        getNavigator().settings();
        isHome.set(false);
        isSettings.set(true);
        isMail.set(false);
        isAcc.set(false);
    }

    public void account() {
        getNavigator().account();
        isHome.set(false);
        isSettings.set(false);
        isMail.set(false);
        isAcc.set(true);
    }

    public void mail() {
        getNavigator().mail();
        isHome.set(false);
        isSettings.set(false);
        isMail.set(true);
        isAcc.set(false);
    }


}

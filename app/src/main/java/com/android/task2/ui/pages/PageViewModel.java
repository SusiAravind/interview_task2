package com.android.task2.ui.pages;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.android.task2.ui.base.BaseViewModel;

import dagger.Module;

@Module
public class PageViewModel extends BaseViewModel<PageNavigator> {


    public final ObservableField<String> title = new ObservableField<>();

    public PageViewModel() {
        super();


    }

}

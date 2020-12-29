package com.android.task2.ui.pages;




import dagger.Module;
import dagger.Provides;

@Module
public class PageModule {

    @Provides
    PageViewModel provideMyAccViewModel() {
        return new PageViewModel();
    }
}

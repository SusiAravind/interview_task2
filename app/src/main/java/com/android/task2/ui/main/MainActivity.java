package com.android.task2.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.task2.BR;
import com.android.task2.R;
import com.android.task2.databinding.ActivityMainBinding;
import com.android.task2.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {


    boolean doubleBackToExitPressedOnce = false;
    @Inject
    MainViewModel mMainViewModel;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private ActivityMainBinding mActivityMainBinding;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void home() {
        mActivityMainBinding.frame.setCurrentItem(0);
    }

    @Override
    public void settings() {
        mActivityMainBinding.frame.setCurrentItem(1);
    }

    @Override
    public void account() {
        mActivityMainBinding.frame.setCurrentItem(3);
    }

    @Override
    public void mail() {
        mActivityMainBinding.frame.setCurrentItem(2);
    }


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);


        Glide.with(this)
                .load(R.raw.settings)
                .into(mActivityMainBinding.menu2);
        Glide.with(this)
                .load(R.raw.mail)
                .into(mActivityMainBinding.menu3);


        PagePagerAdapter adapter = new PagePagerAdapter
                (getSupportFragmentManager());
        mActivityMainBinding.frame.setAdapter(adapter);
        mMainViewModel.home();



        mActivityMainBinding.frame.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //   mActivityMainBinding.frame.setCurrentItem(1);

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mMainViewModel.home();
                        break;
                    case 1:
                        mMainViewModel.settings();
                        break;
                    case 2:
                        mMainViewModel.mail();
                        break;
                    case 3:
                        mMainViewModel.account();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}

package com.android.task2.ui.pages;

import android.os.Bundle;
import android.view.View;

import com.android.task2.BR;
import com.android.task2.R;
import com.android.task2.databinding.FragmentPageBinding;
import com.android.task2.ui.base.BaseFragment;

import javax.inject.Inject;

public class PageFragment extends BaseFragment<FragmentPageBinding, PageViewModel> implements PageNavigator {


    @Inject
    PageViewModel mPageViewModel;

    FragmentPageBinding mFragmentPageBinding;


    public static PageFragment newInstance(int pos) {
        Bundle args = new Bundle();
        args.putInt("POS", pos);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.pageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_page;
    }

    @Override
    public PageViewModel getViewModel() {
        return mPageViewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentPageBinding = getViewDataBinding();
        mPageViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mPageViewModel.title.set("POSITION :" + getArguments().getInt("POS", 0));


    }


    @Override
    public void handleError(Throwable throwable) {

    }


}

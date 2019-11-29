package com.example.mobileshop.activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseActivity;
import com.example.mobileshop.fragment.NavigationFragment;


public class MainActivity extends BaseActivity {

    @Override
    public @LayoutRes
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.f1_main,new NavigationFragment());
        transaction.commit();
    }
}


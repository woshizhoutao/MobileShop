package com.example.mobileshop.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view= inflater.inflate(getContentViewId(),container,false);
        mUnbinder = ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected void initData(){
    }

    protected void initView(View view){
    }

    public abstract int getContentViewId();

    public void toastShort(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }
}

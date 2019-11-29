package com.example.mobileshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileshop.R;
import com.example.mobileshop.common.BaseActivity;
import com.example.mobileshop.common.MobileShopApp;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


public class AdActivity extends BaseActivity{

    private TextView tv_skip;

    @Override
    public int getContentViewId(){
        return R.layout.activity_ad;
    }

    @Override
    protected void initView(){
        super.initView();
        tv_skip = (TextView)findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                skip();
            }
        });
        ImageView imageView = (ImageView)findViewById(R.id.iv_image);
        String url = "ehttps://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574424650882&di=fe9d422d46c396e78b41a558e4d4296b&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F88f20968d971508380a84ae6abf6dfc667688610.jpg";
        ImageLoader.getInstance().displayImage(url,imageView,new ImageLoadingListener(){
            @Override
            public void onLoadingStarted(String imageUri, View view){

            }
            @Override
            public void onLoadingFailed(String imageUri,View view,FailReason failReason){
                MobileShopApp.handler.post(jumpTread);
            }
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage){
                MobileShopApp.handler.post(jumpTread);
            }
            @Override
            public void onLoadingCancelled(String imageUri,View view){
                MobileShopApp.handler.post(jumpTread);
            }
        });
    }
    private void skip(){
        Intent intent = new Intent(AdActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        c_count = COUNT;
        MobileShopApp.handler.removeCallbacks(jumpTread);
    }
    private static final String SKIP_TEXT = "点击跳过%d";
    private final static int COUNT = 5;
    private final static int DELAYED = 1000;
    private int c_count = COUNT;
    private Runnable jumpTread = new  Runnable(){
        @Override
        public void run(){
            if(c_count <= 0){
                skip();
            }else{
                tv_skip.setText(String.format(SKIP_TEXT,c_count));
                c_count--;
                MobileShopApp.handler.postDelayed(jumpTread,DELAYED);
            }
        }
    };
}

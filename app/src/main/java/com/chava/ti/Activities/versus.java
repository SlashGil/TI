package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.chava.ti.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class versus extends AppCompatActivity implements View.OnClickListener{
    int[] fotos= {R.drawable.versus1,R.drawable.versus1p2,R.drawable.versus1p3,R.drawable.versus2,R.drawable.versus2p2,R.drawable.versus2p3};
    CarouselView carouselView;
    ImageView img1, img2, img3, img4,img5,img6, home, upaep, login;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int mode = this.getResources().getConfiguration().orientation;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);

        home.setOnClickListener(this);
        login.setOnClickListener(this);
        if(mode == Configuration.ORIENTATION_LANDSCAPE){
            carouselView = findViewById(R.id.carouselVersus);
            carouselView.setPageCount(fotos.length);
            carouselView.setImageListener(imageListener);
        }
        }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(fotos[position]);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        int mode = this.getResources().getConfiguration().orientation;
        if(mode == Configuration.ORIENTATION_LANDSCAPE)
            carouselView.setImageListener(null);
    }

    @Override
    protected void onResume() {
        int mode = this.getResources().getConfiguration().orientation;
        super.onResume();
        if(mode == Configuration.ORIENTATION_LANDSCAPE)
            carouselView.setImageListener(imageListener);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.home: {
                finish();
            } break;
            case R.id.login_toolbar: {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        }
    }
}

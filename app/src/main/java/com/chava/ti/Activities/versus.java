package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;

import com.chava.ti.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class versus extends AppCompatActivity {
    int[] fotos= {R.drawable.uno,R.drawable.dos,R.drawable.tres};
    CarouselView carouselView;
    ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int mode = this.getResources().getConfiguration().orientation;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);

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
}

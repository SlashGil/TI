package com.chava.ti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] fotos= {R.drawable.uno,R.drawable.dos,R.drawable.tres};
    TextView txtWelcome;
    CarouselView carouselView;
    ImageView imageView;
    CardView cardView;
    Button uno, dos, tres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWelcome = findViewById(R.id.txtBienvenido);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(fotos.length);
        carouselView.setImageListener(imageListener);
        uno = findViewById(R.id.faq);
        dos = findViewById(R.id.m);
        tres = findViewById(R.id.g);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(fotos[position]);
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId() == uno.getId()){
            Intent faq = new Intent(v.getContext(),faq.class);
            startActivity(faq);
        }
        if(v.getId() == dos.getId()){
            Intent maestros = new Intent(v.getContext(), claustro.class);
            startActivity(maestros);
        }
        if(v.getId() == tres.getId()){
            Intent grupos = new Intent(v.getContext(), grupos.class);
            startActivity(grupos);
        }

    }
}

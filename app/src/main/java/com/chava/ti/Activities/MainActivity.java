package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.chava.ti.R;
import com.chava.ti.interfaces.IComunicateFragments;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import com.chava.ti.Fragments.InicioFragment;

public class MainActivity extends AppCompatActivity  implements InicioFragment.OnFragmentInteractionListener, IComunicateFragments, View.OnClickListener{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Toolbar toolbar;
    int[] fotos = {R.drawable.first1, R.drawable.second, R.drawable.third, R.drawable.fourth1};
    CarouselView carouselView;
   Fragment fragmentInicio;
   FloatingActionButton camera;
   ImageView home, upaep, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(fotos.length);
        carouselView.setImageListener(imageListener);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        camera = findViewById(R.id.camera);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        home.setVisibility(View.GONE);
        camera.setOnClickListener(this);
        home.setOnClickListener(this);
        login.setOnClickListener(this);
        fragmentInicio = new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment,fragmentInicio).commit();
    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(fotos[position]);
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void launchFaq() {
        Intent intent = new Intent(getApplicationContext(), faq.class);
        startActivity(intent);
    }

    @Override
    public void launchVersus() {
        Intent intent = new Intent(getApplicationContext(), versus.class);
        startActivity(intent);
    }

    @Override
    public void launchClaustro() {
        Intent intent = new Intent(getApplicationContext(), claustro.class);
        startActivity(intent);
    }

    @Override
    public void launchGroups() {
        Intent intent = new Intent(getApplicationContext(), grupos.class);
        startActivity(intent);
    }

    @Override
    public void launchFacebook() {
        Intent intent = new Intent(getApplicationContext(), FbActivity.class);
        startActivity(intent);
    }

    @Override
    public void launchInsta() {
        Intent intent = new Intent(getApplicationContext(), InstaActivity.class);
        startActivity(intent);
    }

    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id){
            case R.id.camera:{
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
                }
            }
            break;
            case R.id.login_toolbar:{
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
            } break;
        }
    }
}

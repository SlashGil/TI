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

import com.chava.ti.R;
import com.chava.ti.interfaces.IComunicateFragments;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import com.chava.ti.Fragments.InicioFragment;

public class MainActivity extends AppCompatActivity  implements InicioFragment.OnFragmentInteractionListener, IComunicateFragments, View.OnClickListener{

    static final int REQUEST_IMAGE_CAPTURE = 1;

    int[] fotos= {R.drawable.foto1,R.drawable.foto2,R.drawable.foto3, R.drawable.foto4};
    CarouselView carouselView;
   Fragment fragmentInicio;
   FloatingActionButton camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(fotos.length);
        carouselView.setImageListener(imageListener);

        camera = findViewById(R.id.camera);
        camera.setOnClickListener(this);
        fragmentInicio = new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment,fragmentInicio).commit();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Login){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }
}

package com.chava.ti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    private static final int TIME=2000;
    public static final String USER="names";
    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtWelcome = findViewById(R.id.txtWelcome);
        String user = getIntent().getStringExtra("names");
        int dot = user.indexOf(".");
        String name = user.substring(0,dot);
        String lastname = user.substring(dot+1);
        txtWelcome.setText("Bienvenido "+ name + " " + lastname + "!");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent intent = new Intent(Welcome.this,MainActivity.class);
              startActivity(intent);
              finish();
            };
        }, TIME);
    }
}

package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chava.ti.R;

public class Details_Student extends AppCompatActivity implements View.OnClickListener{
    private TextView txtName, txtLastName, txtArea, txtMail;
    private ImageView photo;
    private ImageButton mail;
    Toolbar toolbar;
    ImageView home, upaep, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__student);
        photo = (ImageView) findViewById(R.id.photo_student);
        txtName = (TextView) findViewById(R.id.name_student);
        txtLastName = (TextView) findViewById(R.id.lastname_student);
        txtArea = (TextView) findViewById(R.id.job_Student);
        txtMail = (TextView) findViewById(R.id.mailstudent);
        mail = (ImageButton)findViewById(R.id.btnMail);
        toolbar = findViewById(R.id.toolbar);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        login.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home.setOnClickListener(this);
        mail.setOnClickListener(this);


        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Name");
        String LastName = intent.getExtras().getString("Lastname");
        String Area = intent.getExtras().getString("Area");
        String Mail = intent.getExtras().getString("Mail");
        int Photo = intent.getExtras().getInt("Photo");

        txtName.setText(Name);
        txtLastName.setText(LastName);
        txtArea.setText(Area);
        txtMail.setText(Mail);
        photo.setImageResource(Photo);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnMail: {
                Intent intent = new Intent(getApplicationContext(),Mail.class);
                intent.putExtra("Para",txtMail.getText().toString());
                startActivity(intent);
            }
            break;
            case R.id.home: {
                finish();
            }
        }
    }
}

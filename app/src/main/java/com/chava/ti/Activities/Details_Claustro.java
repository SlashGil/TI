package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chava.ti.R;

import org.w3c.dom.Text;

public class Details_Claustro extends AppCompatActivity {
    private TextView txtName, txtLastName, txtArea, txtMail;
    private ImageView photo;
    private ImageButton mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__claustro);
        photo = (ImageView) findViewById(R.id.photo_claustro);
        txtName = (TextView) findViewById(R.id.name_claustro);
        txtLastName = (TextView) findViewById(R.id.lastname_claustro);
        txtArea = (TextView) findViewById(R.id.area_claustro);
        txtMail = (TextView) findViewById(R.id.mailclaustro);
        mail = (ImageButton)findViewById(R.id.btnMail);

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
}

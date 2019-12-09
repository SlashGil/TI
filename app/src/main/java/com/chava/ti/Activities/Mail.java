package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.chava.ti.R;

public class Mail extends AppCompatActivity implements View.OnClickListener {
    EditText edtPara, edtDe, edtAsunto, edtTexto;
    ImageButton Send;
    Toolbar toolbar;
    ImageView home, upaep, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        edtPara = findViewById(R.id.edtFor);
        edtDe = findViewById(R.id.edtFrom);
        edtAsunto = findViewById(R.id.edtSubject);
        edtTexto = findViewById(R.id.edtText);
        Send = findViewById(R.id.Send_claustro);
        toolbar = findViewById(R.id.toolbar);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String para  = intent.getExtras().getString("Para");
        edtPara.setText(para);
        edtPara.setFocusable(false);
        Send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.Send_claustro: {
                if(edtDe.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"¿Quien envia?",Toast.LENGTH_LONG).show();
                    if(edtAsunto.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"Debes ingresar un asunto",Toast.LENGTH_LONG).show();
                        if(edtTexto.getText().toString().isEmpty()){
                            Toast.makeText(getApplicationContext(),"No has escrito nada",Toast.LENGTH_LONG).show();
                        }
                    }
                } else if (edtAsunto.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Debes ingresar un Asunto",Toast.LENGTH_LONG).show();
                } else if (edtTexto.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"No has escrito nada", Toast.LENGTH_LONG).show();
                }
                else{
                    String de = edtDe.getText().toString();
                    String [] from = de.split(",");
                    String para = edtPara.getText().toString();
                    String [] mailFor = para.split(",");
                    String asunto = edtAsunto.getText().toString();
                    String text = edtTexto.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));

                    intent.putExtra(Intent.EXTRA_EMAIL,mailFor);
                    intent.putExtra(Intent.EXTRA_CC,from);
                    intent.putExtra(Intent.EXTRA_SUBJECT,asunto);
                    intent.putExtra(Intent.EXTRA_TEXT,text);

                    if(intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                }
            }break;
            case R.id.home: {
                finish();
            } break;
            case R.id.login_toolbar: {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            } break;
        }


    }
}

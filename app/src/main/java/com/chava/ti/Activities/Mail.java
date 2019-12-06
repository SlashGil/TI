package com.chava.ti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chava.ti.R;

public class Mail extends AppCompatActivity implements View.OnClickListener {
    EditText edtPara, edtDe, edtAsunto, edtTexto;
    Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        edtPara = findViewById(R.id.edtFor);
        edtDe = findViewById(R.id.edtFrom);
        edtAsunto = findViewById(R.id.edtSubject);
        edtTexto = findViewById(R.id.edtText);
        Send = findViewById(R.id.Send_claustro);
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
       if(edtDe.getText().toString().isEmpty()){
           Toast.makeText(getApplicationContext(),"¿Quien envia?",Toast.LENGTH_LONG).show();
           if(edtAsunto.getText().toString().isEmpty()){
               Toast.makeText(getApplicationContext(),"Debes ingresar un asunto",Toast.LENGTH_LONG).show();
               if(edtTexto.getText().toString().isEmpty()){
                   Toast.makeText(getApplicationContext(),"No has escrito nada",Toast.LENGTH_LONG).show();
               }
           }
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

    }
}

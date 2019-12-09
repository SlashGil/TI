package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.chava.ti.Adapters.RVAdapterStudent;
import com.chava.ti.Adapters.RecyclerViewAdapter;
import com.chava.ti.Models.Student;
import com.chava.ti.R;

import java.util.ArrayList;
import java.util.List;

public class grupos extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv;
    Toolbar toolbar;
    ImageView home, upaep, login;
    List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        initData();
        rv = (RecyclerView) findViewById(R.id.rvstudents);
        toolbar = findViewById(R.id.toolbar);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home.setOnClickListener(this);
        login.setOnClickListener(this);
        RVAdapterStudent adapter = new RVAdapterStudent(this,studentList);
        rv.setLayoutManager(new GridLayoutManager(this,4));
        rv.setAdapter(adapter);

    }

    public void initData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Carlos Osvaldo", "Saavedra Aguilar","Consejero Universitario","carlososvaldo.saavedra@upaep.edu.mx",R.drawable.carlos));
        studentList.add(new Student("Alejandra","Heredia Mendéz", "Consejera Academica", "alejandra.heredia@upaep.edu.mx",R.drawable.ale));
        studentList.add(new Student("Paul", "Jiménez Vela", "Presidente Mesa Directiva", "paul.vela@upaep.edu.mx",R.drawable.paul));
        studentList.add(new Student("Cindy", "Castro Aguilar", "Vicepresidenta Mesa Directiva", "cindyberenice.castro@upaep.edu.mx",R.drawable.cindy));
        studentList.add(new Student("Fernanda","Reyes Guerrero", "Secretaria Mesa Directiva", "fernanda.reyes@upaep.edu.mx",R.drawable.fer));
        studentList.add(new Student("Juan Carlos", "Benítez Fernández", "Vocal de Vida Universitaria", "juancarlos.benitez@upaep.edu.mx",R.drawable.beni));
        studentList.add(new Student("Carlos Osvaldo", "Saavedra Aguilar", "Tesorero Mesa Directiva", "carlososvaldo.saavedra@upaep.edu.mx",R.drawable.carlos));
        studentList.add(new Student("Sergio Enrique", "Zapata Esparza", "Vocal de Vida Universitaria", "sergioenrique.zapata@upaep.edu.mx",R.drawable.sergio));
        studentList.add(new Student("Marco Antonio", "Aguilar del Razo", "Vocal de Consejo Universitario", "marcoantonio.aguilar02@upaep.edu.mx",R.drawable.marco));
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
            } break;
        }
    }
}

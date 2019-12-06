package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.chava.ti.Adapters.RVAdapterStudent;
import com.chava.ti.Adapters.RecyclerViewAdapter;
import com.chava.ti.Models.Student;
import com.chava.ti.R;

import java.util.ArrayList;
import java.util.List;

public class grupos extends AppCompatActivity {

    RecyclerView rv;
    List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        initData();
        rv = (RecyclerView) findViewById(R.id.rvstudents);
        RVAdapterStudent adapter = new RVAdapterStudent(this,studentList);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Login){
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void initData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Carlos Osvaldo", "Saavedra Aguilar","Consejero Universitario","carlososvaldo.saavedra@upaep.edu.mx",R.drawable.dos));
        studentList.add(new Student("Alejandra","Heredia Mendéz", "Consejera Academica", "alejandra.heredia@upaep.edu.mx",R.drawable.uno));
        studentList.add(new Student("Paul", "Jiménez Vela", "Presidente Mesa Directiva", "paul.vela@upaep.edu.mx",R.drawable.paul));
        studentList.add(new Student("Cindy", "Castro Aguilar", "Vicepresidenta Mesa Directiva", "cindyberenice.castro@upaep.edu.mx",R.drawable.cindy));
        studentList.add(new Student("Fernanda","Reyes Guerrero", "Secretaria Mesa Directiva", "fernanda.reyes@upaep.edu.mx",R.drawable.fer));
        studentList.add(new Student("Juan Carlos", "Benítez Fernández", "Vocal de Vida Universitaria", "juancarlos.benitez@upaep.edu.mx",R.drawable.beni));
        studentList.add(new Student("Carlos Osvaldo", "Saavedra Aguilar", "Tesorero Mesa Directiva", "carlososvaldo.saavedra@upaep.edu.mx",R.drawable.dos));
        studentList.add(new Student("Sergio Enrique", "Zapata Esparza", "Vocal de Vida Universitaria", "sergioenrique.zapata@upaep.edu.mx",R.drawable.sergio));
        studentList.add(new Student("Marco Antonio", "Aguilar del Razo", "Vocal de Consejo Universitario", "marcoantonio.aguilar02@upaep.edu.mx",R.drawable.marco));

    }
}

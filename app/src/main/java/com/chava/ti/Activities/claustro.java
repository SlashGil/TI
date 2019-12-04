package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.chava.ti.Adapters.RecyclerViewAdapter;
import com.chava.ti.Models.Teacher;
import com.chava.ti.R;

import java.util.ArrayList;
import java.util.List;

public class claustro extends AppCompatActivity {
    RecyclerView rv;
    List<Teacher> teacherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claustro);
        initData();
        rv = (RecyclerView) findViewById(R.id.rv);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,teacherList);
        rv.setLayoutManager(new GridLayoutManager(this,5));
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
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Laura Margarita", "Rodriguez Peralta","Directora Académica","lauramargarita.rodriguez01@upaep.mx",R.drawable.laura));
        teacherList.add(new Teacher("Sandra Rocio","Murillo Cano", "Cisco Networking Academy", "sandrarocio.murillo@upaep.mx",R.drawable.sandra));
        teacherList.add(new Teacher("Lorna Verónica", "Rosas Téllez", "Bases de Datos y Desarrollo Web", "lornaveronica.rosas@upaep.mx",R.drawable.lorna));
        teacherList.add(new Teacher("Vittorio", "Zanella Palacios", "Inteligencia Artificial y Matemáticas Discretas", "vittorio.zanella@upaep.mx",R.drawable.vittorio));
        teacherList.add(new Teacher("Roberto","Salazar Márquez", "Programación", "roberto.salazar@upaep.mx",R.drawable.robert));
        teacherList.add(new Teacher("Jorge Rafael", "Aguilar Cisneros", "Procesos de Ingeniería", "jorgerafael.upaep.mx",R.drawable.jorge));
        teacherList.add(new Teacher("Alejandro Eduardo", "Jarero Mora", "Paqueteria Office","alejandroeduardo.jarero@upaep.mx", R.drawable.jarero));
        teacherList.add(new Teacher("Beatriz", "Rojas Sánchez", "Paqueteria Office", "beatriz.rojas@upaep.mx",R.drawable.betty));
        teacherList.add(new Teacher(" Jose Francisco", "Zerón Jimenez", "Sistemas Operativos y Programación", "josefrancisco.zeron@upaep.mx"));
        teacherList.add(new Teacher("Patricia Erendira","Benavides Muratalla","Procesos de Ingeniería", "patriciaerendira.benavides@upaep.mx"));
    }
}

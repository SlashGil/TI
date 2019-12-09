package com.chava.ti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.chava.ti.Adapters.faqAdapter;
import com.chava.ti.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class faq extends AppCompatActivity implements View.OnClickListener{
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    faqAdapter adapter;
    Toolbar toolbar;
    ImageView home, upaep, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        expandableListView = findViewById(R.id.expandable_list);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new faqAdapter(this,listGroup,listItem);
        toolbar = findViewById(R.id.toolbar);
        home = toolbar.findViewById(R.id.home);
        upaep = toolbar.findViewById(R.id.upaep);
        login = toolbar.findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        home.setOnClickListener(this);
        login.setOnClickListener(this);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.grupo1));
        listGroup.add(getString(R.string.grupo2));
        listGroup.add(getString(R.string.grupo3));
        listGroup.add(getString(R.string.grupo4));
        listGroup.add(getString(R.string.grupo5));
        listGroup.add(getString(R.string.grupo6));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo1);
        for (String item : array){
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo2);
        for (String item : array){
            list2.add(item);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo3);
        for (String item : array){
            list3.add(item);
        }

        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo4);
        for (String item : array){
            list4.add(item);
        }

        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo5);
        for (String item : array){
            list5.add(item);
        }
        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo6);
        for(String item: array){
            list6.add(item);
        }
        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        listItem.put(listGroup.get(5),list6);
        adapter.notifyDataSetChanged();
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

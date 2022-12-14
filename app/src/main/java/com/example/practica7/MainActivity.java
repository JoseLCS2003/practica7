package com.example.practica7;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.practica7.Adaptadores.PersonaAdaptador;
import com.example.practica7.Modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llamada();
        recycler = (RecyclerView) findViewById(R.id.nose);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Persona> personas = new ArrayList<Persona>();
        for (int i = 0; i < 3; i++) {
            personas.add(new Persona("jose", "8715203953"));
            personas.add(new Persona("Angel", "8712206953"));
            personas.add(new Persona("ana lucia", "8712206833"));
        }
        PersonaAdaptador PA = new PersonaAdaptador(personas);
        recycler.setAdapter(PA);
    }
    private void llamada(){
        int solicitarLlamada=ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE);
        if (solicitarLlamada !=PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},200);
            }
        }

    }
}
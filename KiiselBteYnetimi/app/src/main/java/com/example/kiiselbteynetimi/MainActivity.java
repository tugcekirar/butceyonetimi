package com.example.kiiselbteynetimi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button gelirekle;
    Button giderekle;
    Button notekle;
    Button liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gelirekle=findViewById(R.id.btngelir);
        giderekle=findViewById(R.id.btngider);
        notekle=findViewById(R.id.btnnotlar);
        liste=findViewById(R.id.btnalisverisliste);
        gelirekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gelireklemesayfa=new Intent(MainActivity.this,Gelirekle.class);
                startActivity(gelireklemesayfa);
            }
        });
        giderekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gidereklemesayfa=new Intent(MainActivity.this,Giderekle.class);
                startActivity(gidereklemesayfa);
            }
        });
        notekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noteklemesayfa=new Intent(MainActivity.this,Notekle.class);
                startActivity(noteklemesayfa);
            }
        });
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listesayfa=new Intent(MainActivity.this,Alisverisliste.class);
                startActivity(listesayfa);
            }
        });
    }
}
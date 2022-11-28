package com.example.kiiselbteynetimi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class Gelirekle extends AppCompatActivity {
    EditText gelirgir;
    EditText gelirturgir;
    Button gelirleriekle;
    Button anasayfadon;
    ListView gelirlerlist;
    ArrayAdapter geliradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelirekle);
        gelirgir=findViewById(R.id.edtgelirgir);
        gelirturgir=findViewById(R.id.edtgelirturugir);
        gelirleriekle=findViewById(R.id.btnadd);
        anasayfadon=findViewById(R.id.btnanasayfadon);
        gelirlerlist=findViewById(R.id.lstgelirler);
        DatabaseHelper databaseHelper=new DatabaseHelper(Gelirekle.this);
        getlistviewdata(databaseHelper.tumgelirgetir());
        gelirleriekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GELIR glr;
                try {
                    glr=new GELIR(-1,Integer.parseInt(gelirgir.getText().toString()),gelirturgir.getText().toString());
                    Toast.makeText(Gelirekle.this,"EKLENDİ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    glr=new GELIR(-1,0,"");
                    Toast.makeText(Gelirekle.this,"HATA",Toast.LENGTH_LONG).show();
                }
                DatabaseHelper databaseHelper=new DatabaseHelper(Gelirekle.this);
                boolean success= databaseHelper.addonegelir(glr);
                getlistviewdata(databaseHelper.tumgelirgetir());
            }
        });
        gelirlerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GELIR g=(GELIR)parent.getItemAtPosition(position);
                DatabaseHelper databaseHelper=new DatabaseHelper(Gelirekle.this);
                databaseHelper.deletegelir(g);

                getlistviewdata(databaseHelper.tumgelirgetir());
                Toast.makeText(Gelirekle.this, "SİLİNDİ", Toast.LENGTH_SHORT).show();
            }
        });
        anasayfadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(Gelirekle.this,MainActivity.class);
                startActivity(anasayfa);
            }
        });
    }
    private void getlistviewdata(List<GELIR> tumgelirgetir) {
        geliradapter = new ArrayAdapter<GELIR>(Gelirekle.this, android.R.layout.simple_list_item_1, tumgelirgetir);
        gelirlerlist.setAdapter(geliradapter);
    }
}
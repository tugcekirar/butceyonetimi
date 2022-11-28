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

public class Alisverisliste extends AppCompatActivity {
    Button anasayfadon;
    Button ihtiyacekle;
    EditText ihtiyacgiris;
    ListView ihtiyaclist;
    ArrayAdapter ihtiyacadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alisverisliste);
        anasayfadon=findViewById(R.id.btnanasayfadon4);
        ihtiyacekle=findViewById(R.id.btnlisteyeekle);
        ihtiyacgiris = findViewById(R.id.edtihtiyacgir);
        ihtiyaclist=findViewById(R.id.lstalinacaklar);
        DatabaseHelper4 databaseHelper=new DatabaseHelper4(Alisverisliste.this);
        getlistviewdata4(databaseHelper.tumlistegetir());
        ihtiyacekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALISVERIS al;
                try {
                    al=new ALISVERIS(-1,ihtiyacgiris.getText().toString());
                    Toast.makeText(Alisverisliste.this,"EKLENDİ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    al=new ALISVERIS(-1,"");
                    Toast.makeText(Alisverisliste.this,"HATA",Toast.LENGTH_LONG).show();
                }
                DatabaseHelper4 databaseHelper=new DatabaseHelper4(Alisverisliste.this);
                boolean success4= databaseHelper.addonealinacak(al);
                getlistviewdata4(databaseHelper.tumlistegetir());
            }
        });
        ihtiyaclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ALISVERIS a=(ALISVERIS) parent.getItemAtPosition(position);
                DatabaseHelper4 databaseHelper=new DatabaseHelper4(Alisverisliste.this);
                databaseHelper.deletesatir(a);
                getlistviewdata4(databaseHelper.tumlistegetir());
                Toast.makeText(Alisverisliste.this, "SİLİNDİ", Toast.LENGTH_SHORT).show();
            }
        });
        anasayfadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(Alisverisliste.this,MainActivity.class);
                startActivity(anasayfa);
            }
        });
    }
    private void getlistviewdata4(List<ALISVERIS> tumlistegetir) {
        ihtiyacadapter = new ArrayAdapter<ALISVERIS>(Alisverisliste.this, android.R.layout.simple_list_item_1, tumlistegetir);
        ihtiyaclist.setAdapter(ihtiyacadapter);
    }
}
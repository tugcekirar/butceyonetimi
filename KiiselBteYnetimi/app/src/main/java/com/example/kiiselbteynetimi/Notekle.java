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

public class Notekle extends AppCompatActivity {
    Button anasayfadon;
    Button notekle;
    EditText notgiris;
    ListView notlarlist;
    ArrayAdapter notadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notekle);
        anasayfadon=findViewById(R.id.btnanasayfadon3);
        notekle=findViewById(R.id.btnnotekle);
        notgiris=findViewById(R.id.edtnotgiris);
        notlarlist=findViewById(R.id.lstnotlar);
        DatabaseHelper3 databaseHelper=new DatabaseHelper3(Notekle.this);
        getlistviewdata3(databaseHelper.tumnotlargetir());
        notekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NOTLAR nt;
                try {
                    nt=new NOTLAR(-1,notgiris.getText().toString());
                    Toast.makeText(Notekle.this,"EKLENDİ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    nt=new NOTLAR(-1,"");
                    Toast.makeText(Notekle.this,"HATA",Toast.LENGTH_LONG).show();
                }
                DatabaseHelper3 databaseHelper=new DatabaseHelper3(Notekle.this);
                boolean success3= databaseHelper.addonenot(nt);
                getlistviewdata3(databaseHelper.tumnotlargetir());
            }
        });
        notlarlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NOTLAR n=(NOTLAR) parent.getItemAtPosition(position);
                DatabaseHelper3 databaseHelper=new DatabaseHelper3(Notekle.this);
                databaseHelper.deletenotlar(n);

                getlistviewdata3(databaseHelper.tumnotlargetir());
                Toast.makeText(Notekle.this, "SİLİNDİ", Toast.LENGTH_SHORT).show();
            }
        });
        anasayfadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(Notekle.this,MainActivity.class);
                startActivity(anasayfa);
            }
        });
    }
    private void getlistviewdata3(List<NOTLAR> tumnotlargetir) {
        notadapter = new ArrayAdapter<NOTLAR>(Notekle.this, android.R.layout.simple_list_item_1, tumnotlargetir);
        notlarlist.setAdapter(notadapter);
    }
}
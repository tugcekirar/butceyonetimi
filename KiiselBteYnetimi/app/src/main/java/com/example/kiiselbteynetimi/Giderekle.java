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

public class Giderekle extends AppCompatActivity {
    EditText gidergir;
    EditText giderturgir;
    Button giderleriekle;
    Button anasayfayadon;
    ListView giderlerlist;
    ArrayAdapter gideradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giderekle);
        gidergir=findViewById(R.id.edtgidergir);
        giderturgir=findViewById(R.id.edtgiderturugir);
        giderleriekle=findViewById(R.id.btnaddgider);
        anasayfayadon=findViewById(R.id.btnanasayfadon2);
        giderlerlist=findViewById(R.id.lstgiderler);
        DatabaseHelper2 databaseHelper=new DatabaseHelper2(Giderekle.this);
        getlistviewdata2(databaseHelper.tumgidergetir());
        giderleriekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GIDER gdr;
                try {
                    gdr=new GIDER(-1,Integer.parseInt(gidergir.getText().toString()),giderturgir.getText().toString());
                    Toast.makeText(Giderekle.this,"EKLENDİ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    gdr=new GIDER(-1,0,"");
                    Toast.makeText(Giderekle.this,"HATA",Toast.LENGTH_LONG).show();
                }
                DatabaseHelper2 databaseHelper=new DatabaseHelper2(Giderekle.this);
                boolean success2= databaseHelper.addonegider(gdr);
                getlistviewdata2(databaseHelper.tumgidergetir());
            }
        });
        giderlerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GIDER g2=(GIDER)parent.getItemAtPosition(position);
                DatabaseHelper2 databaseHelper=new DatabaseHelper2(Giderekle.this);
                databaseHelper.deletegider(g2);
                getlistviewdata2(databaseHelper.tumgidergetir());
                Toast.makeText(Giderekle.this, "SİLİNDİ", Toast.LENGTH_SHORT).show();
            }
        });
        anasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(Giderekle.this,MainActivity.class);
                startActivity(anasayfa);
            }
        });
    }
    private void getlistviewdata2(List<GIDER> tumgidergetir) {
        gideradapter = new ArrayAdapter<GIDER>(Giderekle.this, android.R.layout.simple_list_item_1, tumgidergetir);
        giderlerlist.setAdapter(gideradapter);
    }
}
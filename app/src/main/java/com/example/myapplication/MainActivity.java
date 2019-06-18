package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_hoten,txt_tuoi;
    Button btn_Add,btn_Next;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_hoten=findViewById(R.id.txt_hoTen);
        txt_tuoi=findViewById(R.id.txt_tuoi);
        btn_Add=findViewById(R.id.btn_Add);
        btn_Next=findViewById(R.id.btn_Next);
        databaseManager= new DatabaseManager(this);
    }

    public void addClick(View view) {
        SinhVien sv= new SinhVien();
        sv.setHoTen(txt_hoten.getText().toString());
        sv.setTuoi(Integer.parseInt(txt_tuoi.getText().toString()));
        databaseManager.addSV(sv);
        Toast.makeText(this,"Add thanh cong",Toast.LENGTH_SHORT);
    }

    public void nextClick(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }
}

package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton Add;
    ImageButton Sub;
    ImageButton Mul;
    ImageButton Div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Add=findViewById(R.id.imageButton);
        Sub=findViewById(R.id.imageButton2);
        Mul=findViewById(R.id.imageButton3);
        Div=findViewById(R.id.imageButton4);

        Add.setOnClickListener(v -> openAddActivity());

        Sub.setOnClickListener(v -> openSubActivity());

        Mul.setOnClickListener(v -> openMulActivity());

        Div.setOnClickListener(v -> openDivActivity());
    }
    public void openAddActivity(){
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
    public void openSubActivity(){
        Intent intent = new Intent(this,SubActivity.class);
        startActivity(intent);
    }
    public void openMulActivity(){
        Intent intent = new Intent(this,MulActivity.class);
        startActivity(intent);
    }
    public void openDivActivity(){
        Intent intent = new Intent(this,DivActivity.class);
        startActivity(intent);
    }

}
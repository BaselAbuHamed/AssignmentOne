package com.example.assignmentone;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.assignmentone.Model.DAOperation;
import com.example.assignmentone.Model.Operation;

import java.util.ArrayList;

public class Review extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_recycler);

        DAOperation daOperation = new DAOperation(getApplicationContext());
        Intent intent= getIntent();
        char equation = (Character)intent.getCharExtra("Equation",'0');
        ArrayList<Operation> operations = daOperation.getEquation(equation);

        RecyclerView recycler = findViewById(R.id.rev_recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        ReviewAdapter adapter = new ReviewAdapter(operations);
        recycler.setAdapter(adapter);
    }
}

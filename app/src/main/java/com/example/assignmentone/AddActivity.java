package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.assignmentone.Model.DAOperation;
import com.example.assignmentone.Model.Operation;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    RadioButton a ;
    RadioButton b ;
    RadioButton c ;
    RadioButton d ;
    Button n;
    int count=0;
    ArrayList <Operation> temp=new ArrayList<>();
    TextView equation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        a=findViewById(R.id.A);
        b=findViewById(R.id.B);
        c=findViewById(R.id.C);
        d=findViewById(R.id.D);

        n=findViewById(R.id.next);

        equation=findViewById(R.id.equation);

        DAOperation daOperation = new DAOperation();

        for (int i = 0; i <daOperation.operations.size() ; i++) {

            if(daOperation.operations.get(i).getOperation()=='+'){
                System.out.println(daOperation.operations.get(i).getOperation());
                temp.add(daOperation.operations.get(i));
            }

        }

        equation.setText(temp.get(0).getEquation());

        System.out.println(temp.get(0).getChoice()[1]);
        a.setText(temp.get(0).getChoice()[0]+"");
        b.setText(temp.get(0).getChoice()[1]+"");
        c.setText(temp.get(0).getChoice()[2]+"");
        d.setText(temp.get(0).getChoice()[3]+"");

        n.setOnClickListener(v -> {
            if(count!=daOperation.operations.size()){
                count++;
                equation.setText(temp.get(count++).getEquation());

                a.setText(temp.get(count).getChoice()[0]+"");
                b.setText(temp.get(count).getChoice()[1]+"");
                c.setText(temp.get(count).getChoice()[2]+"");
                d.setText(temp.get(count).getChoice()[3]+"");
            }
        });
    }
}
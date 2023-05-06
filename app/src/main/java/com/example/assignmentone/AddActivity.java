package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmentone.Model.DAOperation;
import com.example.assignmentone.Model.Operation;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    RadioButton a ;
    RadioButton b ;
    RadioButton c ;
    RadioButton d ;

    RadioGroup rg;
    Button n;
    int count=0;

    ImageView image;
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
        rg=findViewById(R.id.radioGroub);
        n=findViewById(R.id.next);
        image=findViewById(R.id.imageView);

        image.setVisibility(View.GONE);
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

            int tmpRG=rg.getCheckedRadioButtonId();

            if (tmpRG==-1){
                Toast.makeText(this, "pleas select your answer", Toast.LENGTH_SHORT).show();
            }
            else{
                RadioButton tmpRadio=findViewById(tmpRG);
                int tmpChoice=Integer.parseInt(String.valueOf(tmpRadio.getText()));

                if(temp.get(count).getCorrectChoice()==tmpChoice){
                    if(count<temp.size()-1){
                        rg.clearCheck();
                        count++;
                        equation.setText(temp.get(count).getEquation());

                        a.setText(temp.get(count).getChoice()[0]+"");
                        b.setText(temp.get(count).getChoice()[1]+"");
                        c.setText(temp.get(count).getChoice()[2]+"");
                        d.setText(temp.get(count).getChoice()[3]+"");

                        Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        rg.setVisibility(View.GONE);
                        n.setVisibility(View.GONE);
                        equation.setVisibility(View.GONE);
                        image.setVisibility(View.VISIBLE);
                    }
                }

                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
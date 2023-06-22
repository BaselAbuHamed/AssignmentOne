package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class SubActivity extends AppCompatActivity {

    RadioButton a ;
    RadioButton b ;
    RadioButton c ;
    RadioButton d ;

    RadioGroup rg;
    Button n;
    int count=0;

    ImageView image;
    ArrayList<Operation> temp=new ArrayList<>();
    TextView equation;
    int countMark=10;
    Button check;
    TextView mark;
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
        check=findViewById(R.id.check);
        image=findViewById(R.id.imageView);
        mark=findViewById(R.id.mark);

        image.setVisibility(View.GONE);
        equation=findViewById(R.id.equation);

        DAOperation daOperation = new DAOperation(getApplicationContext());
        ArrayList<Operation> operations = daOperation.getOperations();

        for (int i = 0; i <operations.size() ; i++) {

            if(operations.get(i).getOperation()=='-'){
                temp.add(operations.get(i));
            }
        }

        equation.setText(temp.get(0).getEquation());

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

                        mark.setVisibility(View.VISIBLE);
                        check.setVisibility(View.VISIBLE);
                        check.setOnClickListener(view -> openReviewActivity());
                    }
                }

                else {
                    Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                    countMark--;

                    if(count<temp.size()-1){
                        rg.clearCheck();
                        count++;
                        equation.setText(temp.get(count).getEquation());

                        a.setText(temp.get(count).getChoice()[0]+"");
                        b.setText(temp.get(count).getChoice()[1]+"");
                        c.setText(temp.get(count).getChoice()[2]+"");
                        d.setText(temp.get(count).getChoice()[3]+"");
                    }
                    else{
                        rg.setVisibility(View.GONE);
                        n.setVisibility(View.GONE);
                        equation.setVisibility(View.GONE);
                        mark.setText(countMark+"/10");
                        image.setVisibility(View.VISIBLE);

                        mark.setVisibility(View.VISIBLE);
                        check.setVisibility(View.VISIBLE);
                        check.setOnClickListener(view -> openReviewActivity());

                    }

                    if (countMark<5){
                        Toast.makeText(this, "you lose game", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void openReviewActivity(){
        Intent intent = new Intent(this,Review.class);
        intent.putExtra("Equation",'-');
        startActivity(intent);
    }
}
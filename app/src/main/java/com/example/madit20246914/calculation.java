package com.example.madit20246914;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculation extends AppCompatActivity {
    EditText name1;
    EditText age1;            //These are global variables
    TextView txt_answer;
    Button btn_calculation;

    String name;
    String age;

    int c;
    int c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        name1 = findViewById(R.id.name1);
        age1 = findViewById(R.id.age1);
        btn_calculation = findViewById(R.id.btn_calculation);
        txt_answer = findViewById(R.id.txt_answer);

        //capture the intent
        Intent intent= getIntent();
        name = intent.getStringExtra("n1");
        age = intent.getStringExtra("a1");

        name1.setText(name);
        age1.setText(age);


        c = Integer.parseInt(age);

        btn_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(c<=12){
                   txt_answer.setText(name+ " You must take Pfizer vaccine");
               }else if(c<=40){
                   txt_answer.setText(name+ "You must take Sinophram vaccine");
               }else{
                   txt_answer.setText(name+ "You must take Astrazeneca vaccine");
               }
            }
        });



    }

}
















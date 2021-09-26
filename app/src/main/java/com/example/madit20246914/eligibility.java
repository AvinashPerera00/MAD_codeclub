package com.example.madit20246914;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class eligibility extends AppCompatActivity {
    EditText name1;
    EditText age1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        name1 = findViewById(R.id.name1);
        age1 = findViewById(R.id.age1);


    }
    public void next(View view){
        //making the intent
        Intent intent = new Intent(this, calculation.class);
        //Assign them to string value
        String name_1 = name1.getText().toString();
        String age_1 = age1.getText().toString();

        intent.putExtra("n1",name_1);
        intent.putExtra("a1",age_1);

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.custom_toast, findViewById(R.id.ed_toast));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setView(layout);
        toast.show();


        //start the intent
        startActivity(intent);
    }
}
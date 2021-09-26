package com.example.madit20246914;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madit20246914.database.DBHelper;

import java.util.List;

public class EditProf extends AppCompatActivity {
    EditText edt_name,edt_nic;
  //  Button btn_addmember,btn_updatemember,btn_deletemember,btn_selectmember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prof);
        edt_name = findViewById(R.id.edt_name);
        edt_nic = findViewById(R.id.edt_nic);




    }
    //Button click event
    public void saveFam(View view){
        String name = edt_name.getText().toString();
        String nic = edt_nic.getText().toString();


        DBHelper dbhelper = new DBHelper(this);

        if(name.isEmpty()||nic.isEmpty()){
            Toast.makeText(this, "Enter username and password" , Toast.LENGTH_SHORT).show();
        }else{
            long inserted =dbhelper.addFam(name,nic); //Getting how many rows are there.
            if(inserted >0){
                Toast.makeText(this, "Insert success" , Toast.LENGTH_SHORT).show();
                edt_name.setText("");
                edt_nic.setText("");

            }else{
                Toast.makeText(this, "Insert unsuccess" , Toast.LENGTH_SHORT).show();
            }
        }



    }

    public void viewFam(View view){
        DBHelper dbHelper = new DBHelper(this);

        List info = dbHelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Family details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = infoArray[which].split(":")[0];
                String nic = infoArray[which].split(":")[0];

                edt_name.setText(name);
                edt_nic.setText("***********");


            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void updateFam(View view){
        DBHelper dbHelper = new DBHelper(this);
        String name =  edt_name.getText().toString();
        String nic =  edt_nic.getText().toString();

        if(name.isEmpty()||nic.isEmpty()){
            Toast.makeText(this, "Select or type user" , Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.updateInfo(view,name,nic);
            edt_name.setText("");
            edt_nic.setText("");
        }


    }

    public void deleteUser(View view){
        DBHelper dbHelper = new DBHelper(this);
        String name =  edt_name.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this, "Select a user" , Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.deleteInfo(name);
            Toast.makeText(this, "Deleted successfully" , Toast.LENGTH_SHORT).show();
            edt_name.setText("");
            edt_nic.setText("");
        }
    }

}
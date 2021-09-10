package com.example.myfirst;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ename;
    private EditText epassword;
    private Button elogin;
    private TextView eattemptsinfo;

    private final String Username = "rahul";
    private final String Password = "rahul1234";

    boolean isvalid = false;
    private int counter = 5;

    public MainActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.etname);
        epassword = findViewById(R.id.etpassword);
        elogin = findViewById(R.id.btnlogin);
        eattemptsinfo = findViewById(R.id.tvattemptsinfo);

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputname = ename.getText().toString();
                String inputpassword = epassword.getText().toString();

                if(inputname.isEmpty() || inputpassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter the necessary details",Toast.LENGTH_SHORT).show();
            }else{
                    isvalid=validate(inputname,inputpassword);
                    if(!isvalid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                        eattemptsinfo.setText("Attempts remaining: "+counter);

                        if (counter == 0) {
                            elogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        //Add new activity

                        Intent intent= new Intent(MainActivity.this, Home_Page_Activity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
    private boolean validate(String name,String password) {
        if(name.equals(Username) && password.equals(Password)) {
            return true;
        }
        return false;
    }
}
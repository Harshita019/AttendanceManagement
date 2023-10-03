package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user, password, loginId, empPassword;
    private Button login, admin, empLogin, empLayer;

    LinearLayout l_admin, l_employee;
    private DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = findViewById(R.id.bt_admin);
        l_admin = findViewById(R.id.ll_admin);
        l_employee = findViewById(R.id.ll_employee);
        login = findViewById(R.id.bt_login);

        empLayer = findViewById(R.id.bt_openEmplayer);
        empLogin = findViewById(R.id.bt_empLogin);

        user = findViewById(R.id.et_user);
        password = findViewById(R.id.et_pass);
        loginId = findViewById(R.id.et_loginID);
        empPassword = findViewById(R.id.et_password);



                dbHandler = new DBHandler(MainActivity.this);

                admin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        l_admin.setVisibility(View.VISIBLE);

                        login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String str_user = user.getText().toString();
                                String str_pass = password.getText().toString();

                                if (str_user.equals("") || str_pass.equals("")) {
                                    Intent i = new Intent(MainActivity.this, AdminPanel.class);
                                    startActivity(i);
                                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                    user.setText("");
                                    password.setText("");


                                }

                                else{

                                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                                }



                            }
                        });
                    }
                });

        empLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_loginId = loginId.getText().toString();
                String str_empPassword = empPassword.getText().toString();

                if(str_loginId.equals("")||str_empPassword.equals(""))
                    Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = dbHandler.checkNamePassword(str_loginId, str_empPassword);
                    if(checkCredentials == true){
                        Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(MainActivity.this, EmployeeAttendance.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        /*empLayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l_employee.setVisibility(View.VISIBLE);

                empLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       String str_loginId = loginId.getText().toString();
                       String str_empPassword = empPassword.getText().toString();

                        if(str_loginId.equals("")||str_empPassword.equals(""))
                            Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                        else{
                            Boolean checkCredentials = dbHandler.checkNamePassword(str_loginId, str_empPassword);
                            if(checkCredentials == true){
                                Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                *//*Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);*//*
                            }else{
                                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
            }
        });*/



            }
        }

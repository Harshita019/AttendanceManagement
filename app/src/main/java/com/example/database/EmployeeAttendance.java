package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeAttendance extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    TextView time, date;

    DBHandler dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_attendance);

        dbHandler = new DBHandler(EmployeeAttendance.this);

        radioGroup = findViewById(R.id.radio_group);
        time = findViewById(R.id.tv_time);
        date = findViewById(R.id.tv_date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String currentDate = sdf.format(new Date());
        String currentTime = sdf1.format(new Date());

        //time.setText(currentDateandTime);
        time.setText(currentTime);
        date.setText(currentDate);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(EmployeeAttendance.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    String selectedRadio = radioButton.getText().toString();
                    Toast.makeText(EmployeeAttendance.this,radioButton.getText(), Toast.LENGTH_SHORT).show();
                    dbHandler.addAttendance(currentTime, currentDate, selectedRadio);

                    Toast.makeText(EmployeeAttendance.this, "Attendance has been added.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewAttendance extends AppCompatActivity {
    private ArrayList<AttendanceModal> attendanceModalArrayList;
    private DBHandler dbHandler;
    private AttendanceRvAdapter attendanceRVAdapter;
    private RecyclerView attendanceRV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);


        // initializing our all variables.
        attendanceModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewAttendance.this);

        // getting our course array
        // list from db handler class.
        attendanceModalArrayList = dbHandler.readAttendance();

        // on below line passing our array list to our adapter class.
        attendanceRVAdapter = new AttendanceRvAdapter(attendanceModalArrayList, ViewAttendance.this);

        attendanceRV = findViewById(R.id.idRVAttendance);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewAttendance.this, RecyclerView.VERTICAL, false);
        attendanceRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        attendanceRV.setAdapter(attendanceRVAdapter);

    }
}
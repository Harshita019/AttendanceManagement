package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {
    private ArrayList<EmployeeModal> courseModalArrayList;
    private DBHandler dbHandler;
    private EmployeeRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        

                // initializing our all variables.
                courseModalArrayList = new ArrayList<>();
                dbHandler = new DBHandler(ViewCourses.this);

                // getting our course array
                // list from db handler class.
                courseModalArrayList = dbHandler.readCourses();

                // on below line passing our array list to our adapter class.
                courseRVAdapter = new EmployeeRVAdapter(courseModalArrayList, ViewCourses.this);
                coursesRV = findViewById(R.id.idRVCourses);

                // setting layout manager for our recycler view.
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
                coursesRV.setLayoutManager(linearLayoutManager);

                // setting our adapter to recycler view.
                coursesRV.setAdapter(courseRVAdapter);

    }
}
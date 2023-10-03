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

public class AdminPanel extends AppCompatActivity {

    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn, addEmp, readAttendanceBtn;

    LinearLayout l_addEmp;

    private DBHandler dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_panel);
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);
        readAttendanceBtn = findViewById(R.id.idBtnReadAttendance);

        addEmp = findViewById(R.id.bt_addEmp);
        l_addEmp = findViewById(R.id.ll_addEmp);

        dbHandler = new DBHandler(AdminPanel.this);

        addEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l_addEmp.setVisibility(View.VISIBLE);
                addCourseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String courseName = courseNameEdt.getText().toString();
                        String courseTracks = courseTracksEdt.getText().toString();
                        String courseDuration = courseDurationEdt.getText().toString();
                        String courseDescription = courseDescriptionEdt.getText().toString();

                        // validating if the text fields are empty or not.
                        if (courseName.isEmpty() || courseTracks.isEmpty() || courseDuration.isEmpty() || courseDescription.isEmpty()) {
                            Toast.makeText(AdminPanel.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        dbHandler.addNewCourse(courseName, courseDuration, courseDescription, courseTracks);

                        Toast.makeText(AdminPanel.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                        courseNameEdt.setText("");
                        courseDurationEdt.setText("");
                        courseTracksEdt.setText("");
                        courseDescriptionEdt.setText("");
                    }
                });
            }
        });

        readCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(AdminPanel.this, ViewCourses.class);
                startActivity(i);
            }
        });

        readAttendanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(AdminPanel.this, ViewAttendance.class);
                startActivity(i);
            }
        });


    }
}
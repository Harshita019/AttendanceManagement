package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "AttendanceDB";

    private static final int DB_VERSION = 2;

    private static final String TABLE_NAME = "mycourses";
    private static final String ATTENDANCE_TABLE = "attendanceTabe";

    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String DEPARTMENT_COL = "department";

    private static final String LOGINID_COL = "loginId";

    private static final String PASSWORD_COL = "password";

    private static final String DATE_COL = "date";
    private static final String TIME_COL = "time";
    private static final String REMARK_COL = "remark";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DEPARTMENT_COL + " TEXT,"
                + LOGINID_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";


        String attendancequery = "CREATE TABLE " + ATTENDANCE_TABLE + " ("
                + DATE_COL + " TEXT,"
                + TIME_COL + " TEXT,"
                + REMARK_COL + " TEXT)";

        db.execSQL(query);
        db.execSQL(attendancequery);
    }

    public void addAttendance( String date, String time, String remark) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DATE_COL, date);
        values.put(TIME_COL, time);
        values.put(REMARK_COL, remark);

        db.insert(ATTENDANCE_TABLE, null, values);

        db.close();
    }


    public void addNewCourse(String empName, String empDepartment, String empLoginId, String empPassword) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, empName);
        values.put(DEPARTMENT_COL, empDepartment);
        values.put(LOGINID_COL, empLoginId);
        values.put(PASSWORD_COL, empPassword);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<AttendanceModal> readAttendance() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorAttendance = db.rawQuery("SELECT * FROM " + ATTENDANCE_TABLE, null);

        ArrayList<AttendanceModal> attendanceModalArrayList = new ArrayList<>();

        if (cursorAttendance.moveToFirst()) {
            do {
                attendanceModalArrayList.add(new AttendanceModal(
                        cursorAttendance.getString(1),
                        cursorAttendance.getString(3),
                        cursorAttendance.getString(2)));
            } while (cursorAttendance.moveToNext());
        }
        cursorAttendance.close();
        return attendanceModalArrayList;
    }


    public String fetchData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String result = "";
        Cursor cursor = db.query(TABLE_NAME, new String[]{NAME_COL}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            result = cursor.getString(0); // Assuming the data is in the first column
        }

        cursor.close();
        return result;
    }


    public ArrayList<EmployeeModal> readCourses() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorEmployee = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<EmployeeModal> courseModalArrayList = new ArrayList<>();

        if (cursorEmployee.moveToFirst()) {
            do {
                courseModalArrayList.add(new EmployeeModal(
                        cursorEmployee.getString(1),
                        cursorEmployee.getString(4),
                        cursorEmployee.getString(2),
                        cursorEmployee.getString(3)));
            } while (cursorEmployee.moveToNext());
        }
        cursorEmployee.close();
        return courseModalArrayList;
    }

    public Boolean checkNamePassword(String empName, String empPass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor empCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME+ " where " + NAME_COL + " = ? and " + PASSWORD_COL+" = ?", new String[]{empName, empPass});
        if (empCursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ATTENDANCE_TABLE);
        onCreate(db);
    }
}

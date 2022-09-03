package com.techexplorer.notessharing;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String dbname = "sharehistory.db";

    public Database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table users(id integer primary key autoincrement, name text, email text, phone integer, institute_name text, student_id integer, course text, password text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    public boolean insert_data(String name, String email, Integer phone, String institute_name, Integer student_id, String course, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("institute_name", institute_name);
        contentValues.put("student_id", student_id);
        contentValues.put("course", course);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
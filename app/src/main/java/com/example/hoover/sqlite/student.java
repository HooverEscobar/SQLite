package com.example.hoover.sqlite;

/**
 * Created by Usuario on 2/8/2016.
 */
class Student {
    // Labels table name
    public static final String TABLE = "Student";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_apellido = "apellido";
    public static final String KEY_email = "email";
    public static final String KEY_direccion = "direccion";

    // property help us to keep data
    public int student_ID;
    public String name;
    public String apellido;
    public String email;
    public String direccion;
}
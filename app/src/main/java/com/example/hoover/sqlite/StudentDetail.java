package com.example.hoover.sqlite;

/**
 * Created by Usuario on 2/8/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentDetail extends AppCompatActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextApellido;
    EditText editTextEmail;
    EditText editTextDireccion;

    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextDireccion = (EditText) findViewById(R.id.editTextDireccion);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);

        editTextDireccion.setText(student.direccion);
        editTextName.setText(student.name);
        editTextApellido.setText(student.apellido);
        editTextEmail.setText(student.email);
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.direccion=editTextDireccion.getText().toString();
            student.email=editTextEmail.getText().toString();
            student.name=editTextName.getText().toString();
            student.apellido=editTextApellido.getText().toString();
            student.student_ID=_Student_Id;

            if (_Student_Id==0){
                _Student_Id = repo.insert(student);

                Toast.makeText(this,"Nuevo estudiante ingresado",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(student);
                Toast.makeText(this,"Estudiante Actualizado",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            StudentRepo repo = new StudentRepo(this);
            repo.delete(_Student_Id);
            Toast.makeText(this, "Estudiante eliminado", Toast.LENGTH_SHORT).show();
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}